package com.example.JavaSpring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration //Diz ao Spring que esta classe contém configurações de aplicação
@EnableWebSecurity //Ativa os recursos de segurança do Spring Security
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter; //Filtro que será usado para verificar tokens JWT nas requisições
    private final UserDetailsService userDetailsService; //Serviço que busca os detalhes do usuario

    public SecurityConfig(JwtAuthFilter jwtAuthFilter, UserDetailsService userDetailsService) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    //Configura as regras de segurança da aplicação
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//DEFINE QUE A API NÃO CRIARÁ SESSÕES DO USUARIO
                .authorizeHttpRequests(auth -> auth.requestMatchers("/auth/**").permitAll().anyRequest().authenticated()) //Qualquer requisição para /auth/ será permitida em login e as outras requisições precisarão de login
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); //Adiciona o filtro JWT antes do filtro padrão de autenticação, garantindo que todas as requisições passem primeiro pelo filtro JWT.

                return http.build(); //Finaliza a configuração e retorna a cadeia de filtros de segurança

    }

    @Bean
    public AuthenticationManager authenticationManager(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); //Buscará os detalhes do usuario
        authProvider.setUserDetailsService(userDetailsService); //Buscará os usuarios no banco
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder()); //Validará a senha corretamente
        return new ProviderManager(authProvider); //retorna com o provedor configurado


    }


}
