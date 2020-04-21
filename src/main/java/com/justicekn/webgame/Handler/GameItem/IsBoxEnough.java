package com.justicekn.webgame.Handler.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.OpenBoxGetItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class IsBoxEnough
{
    @Autowired
    OpenBoxGetItem openBoxGetItem;

    public boolean isBoxEnough(HttpSession httpSession, int boxId)
    {
        int id = (int) httpSession.getAttribute("userId");
        switch (boxId)
        {
            case 1:
                if (openBoxGetItem.isOrdinaryBoxEnough(id) <= 0) return false;
                else
                {
                    openBoxGetItem.reduceOrdinaryBox(id);
                    return true;
                }
            case 2:
                if (openBoxGetItem.isLuckyBoxEnough(id) <= 0) return false;
                else
                {
                    openBoxGetItem.reduceLuckyBox(id);
                    return true;
                }
            case 3:
                if (openBoxGetItem.isRareBoxEnough(id) <= 0) return false;
                else
                {
                    openBoxGetItem.reduceRareBox(id);
                    return true;
                }
            case 4:
                if (openBoxGetItem.isLegendBoxEnough(id) <= 0) return false;
                else
                {
                    openBoxGetItem.reduceLegendBox(id);
                    return true;
                }
            case 5:
                if (openBoxGetItem.isMysteryBoxEnough(id) <= 0) return false;
                else
                {
                    openBoxGetItem.reduceMysteryBox(id);
                    return true;
                }
        }
        return false;
    }
}
