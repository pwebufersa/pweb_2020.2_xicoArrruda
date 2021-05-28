package br.com.xico.cadpessoas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class SegurancaEmMemoria {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
		builder.inMemoryAuthentication().
				withUser("xico").password("{noop}123").roles("ADMIN");
		
		/*
		.withUser("xico").password("$2a$10$JvyF9q/k/eYwXTVjc4Ay0OT/dCwjW14eT88q3e587jaENTvtt30s2").
		roles("GERENTE_PROJETOS", "GERENTE_RH")
		 */
		
	}

}

