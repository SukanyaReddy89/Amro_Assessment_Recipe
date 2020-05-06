package com.abnamro.recipe;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.abn.backend.ejb.CaloriesProcessor;
import com.abn.backend.ejb.ProtiensProcessor;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.abnamro.recipe", "com.abnamro.recipe.api" , "com.abnamro.recipe.configuration"})
public class RecipeApplication implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(RecipeApplication.class).run(args);
    }
    
    @Bean   
    public Context context() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        jndiProps.put("java.naming.provider.url", "http-remoting://localhost:8082");
        return new InitialContext(jndiProps);
    }

    @Bean
    public CaloriesProcessor caloriesProcessor(Context context) throws NamingException {
        return (CaloriesProcessor) context.lookup(this.getFullName(CaloriesProcessor.class));
    }
    
    
    @Bean
    public ProtiensProcessor protiensProcessor(Context context) throws NamingException {
        return (ProtiensProcessor) context.lookup(this.getFullName(ProtiensProcessor.class));
    }
    
    @SuppressWarnings("rawtypes")
    private String getFullName(Class classType) {
        String moduleName = "ServiceLayer-0.0.1-SNAPSHOT/";
        String beanName = classType.getSimpleName();
        String viewClassName = classType.getName();
        
        return moduleName + beanName + "!" + viewClassName;
    }
    
    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
