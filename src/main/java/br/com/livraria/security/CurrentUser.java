package br.com.livraria.security;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.livraria.daos.SecurityDAO;
import br.com.livraria.models.SystemUser;

@Model
public class CurrentUser {

	@Inject
    private HttpServletRequest request;

    @Inject
    private SecurityDAO securityDAO;

    private SystemUser systemUser;
	    
    @PostConstruct
    private void loadSystemUser() {
    	Principal principal = request.getUserPrincipal();
        if (principal != null) {
            String email = request.getUserPrincipal().getName();
            systemUser = securityDAO.findByEmail(email);
        }
    }
	
    public SystemUser get() {
    	return systemUser;
    }
    
    public boolean hasRole(String role) {
    	return request.isUserInRole(role);
    }
    
    public String logout() {
    	request.getSession().invalidate();
    	return "/livros/lista.xhtml?faces-redirect=true";
    }
    
}