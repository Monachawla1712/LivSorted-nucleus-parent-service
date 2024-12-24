package com.sorted.rest.services.main;

import com.sorted.rest.common.constants.ApplicationProfiles;
import com.sorted.rest.common.constants.CommonConstants;
import com.sorted.rest.common.dbsupport.crud.BaseCrudRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages = { CommonConstants.BASE_PACKAGE })
@EnableJpaRepositories(basePackages = CommonConstants.BASE_PACKAGE, repositoryBaseClass = BaseCrudRepositoryImpl.class)
@EntityScan(CommonConstants.BASE_PACKAGE)
@EnableSwagger2
@EnableFeignClients(basePackages = { CommonConstants.BASE_PACKAGE })
public class NucleusServiceApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(NucleusServiceApplication.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		if (System.getProperty(CommonConstants.SPRING_PROFILE_ACTIVE_KEY) == null) {
			System.setProperty(CommonConstants.SPRING_PROFILE_ACTIVE_KEY, ApplicationProfiles.LOCAL);
		}
		application.run(args);
	}
}