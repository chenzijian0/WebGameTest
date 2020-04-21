package com.justicekn.webgame.DAO.Interface.Registe;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterAccount {
    @Insert("insert into webgame(name, account, pwd) values (#{name} , #{account} , #{pwd})")
    public int reg(String name , String account , String pwd);
    @Insert("insert into usergameattributes(id,name) value (#{id},#{name})")
    public int userGameAttributesRegiste(int id ,String name);
    @Select("select id from webgame where account = #{account} limit 1")
    public int findAccountAtDataBase(String  account);
}
