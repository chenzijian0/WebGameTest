package com.justicekn.webgame.Handler.GameMain;

import com.justicekn.webgame.DAO.Interface.GameMain.QueryChallengeTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 返回True 说明不能挑战
 * 返回false 说明可以挑战
 */
@Service
public class CanChallenge
{
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    QueryChallengeTime queryChallengeTime;

    public boolean canChallenge(int id)
    {

        Date challengeTime = queryChallengeTime.challengeTiem(id);
        Date now = new Date();
        /* Debug
        logger.info("challengeTime-->{}  now -->{}", challengeTime.getTime(), now.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(challengeTime);
        logger.info("challengeTime-->{} ", str);
        str = sdf.format(now);
        logger.info("now-->{} ", str);
        */
        if (challengeTime.getTime() > now.getTime()) return false;
        else return true;
    }
}
