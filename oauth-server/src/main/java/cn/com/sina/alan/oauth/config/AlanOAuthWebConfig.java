package cn.com.sina.alan.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 */
@Configuration
public class AlanOAuthWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public DataSource dataSource;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//    }

    // 让自定义的Login页面可以被访问到
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        super.configure(http);
        http.formLogin();
//                .authorizeRequests().antMatchers("/login").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/oauth/confirm_access").permitAll()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
        // @formatter:on
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
//        // @formatter:on
//    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/favor.ico");
    }

//    @Bean
//    public JdbcUserDetailsManager jdbcUserDetailsManager() {
//        return new JdbcUserDetailsManager();
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//                return jdbcUserDetailsManager().loadUserByUsername(s);
//            }
//        };
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("reader")
//                .password("reader")
//                .authorities("FOO_READ")
//                .and()
//                .withUser("writer")
//                .password("writer")
//                .authorities("FOO_READ", "FOO_WRITE");

//        UserDetails userDetails = userDetailsService().loadUserByUsername("reader");
//        System.out.println(userDetails.getPassword());

        auth.jdbcAuthentication().dataSource(dataSource);
        UserDetails userDetails = userDetailsService().loadUserByUsername("reader");
        System.out.println(userDetails.getPassword());
    }

    @Configuration
    protected static class LoginConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login").setViewName("login");
//            registry.addViewController("/oauth/confirm_access").setViewName("authorize");
        }
    }
}
