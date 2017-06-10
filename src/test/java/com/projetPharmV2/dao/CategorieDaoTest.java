package com.projetPharmV2.dao;

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

import com.projetPharmV2.entities.Categorie;
import com.projetPharmV2.entities.Client;
import com.projetPharmV2.entities.dao.CategorieRepository;
import com.projetPharmV2.metier.util.AttributUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan
@EntityScan(basePackageClasses = Client.class)
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses = CategorieRepository.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategorieDaoTest {



		@Autowired
		private CategorieRepository categorieRepository;

		@Test
		public void test1AddCategorie() {
			Categorie categorie = new Categorie(AttributUtil.DESIGNATION, AttributUtil.DESCRIPTION, null, null);
			categorieRepository.save(categorie);
		}

}