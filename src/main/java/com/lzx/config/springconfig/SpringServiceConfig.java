package com.lzx.config.springconfig;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.lzx.service") // 扫描业务逻辑层
public class SpringServiceConfig {

}
