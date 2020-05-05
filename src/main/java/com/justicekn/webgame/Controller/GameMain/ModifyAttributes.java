package com.justicekn.webgame.Controller.GameMain;

import com.justicekn.webgame.Bean.GameMain.ModifyAttributesBean;
import com.justicekn.webgame.DAO.Interface.GameMain.ModifyGamerAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class ModifyAttributes
{
    @Autowired
    ModifyGamerAttributes modifyGamerAttributes;

    @RequestMapping("/GamePage/ModifyAttributes")
    public void modifyAttributes(ModifyAttributesBean bean, HttpServletResponse response, HttpSession httpSession) throws IOException
    {
        int assignable = 0;
        int totalAssignable = 0;
        int id = (int)httpSession.getAttribute("userId");
        totalAssignable =  modifyGamerAttributes.assignable(id);
        assignable += bean.getAgi()+bean.getDex()+bean.getMnd()+bean.getWis()+bean.getPhy()+bean.getSnh();
        if (totalAssignable >= assignable )
        {
            modifyGamerAttributes.updateGamerAttributes(bean.getSnh(),bean.getAgi(),bean.getPhy(),bean.getDex(),bean.getWis(),bean.getMnd(), id);
        }
        response.sendRedirect("GamePage/gameMain.html");
    }
}
