package com.ftn.modul3.zavrsni.jwd.Utakmice;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class UtakmiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtakmiceApplication.class, args);
	}
	
	 @Bean
	    public CommandLineRunner loadData(DataSource dataSource) {
	        return args -> {
	            Resource resource = new ClassPathResource("data.sql");
	            ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);
	        };
	    }

}
