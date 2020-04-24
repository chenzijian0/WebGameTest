package com.justicekn.webgame.Controller.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.OpenBoxGetItem;
import com.justicekn.webgame.Handler.GameItem.IsBoxEnough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/***
 *
 */
@RestController
public class OpenBox
{
    @Autowired
    OpenBoxGetItem openBoxGetItem;
    @Autowired
    IsBoxEnough isBoxEnough;
    Random random = new Random();

    @RequestMapping("/GamePage/OpenBox")
    public String openBox(HttpSession httpSession, int boxId, HttpServletResponse response) throws IOException
    {
        String returnString = "";
        int id = (int) httpSession.getAttribute("userId");
        int itemClass = whatItemWillBeGet();
        boolean flag = isBoxEnough.isBoxEnough(httpSession, boxId);
        if (flag)
        {
            switch (boxId)
            {
                case 1:
                    returnString = choseOne(id, itemClass, 1, 1);
                    break;
                case 2:
                    returnString = choseOne(id, itemClass, 3, 2);
                    break;
                case 3:
                    returnString = choseOne(id, itemClass, 6, 3);
                    break;
                case 4:
                    returnString = choseOne(id, itemClass, 17, 4);
                    break;
                case 5:
                    returnString = choseOne(id, itemClass, 17, 4);
                    break;
            }

            return returnString;
        }
        else
        {
            //response.sendRedirect("/error");
            return "No";
        }
    }

    public String choseOne(int id, int chose, int magnification, int rarity)
    {
        switch (chose)
        {
            case 1:
                return getKfb(id, magnification);
            case 2:
                return getExp(id, magnification);
            case 3:
                return getItem(id);
            case 4:
                return getEquipment(id, rarity);
        }
        return "";
    }

    public int whatItemWillBeGet()
    {
        int randomValue = random.nextInt(3);
        if (randomValue <= 1)
        {
            int randomValue2 = random.nextInt(2);
            if (randomValue2 == 0) return 1; //金币
            else return 2; // 经验
        }
        else
        {
            int randomValue3 = random.nextInt(4);
            if (randomValue3 == 3) return 3;//道具
            else return 4;//装备
        }
    }

    public String getKfb(int id, int magnification)
    {
        int nextInt = random.nextInt(100);
        return "获得了[" + nextInt * magnification + "]KFB";
    }

    public String getExp(int id, int magnification)
    {
        int nextInt = random.nextInt(100);
        return "获得了[" + nextInt * magnification + "]经验";
    }

    public String getItem(int id)
    {
        int nextInt = random.nextInt(32);
        if (nextInt < 10)
        {
            openBoxGetItem.addUsableItem(id, "CARTOON1");
            return "获得了蕾米莉亚同人漫画";
        }
        else if (nextInt < 20)
        {
            openBoxGetItem.addUsableItem(id, "CARTOON2");
            return "获得了十六夜同人漫画";
        }
        else if (nextInt < 25)
        {
            openBoxGetItem.addUsableItem(id, "ROOM_KEY");
            return "获得了档案室钥匙";
        }
        else if (nextInt < 30)
        {
            openBoxGetItem.addUsableItem(id, "CD");
            return "获得了傲娇LOLI娇蛮音CD";
        }
        else if (nextInt < 31)
        {
            openBoxGetItem.addUsableItem(id, "MED");
            return "获得了消逝之药";
        }
        else if (nextInt < 32)
        {
            openBoxGetItem.addUsableItem(id, "COUPON");
            return "获得了整形优惠卷";
        }
        return "";
    }

    public String getEquipment(int id, int rarity)
    {
        int weaOrArm = random.nextInt(2);
        int mainAttribute, SencondlyAttribute;
        StringBuilder itemId = new StringBuilder();
        itemId.append(rarity);
        int type = random.nextInt(3) + 1;
        itemId.append(type);
        for (int temp = rarity; temp > 0; temp--)
        {
            mainAttribute = random.nextInt(6) + 1;
            itemId.append(mainAttribute);
        }

        for (int temp = rarity * 3 * 2; temp > 0; temp--)
        {
            SencondlyAttribute = random.nextInt(6) + 1;
            itemId.append(SencondlyAttribute);
        }
        if (weaOrArm == 0)
        {
            openBoxGetItem.openBoxToGetWeapon(id, itemId.toString());
            return "获得了一件武器";
        }
        else
        {
            openBoxGetItem.openBoxToGetArmor(id, itemId.toString());
            return "获得了一件防具";
        }
    }
}
