package com.projetPharmV2.dao;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.projetPharmV2.entities.Client;
import com.projetPharmV2.entities.dao.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan
@EntityScan(basePackageClasses=Client.class)
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses=ClientRepository.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientDaoTest {

	@Autowired
	private ClientRepository clientRepository;

	private static Long NIR=123456789L;
	private static String NOM_CLIENT="Chaou";
	private static String PRENOM_CLIENT="Mohamed Redha";
	private static String ADRESSE_CLIENT = "Tours";
	private static String TELEPHONE_CLIENT="0658967742";
	@Test
	public void test1AddClient() {
		Client client =new Client(NIR, NOM_CLIENT, PRENOM_CLIENT, ADRESSE_CLIENT, TELEPHONE_CLIENT);
		clientRepository.save(client);
	}
	@Test
	public void test2GetClient() {
		Client client = clientRepository.findOne(NIR);
		Assert.assertNotNull(client);

	}

}
