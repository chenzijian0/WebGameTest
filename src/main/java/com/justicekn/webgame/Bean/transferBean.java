package com.justicekn.webgame.Bean;

import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class transferBean
{
    @Bean
    @Scope("prototype")
    UserGameAttributes transferUserGameAttributes()
    {
        return new UserGameAttributes(1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                "0",
                "0",
                1,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                1,
                1,
                1,
                1,
                1,
                1,
                "monster");
    }
}
