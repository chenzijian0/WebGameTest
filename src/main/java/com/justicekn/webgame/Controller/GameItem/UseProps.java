package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.GetUserKfb;
import com.justicekn.webgame.Handler.GameItem.CalculateIsUsedSuccessfully;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UseProps
{
    @Autowired
    CalculateIsUsedSuccessfully calculateIsUsedSuccessfully;

    @RequestMapping("/GamePage/UseProps")
    public String useProps(int identifyId, int propType, HttpServletRequest request)
    {
        int id = (int) request.getSession().getAttribute("userId");
        String temp = calculateIsUsedSuccessfully.calculateIsUsedSuccessfully(propType, id, identifyId);
             String compose = "<td colspan=\"3\">"+temp+"</td>";
        return compose;
    }
}
