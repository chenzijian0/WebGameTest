package com.justicekn.webgame.Configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Data
@ConfigurationProperties(prefix = "audience")
@Component
@EnableConfigurationProperties
public class JWTConfiguration
{
        private String clientId;
        private String base64Secret;
        private String name;
        private int expiresSecond;

}
