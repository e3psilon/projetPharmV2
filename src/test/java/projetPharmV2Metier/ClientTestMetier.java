package projetPharmV2Metier;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.projetPharmV2.entities.Client;
import com.projetPharmV2.metier.ClientMetier;


@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan(basePackages={"com.projetPharmV2.*"})
@EntityScan("com.projetPharmV2.entities")
@EnableAutoConfiguration
@EnableJpaRepositories("com.projetPharmV2.*")
public class ClientTestMetier {


	@Autowired(required=true)
	private ClientMetier clientMetier;
	@Test
	public void testGetClient(){
		List<Client> clients = clientMetier.listeClient();
		Assert.assertNotNull(clients);

	}

}
