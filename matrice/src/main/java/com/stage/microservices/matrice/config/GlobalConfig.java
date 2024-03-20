package com.stage.microservices.matrice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static org.apache.naming.SelectorContext.prefix;

@ConfigurationProperties(prefix = "spring.h2.console.enabled")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GlobalConfig {
    private int p1;
    private int p2;
}
