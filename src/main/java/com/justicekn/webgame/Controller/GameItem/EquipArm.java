package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.UserEquipmentArm;
import com.justicekn.webgame.DAO.Interface.GameItem.UserEquipmentWeapons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EquipArm
{
    @Autowired
    UserEquipmentArm userEquipmentArm;
    @RequestMapping("/GamePage/EquipmentArm")
    public String equipmentProps(String identifyId , HttpServletRequest request)
    {
        int id =(int) request.getSession().getAttribute("userId");
        userEquipmentArm.EquipmentArm(identifyId,id);
        return "OK";
    }

}