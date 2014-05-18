package com.john_g_shultz.site.config;

import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Configuration
public class ThymeleafConfiguration {

    @Inject
    private ThymeleafViewResolver thymeleafViewResolver;

    @PostConstruct
    private void init() {
        thymeleafViewResolver.setViewNames(new String[]{"error", "/tl/*"});
    }
}
