package com.justicekn.webgame.Handler.GameMain;

import com.justicekn.webgame.DAO.Interface.GameMain.QueryChallengeTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/***
 * 返回True 说明不能挑战
 * 返回false 说明可以挑战
 */
@Service
public class CanChallenge
{
    @Autowired
    QueryChallengeTime queryChallengeTime;
    public boolean canChallenge(int id  ){
                Date challengeTime =  queryChallengeTime.challengeTiem(id);
                Date now = new Date();
                return challengeTime.after(now);
    }
}
