package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.UserEquipmentWeapons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@RestController
public class EquipWeapons
{
    @Autowired
    UserEquipmentWeapons userEquipmentWeapons;
    @RequestMapping("/GamePage/EquipmentWeapons")
    public String equipmentProps(String identifyId , HttpServletRequest request)
    {
       int id =(int) request.getSession().getAttribute("userId");
       userEquipmentWeapons.EquipmentWeapons(identifyId,id);
        return "OK";
    }

}
