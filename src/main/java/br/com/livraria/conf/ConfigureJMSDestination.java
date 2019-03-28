package br.com.livraria.conf;

import javax.ejb.Singleton;
import javax.jms.JMSDestinationDefinition;

@JMSDestinationDefinition(name="java:/jms/topics/CarrinhoComprasTopico", interfaceName="javax.jms.Topic")
@Singleton
public class ConfigureJMSDestination {

}
