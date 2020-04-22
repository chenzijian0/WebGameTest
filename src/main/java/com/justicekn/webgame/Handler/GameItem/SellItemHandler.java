package com.justicekn.webgame.Handler.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.ReadUseableItemInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellItemHandler
{
    @Autowired
    ReadUseableItemInf readUseableItemInf;

    public void SellSuccess(int identifyId, int propType ,int id)
    {
        readUseableItemInf.deleteItem(identifyId);
        switch (propType)
        {
            case 1:
            case 2:
                readUseableItemInf.SellItemType1(id);
                break;
            case 3:
            case 4:
                readUseableItemInf.SellItemType2(id);
                break;
            case 5:
            case 6:
                readUseableItemInf.SellItemType3(id);
                break;
        }
    }
}
