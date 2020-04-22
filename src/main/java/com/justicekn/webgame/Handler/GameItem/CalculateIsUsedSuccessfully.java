package com.justicekn.webgame.Handler.GameItem;

import com.justicekn.webgame.DAO.Interface.GameItem.ReadUseableItemInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CalculateIsUsedSuccessfully
{
    @Autowired
    ReadUseableItemInf readUseableItemInf;

    public String calculateIsUsedSuccessfully(int propType, int id, int identifyId)
    {
        //测试漏洞: 删除操作 即使道具不存在依旧不影响执行, 需要添加道具存在与否的判断逻辑修复
        readUseableItemInf.deleteItem(identifyId);
        switch (propType)
        {
            case 1:
                if (getCARTOON1(id))
                {
                    readUseableItemInf.updateCARTOON1(id);
                    return "使用 蕾米莉亚同人漫画 成功";
                }
                else return "道具使用失败";
            case 2:
                if (getCARTOON2(id))
                {
                    readUseableItemInf.updateCARTOON2(id);
                    return "使用 十六夜同人漫画 成功";
                }
                else return "道具使用失败";
            case 3:
                if (getROOM_KEY(id))
                {
                    readUseableItemInf.updateROOM_KEY(id);
                    return "使用 档案室钥匙 成功";
                }
                else return "道具使用失败";
            case 4:
                if (getCD(id))
                {
                    readUseableItemInf.updateCD(id);
                    return "使用 傲娇LOLI娇蛮音CD 成功";
                }
                else return "道具使用失败";
            case 5:
                if (getMED(id))
                {
                    readUseableItemInf.updateMED(id);
                    return "使用 消逝之药 成功";
                }
                else return "道具使用失败";
            case 6:
                if (getCOUPON(id))
                {
                    readUseableItemInf.updateCOUPON(id);
                    return "使用 整形优惠卷 成功";
                }
                else return "道具使用失败";

        }
        return "";
    }

    public boolean getCARTOON1(int id)
    {
        int nowItemCount = readUseableItemInf.read_CARTOON1_Inf(id);
        int probability = (50 - nowItemCount) * 2;
        Random random = new Random();
        int drawResults = random.nextInt(100) + 1;
        if (probability >= drawResults) return true;
        else return false;
    }

    public boolean getCARTOON2(int id)
    {
        int nowItemCount = readUseableItemInf.read_CARTOON2_Inf(id);
        int probability = (50 - nowItemCount) * 2;
        Random random = new Random();
        int drawResults = random.nextInt(100) + 1;
        if (probability >= drawResults) return true;
        else return false;
    }

    public boolean getROOM_KEY(int id)
    {
        int nowItemCount = readUseableItemInf.read_ROOM_KEY_Inf(id);
        int probability = (30 - nowItemCount) * 3;
        Random random = new Random();
        int drawResults = random.nextInt(100) + 1;
        if (probability >= drawResults) return true;
        else return false;
    }

    public boolean getCD(int id)
    {
        int nowItemCount = readUseableItemInf.read_CD_Inf(id);
        int probability = (30 - nowItemCount) * 3;
        Random random = new Random();
        int drawResults = random.nextInt(100) + 1;
        if (probability >= drawResults) return true;
        else return false;
    }

    public boolean getMED(int id)
    {
        Random random = new Random();
        int drawResults = random.nextInt(100) + 1;
        int nowItemCount = readUseableItemInf.read_MED_Inf(id);
        if (nowItemCount == 0)
        {
            return true;
        }
        else if (nowItemCount == 1)
        {
            if (drawResults <= 90) return true;
            else return false;
        }
        else if (nowItemCount == 2)
        {
            if (drawResults <= 80) return true;
            else return false;
        }
        else if (nowItemCount == 3)
        {
            if (drawResults <= 70) return true;
            else return false;
        }
        else
        {
            double t = Math.pow(2, 10 - nowItemCount - 1);
            if (drawResults <= t) return true;
            else return false;
        }
    }

    public boolean getCOUPON(int id)
    {
        Random random = new Random();
        int drawResults = random.nextInt(100) + 1;
        int nowItemCount = readUseableItemInf.read_COUPON_Inf(id);
        if (nowItemCount == 0)
        {
            return true;
        }
        else if (nowItemCount == 1)
        {
            if (drawResults <= 90) return true;
            else return false;
        }
        else if (nowItemCount == 2)
        {
            if (drawResults <= 80) return true;
            else return false;
        }
        else if (nowItemCount == 3)
        {
            if (drawResults <= 70) return true;
            else return false;
        }
        else
        {
            double t = Math.pow(2, 10 - nowItemCount - 1);
            if (drawResults <= t) return true;
            else return false;
        }
    }


}
