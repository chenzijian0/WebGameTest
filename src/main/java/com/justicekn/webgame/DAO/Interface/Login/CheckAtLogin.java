package com.justicekn.webgame.DAO.Interface.Login;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CheckAtLogin {
    @Select("select COUNT(id) from webgame where account =  #{account} and pwd = #{pwd} limit 1")
    public int checkAccount(String account , String pwd);
    @Select("select id from webgame where account = #{account} limit 1")
    public int findId(String account);
    @Select("select name from webgame where account = #{account} limit 1")
    public String findName(String account);
    @Select("select KFB from usergameattributes where id = #{id} limit 1")
    public int findKfb(int id);

}
