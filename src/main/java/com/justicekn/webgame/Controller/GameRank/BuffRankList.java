package com.justicekn.webgame.Controller.GameRank;

import com.justicekn.webgame.Bean.GameBuff.GamerBuffRankBean;
import com.justicekn.webgame.Handler.GameBuff.GetBuffRankList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BuffRankList {
    @Autowired
    GetBuffRankList getBuffRankList;
    @RequestMapping("/GamePage/gameBuff.html")
    public String gameBuff(HttpServletRequest request){
        GamerBuffRankBean[] list = getBuffRankList.getList();
        request.setAttribute("buffList",list);
        int id = (int) request.getSession().getAttribute("userId");
        double buffValue = getBuffRankList.getMyBuffValue(id);
        request.getSession().setAttribute("buffValue",buffValue);
        return "GamePage/gameBuff";
    }
}
