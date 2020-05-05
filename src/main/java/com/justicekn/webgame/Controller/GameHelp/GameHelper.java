package com.justicekn.webgame.Controller.GameHelp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameHelper
{
    @RequestMapping("/GamePage/gameHelp.html")
    public String help()
    {
        return "GamePage/gameHelp";
    }
}
