package com.lespickup.controller;

/**
 * Created by vanderson1271 on 5/26/18.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.lespickup")
public class SConfig extends AnnotationConfigWebApplicationContext{


}
