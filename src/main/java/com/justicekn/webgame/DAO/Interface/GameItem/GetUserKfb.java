package com.justicekn.webgame.DAO.Interface.GameItem;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GetUserKfb
{
    @Select("select KFB from usergameattributes where id = #{id}")
    public int getKfb(int id );
}
