package com.justicekn.webgame.Controller.GameShop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameShop
{
    @RequestMapping("/GamePage/gameShop.html")
    public String shop(){
        return "GamePage/gameShop";
    }
}
