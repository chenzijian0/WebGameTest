package com.justicekn.webgame.DAO.Interface.Registe;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CheckAtRegistration {
    @Select("select COUNT(name) from webgame where name = #{name} limit 1")
    public int findName(String name);
    @Select("select COUNT(account) from webgame where account = #{account} limit 1")
    public int findAccount(String account);

}
