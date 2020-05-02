package com.justicekn.webgame.Controller.GameMain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CanNotChallenge
{
    @RequestMapping("/GamePage/CanNotChallenge")
    public String canNotChallenge(){
        return "no";
    }
}
