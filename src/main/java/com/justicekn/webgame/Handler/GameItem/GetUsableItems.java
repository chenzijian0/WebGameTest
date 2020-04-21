package com.justicekn.webgame.Handler.GameItem;

import com.justicekn.webgame.Bean.GameItem.UsableItemList;
import com.justicekn.webgame.DAO.Interface.GameItem.GetUsableItemFromDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUsableItems
{
    @Autowired
    GetUsableItemFromDataBase getUsableItemFromDataBase;

    public UsableItemList[] getUsableItems(int id)
    {
        UsableItemList[] usableItemList = getUsableItemFromDataBase.getUsableItemList(id);
        ;
        for (UsableItemList usableItem : usableItemList)
        {
            switch (usableItem.getItemClass())
            {
                case "CARTOON1":
                    usableItem.setItemName("蕾米莉亚同人漫画");
                    break;
                case "CARTOON2":
                    usableItem.setItemName("十六夜同人漫画");
                    break;
                case "ROOM_KEY":
                    usableItem.setItemName("档案室钥匙");
                    break;
                case "CD":
                    usableItem.setItemName("傲娇LOLI娇蛮音CD");
                    break;
                case "MED":
                    usableItem.setItemName("消逝之药");
                    break;
                case "COUPON":
                    usableItem.setItemName("整形优惠卷");
                    break;
            }
        }
        return usableItemList;
    }
}
