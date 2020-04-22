package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.GetUserKfb;
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
    @Autowired
    GetUserKfb getUserKfb;
    @RequestMapping("/GamePage/SellItem")
    public String sellItem(int propType , int identifyId , HttpServletRequest request)
    {
        int id = (int)request.getSession().getAttribute("userId");
        sellItemHandler.SellSuccess(identifyId,propType,id);
        int kfb = getUserKfb.getKfb(id);
        request.getSession().setAttribute("userKfb", kfb);
        String compose = "<td colspan=\"3\">"+"Ok"+"</td>";
        return compose;
    }
}
