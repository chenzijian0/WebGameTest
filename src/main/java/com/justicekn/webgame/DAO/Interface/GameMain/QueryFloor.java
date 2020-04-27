package com.justicekn.webgame.DAO.Interface.GameMain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface QueryFloor
{
    @Select("select ChallengeFloor from usergameattributes where id = #{id} limit 1")
    int queryChallengeFloor(int id);

    @Update("update usergameattributes set ChallengeFloor = ChallengeFloor + 1 where id = #{id} limit 1")
    int ChallengeSuccess(int id);

    @Update("update usergameattributes set ChallengeFloor = 1 where id = #{id} limit 1;")
    int ChallengeFailed(int id);
}
