package org.java.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //产生shiroFactory类
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置拦截器，设置哪些路径可以匿名访问，哪些需要拦截认证

        //拦截器
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<String,String>();

        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/**", "authc");

        //如果不设置，则默认会自动找根目录下的---------------如果用户还没有登录，就会发出login请求，进入控制器，然后进入到对应的页面登录
        shiroFilterFactoryBean.setLoginUrl("/login");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    //提供安全管理器
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager(myRealm());
        securityManager.setCacheManager(ehCacheManager());

        return securityManager;
    }

    //提供realm
    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm=new MyRealm();
//        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }

    //配置缓存
    @Bean
    public EhCacheManager ehCacheManager(){
        //System.out.println("ShiroConfiguration.getEhCacheManager()");
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/shiro-ehcache.xml");
        return cacheManager;
    }


      //密码匹配方式
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("MD5");// 散列算法:这里使用MD5算法;
//        hashedCredentialsMatcher.setHashIterations(1);// 散列的次数，比如散列两次，相当于
//        return hashedCredentialsMatcher;
//    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
