package com.justicekn.webgame.Handler.GameBuff;

import com.justicekn.webgame.Bean.GameBuff.GamerBuffRankBean;
import com.justicekn.webgame.DAO.Interface.GameRank.GetRankListFromDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Service
public class GetBuffRankList {
    @Autowired
    GetRankListFromDataBase getRankListFromDataBase;
    public GamerBuffRankBean[] getList(){
        getRankListFromDataBase.setValue();
        return getRankListFromDataBase.getBuffRankList();
    }

    public double getMyBuffValue(int id){
        return getRankListFromDataBase.getMyBuffValue(id);
    }
}
