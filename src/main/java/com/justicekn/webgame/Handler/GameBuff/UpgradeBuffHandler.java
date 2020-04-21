package com.justicekn.webgame.Handler.GameBuff;

import com.justicekn.webgame.DAO.Interface.GameBuff.UpgradeBuffToDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UpgradeBuffHandler
{
    @Autowired
    UpgradeBuffToDataBase upgradeBuffToDataBase;

    public double upgradeBuffValue(String upId, double oldBuffValue)
    {
        Random random = new Random();
        switch (upId)
        {
            case "1":
                if (oldBuffValue + 5 < 30)
                {
                    return (double) random.nextInt((int) (oldBuffValue * 10 + 50)) / 10;
                }
                else
                {
                    return (double) random.nextInt(301) / 10;
                }
            case "2":
                if (oldBuffValue + 5 < 60)
                {
                    return (double) (random.nextInt((int) (oldBuffValue * 10 + 50))) / 10;
                }
                else
                {
                    return (double) (random.nextInt(601)) / 10;
                }
            case "3":
                if (oldBuffValue + 5 < 100)
                {
                    return (double) (random.nextInt((int) (oldBuffValue * 10 + 50))) / 10;
                }
                else
                {
                    return (double) (random.nextInt(1001)) / 10;
                }
            case "4":
                if (oldBuffValue + 5 < 200)
                {
                    return (double) (random.nextInt((int) (oldBuffValue * 10 + 50))) / 10;
                }
                else
                {
                    return (double) (random.nextInt(2001)) / 10;
                }
        }
        return -1;
    }

    /***
     * 判断当前buff数值是否可以相应buff升级方法
     * 重新思考后决定弃用此判断方法
     */
    public boolean canBeUpgrade(String upId, double oldBuffValue)
    {
        switch (upId)
        {
            case "1":
                if (oldBuffValue > 0) return true;
            case "2":
                if (oldBuffValue > 30) return true;
            case "3":
                if (oldBuffValue > 60) return true;
            case "4":
                if (oldBuffValue > 100) return true;
        }
        return false;
    }

    public boolean enoughKfbToUpgrade(int kfb, int choseLevel)
    {
        if (kfb >= choseLevel)
        {
            return true;
        }
        return false;
    }

    public int upgradeKfb(String upId, int id, int kfb)
    {
        switch (upId)
        {
            case "1":
                upgradeBuffToDataBase.upgradeKfb(id, 100);
                return kfb - 100;
            case "2":
                upgradeBuffToDataBase.upgradeKfb(id, 1000);
                return kfb - 1000;
            case "3":
                upgradeBuffToDataBase.upgradeKfb(id, 10000);
                return kfb - 10000;
            case "4":
                upgradeBuffToDataBase.upgradeKfb(id, 100000);
                return kfb - 100000;
        }
        return kfb;
    }
}
