package Star.CS.whu.SpringBootBook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * <h2>安全配置</h2>
     * (1)  用<code>permitAll()</code>配置了允许任何人访问的方法：匹配 CSS，JS，FONTS 和 index 页面。<br />
     * (2)  匹配<code>/users</code>的 URL 请求需要有"ADMIN"角色的用户才能访问。<br />
     * (3)  <code>formLogin()</code>表明了这是个基于表单的身份验证，配置了登录的 URL 路径和登录失败的 URL。
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置访问权限
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index") //静态资源
                .permitAll() // 都可以直接访问
                .antMatchers("/users/**") //users 相关页面
                .hasRole("ADMIN") // 需要相应的角色才能访问
                .and()
                .formLogin() // 基于 form 表单登录验证
                .loginPage("/login").failureUrl("/login-error");//自定义登录页面和登录失败页面
    }

    /**
     * 创建了基于内存的身份认证管理器，存储了用户名为 xhx，密码为123456，角色为 ADMIN 的身份信息。名称可以是任意的，但是类必须要有
     * <code>@EnableWebSecurity</code> or <code>@EnableGlobalMethodSecurity</code> or <code>@EnableGlobalAuthentication</code>注解。
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() // 认证信息存储在内存中
                .withUser("xhx").password("123456").roles("ADMIN");
    }

}
