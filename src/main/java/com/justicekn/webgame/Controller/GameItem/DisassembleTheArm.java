package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.DisassembleTheEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DisassembleTheArm
{
    @Autowired
    DisassembleTheEquipment disassembleTheEquipment;

    @RequestMapping("/GamePage/DisassembleTheArm")
    public String disassembleTheEquipment(int identifyId, HttpServletRequest request)
    {
        int type;
        int id = (int) request.getSession().getAttribute("userId");
        type = disassembleTheEquipment.queryType(id, identifyId);
        disassembleTheEquipment.destructionEquipment(identifyId);
        switch (type)
        {
            case 1:
                disassembleTheEquipment.IncreaseArmExperience(1, id);
                if (disassembleTheEquipment.isArmUpgradeLevel(id) <= 0) disassembleTheEquipment.armUpgradeLevel(id);

                return "防具经验+1";
            case 2:
                disassembleTheEquipment.IncreaseArmExperience(4, id);
                if (disassembleTheEquipment.isArmUpgradeLevel(id) <= 0) disassembleTheEquipment.armUpgradeLevel(id);
                return "防具经验+4";
            case 3:
                disassembleTheEquipment.IncreaseArmExperience(8, id);
                if (disassembleTheEquipment.isArmUpgradeLevel(id) <= 0) disassembleTheEquipment.armUpgradeLevel(id);
                return "防具经验+8";
            case 4:
                disassembleTheEquipment.IncreaseArmExperience(16, id);
                if (disassembleTheEquipment.isArmUpgradeLevel(id) <= 0) disassembleTheEquipment.armUpgradeLevel(id);
                return "防具经验+16";
        }
        return "";
    }
}
