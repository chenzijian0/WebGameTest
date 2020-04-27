package com.justicekn.webgame.Controller.GameMain;

import com.justicekn.webgame.Bean.GameMain.BattleInf;
import com.justicekn.webgame.Bean.GameMain.GamersEntity;
import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import com.justicekn.webgame.Handler.GameMain.BattleSimulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
public class Battle
{
    @Autowired
    BattleSimulation battleSimulation;
    @RequestMapping("/GamePage/Battle")
    public String battle(HttpServletRequest request)
    {
        double buffValue;
        int id ;
        UserGameAttributes userGameAttributes;
        id = (int)request.getSession().getAttribute("userId");
        userGameAttributes = (UserGameAttributes)request.getSession().getAttribute("userAttributesFromDataBase");
        buffValue = (double)request.getSession().getAttribute("buffValue");

        List<BattleInf> infs;
        infs = battleSimulation.battleSimulation(id, new GamersEntity(userGameAttributes,buffValue),userGameAttributes);
        request.setAttribute("battleInfs", infs);
        request.setAttribute("challengeFloor", battleSimulation.challengeFloor);
        request.setAttribute("monsterHeath", battleSimulation.monsterHeath);
        request.setAttribute("monsterSpeed", battleSimulation.monsterSpeed);
        request.setAttribute("monsterAttack", battleSimulation.monsterAttack);
        request.setAttribute("userShield", battleSimulation.userShield);
        request.setAttribute("offsetDex", battleSimulation.offsetDex);
        request.setAttribute("offsetWis", battleSimulation.offsetWis);
        request.setAttribute("offsetHeath", battleSimulation.offsetHeath);
        request.setAttribute("userWin", battleSimulation.userWin);
        request.setAttribute("monsterWin", battleSimulation.monsterWin);
//        Iterator<BattleInf> iterator = infs.iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next().getBattleInf());
//        }

        return "/GamePage/FightInf/FightInf";
    }
}
