package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.DisassembleTheEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DisassembleTheWeapons
{
    @Autowired
    DisassembleTheEquipment disassembleTheEquipment;

    @RequestMapping("/GamePage/DisassembleTheWeapons")
    public String disassembleTheEquipment(int identifyId, HttpServletRequest request)
    {
        int type;
        int id = (int) request.getSession().getAttribute("userId");
        type = disassembleTheEquipment.queryType(id, identifyId);
        disassembleTheEquipment.destructionEquipment(identifyId);
        switch (type)
        {
            case 1:
                return "武器经验+1";
            case 2:
                return "武器经验+4";
            case 3:
                return "武器经验+8";
            case 4:
                return "武器经验+16";
        }
        return "";
    }
}
