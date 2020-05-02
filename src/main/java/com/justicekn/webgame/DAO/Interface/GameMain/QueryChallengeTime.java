package com.justicekn.webgame.DAO.Interface.GameMain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface QueryChallengeTime
{
    @Select("select nextChallengeTime from usergameattributes where  id = #{id}")
    public Date challengeTiem(int id);
    @Update("update usergameattributes SET nextChallengeTime =  ADDTIME(now(),'0:5:0') where id = #{id}")
    public void ifChallengeFail(int id);
}
