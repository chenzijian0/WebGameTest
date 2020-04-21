package com.justicekn.webgame.Controller.GameItem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UseProps
{
    @RequestMapping("/GamePage/UseProps")
    public String useProps(int PropType , HttpServletRequest request )
    {

        return "Ok";
    }
}
