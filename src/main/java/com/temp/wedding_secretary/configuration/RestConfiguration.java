package com.temp.wedding_secretary.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.temp.wedding_secretary.dao"})
public class RestConfiguration {
}
