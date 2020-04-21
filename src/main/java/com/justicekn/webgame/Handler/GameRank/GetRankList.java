package com.justicekn.webgame.Handler.GameRank;

import com.justicekn.webgame.Bean.GameRank.GamerRankBean;
import com.justicekn.webgame.DAO.Interface.GameRank.GetRankListFromDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRankList {
    @Autowired
    GetRankListFromDataBase data;

    public GamerRankBean[] getList() {
        data.setValue();
        return data.getRankList();
    }

}
