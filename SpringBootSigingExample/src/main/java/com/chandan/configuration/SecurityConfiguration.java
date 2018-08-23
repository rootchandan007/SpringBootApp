package com.chandan.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//package com.chandan.configuration;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.chandan.service.UserDetailsServiceImpl;
//
//
//
//
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(HttpSecurity security) throws Exception
    {
     security.httpBasic().disable();
    }
}
//
// @Autowired
// private BCryptPasswordEncoder bCryptPasswordEncoder;
// 
// @Autowired
//	private UserDetailsServiceImpl userDetailsServiceImpl;
// 
// @Autowired
// private DataSource dataSource;
// //"select email, password, active from user where email=?";
// private final String USERS_QUERY = "select email, password from users where email=?";
// private final String ROLES_QUERY = "select u.email, u.role from users u where u.email=?";
// //private final String ROLES_QUERY = "select u.email, r.role from users u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";
//
// @Override
// protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	 System.out.println("Security "+ROLES_QUERY+""+USERS_QUERY);
//  auth.jdbcAuthentication()
//   .usersByUsernameQuery(USERS_QUERY)
//   .authoritiesByUsernameQuery(ROLES_QUERY)
//   .dataSource(dataSource)
//   .passwordEncoder(bCryptPasswordEncoder);
// }
// 
// @Override
// protected void configure(HttpSecurity http) throws Exception{
//  http.authorizeRequests()
//   .antMatchers("/").permitAll()
//   .antMatchers("/signin").permitAll()
//  // .antMatchers("/signup").permitAll()
//  // .antMatchers("/home/**").hasAuthority("ADMIN").anyRequest()
//   .antMatchers("/home/**").hasAnyRole("ADMIN","USER").anyRequest()
//   .authenticated().and().csrf().disable()
//   .formLogin().loginPage("/signin").failureUrl("/signin?error=true")
//   .defaultSuccessUrl("/home/home")
//   .usernameParameter("email")
//   .passwordParameter("password")
//   .and().logout()
//   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//   .logoutSuccessUrl("/")
//   .and().rememberMe()
//   //.tokenRepository(persistentTokenRepository())
//   //.tokenValiditySeconds(60*60)
//   
//   .and().exceptionHandling().accessDeniedPage("/access_denied");
// }
// 
// @Bean
// public PersistentTokenRepository persistentTokenRepository() {
//  JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//  db.setDataSource(dataSource);
//  
//  return db;
// }
// 
// @Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
// 	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
//	}
//}
//
//
////@Configuration
////@EnableWebSecurity
////public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//// 
////  // @Autowired
////    //private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
////    @Autowired
////	//private UserDetailsServiceImpl userDetailsServiceImpl;
//// 
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////          .withUser("user1").password(passwordEncoder().encode("user1Pass"))
////          .authorities("ROLE_USER");
////    }
//// 
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////          .antMatchers("/securityNone").permitAll()
////          .anyRequest().authenticated()
////          .and()
////          .httpBasic()
////          .authenticationEntryPoint(authenticationEntryPoint);
//// 
////        http.addFilterAfter(new CustomFilter(),
////          BasicAuthenticationFilter.class);
////    }
//// 
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////}