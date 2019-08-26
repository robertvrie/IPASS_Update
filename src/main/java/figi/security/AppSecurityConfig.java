package figi.security;

import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	private GebruikerDetailsService gebruikerDetailsService;

	public AppSecurityConfig(GebruikerDetailsService gebruikerDetailsService) {
		this.gebruikerDetailsService = gebruikerDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/home").permitAll()
				.antMatchers("/zaal", "/zaal/", "/zaal/**").hasRole("MANAGEMENT")
				.antMatchers("/filmInfo", "/filmInfo/", "/filmInfo/**").hasRole("MANAGEMENT")
				.antMatchers("/film", "/film/", "/film/**").hasAnyRole("MANAGEMENT", "MEDEWERKER")
				.antMatchers("/profiel/verwijderen", "/profiel/verwijderen/").hasAnyRole("GEBRUIKER", "MANAGEMENT")
				.antMatchers("/films/reserveren", "/films/reserveren/", "films/reserveren/**").hasRole("GEBRUIKER")
				.antMatchers("/profiel", "/profiel/", "/profiel/**").authenticated()
				.antMatchers("/registreren", "/registreren/", "/registreren/**").anonymous()
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/loguit")).logoutSuccessUrl("/home");
	}

	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.gebruikerDetailsService);

		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
