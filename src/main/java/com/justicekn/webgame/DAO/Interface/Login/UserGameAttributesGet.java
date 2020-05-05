package com.justicekn.webgame.DAO.Interface.Login;

import com.justicekn.webgame.Bean.Login.UserGameAttributes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserGameAttributesGet {
    @Select("select * from usergameattributes where  id = #{id} limit 1")
    public UserGameAttributes getUserGameAttributes(int id);
}
