package com.justicekn.webgame.Controller.GameRank;

import com.justicekn.webgame.Bean.GameRank.GamerRankBean;
import com.justicekn.webgame.Handler.GameRank.GetRankList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RankList {
    @Autowired
    GetRankList rankList;
    @RequestMapping("/GamePage/gameRanking.html")
    public String rankList(HttpServletRequest request ){
       GamerRankBean[] gamerRankBeans = rankList.getList();
       request.setAttribute("rankingList",gamerRankBeans);
       return "/GamePage/gameRanking";
    }
}
