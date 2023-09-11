package growby.asistencia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		 httpSecurity
				.csrf(config -> config.disable())
				.authorizeHttpRequests( auth -> {
					auth.requestMatchers("/empleados/listar").permitAll();
					auth.anyRequest().authenticated();
            })
		 .formLogin().permitAll()
		 .and()
		 .httpBasic()
		 .and();
		 return httpSecurity .build();
		}
}