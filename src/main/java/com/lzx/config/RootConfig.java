package com.lzx.config;

import com.lzx.redis.RedisConfig;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.lzx.config"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)}
)
@EnableAspectJAutoProxy
@Import(RedisConfig.class)
public class RootConfig {
}
