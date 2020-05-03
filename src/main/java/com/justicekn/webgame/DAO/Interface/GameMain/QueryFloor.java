package com.justicekn.webgame.DAO.Interface.GameMain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface QueryFloor
{
    @Select("select ChallengeFloor from usergameattributes where id = #{id} limit 1")
    public  int queryChallengeFloor(int id);

    @Update("update usergameattributes set ChallengeFloor = ChallengeFloor + 1 where id = #{id} limit 1")
    public   int ChallengeSuccess(int id);

    @Update("update usergameattributes set ChallengeFloor = 1 where id = #{id} limit 1;")
    public  int ChallengeFailed(int id);

    @Select("select nowHealth from usergameattributes where id = #{id}")
    public  int queryNowHealth(int id);

    @Update("update usergameattributes set nowHealth = #{nowHealth} where id = #{id}")
    public void updateHealth(int nowHealth , int id);

    @Select("select FLOOR from usergameattributes where id = #{id} limit 1")
    public  int queryFloor(int id);

    @Update("update usergameattributes set FLOOR = #{challengeFloor} where id = #{id}")
    public  void updateFloor(int challengeFloor , int id);
}
