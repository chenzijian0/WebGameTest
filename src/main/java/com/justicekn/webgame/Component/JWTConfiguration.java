package com.justicekn.webgame.Component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class JWTConfiguration
{
        private String clientId;
        private String base64Secret;
        private String name;
        private int expiresSecond;

}
