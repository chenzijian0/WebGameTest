package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.Handler.GameItem.SellItemHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SellItem
{
    @Autowired
    SellItemHandler sellItemHandler;
    @RequestMapping("/GamePage/SellItem")
    public String sellItem(int propType , int identifyId , HttpServletRequest request)
    {
        int id = (int)request.getSession().getAttribute("userId");
        sellItemHandler.SellSuccess(identifyId,propType,id);
        return "Ok";
    }
}
