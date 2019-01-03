package com.yto.mdm;

import com.idsmanager.sso.client.spring.SingleSignOnFilterConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.yto.mdm"})
@ServletComponentScan(basePackages = {"com.yto.mdm.filter"})
@Import({SingleSignOnFilterConfiguration.class})
public class AppApplication {

    public static void main( String[] args )
    {
        new SpringApplicationBuilder(AppApplication.class).web(true).run(args);
    }
}

