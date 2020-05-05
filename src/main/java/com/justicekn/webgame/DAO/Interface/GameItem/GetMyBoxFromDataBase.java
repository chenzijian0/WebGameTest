package com.justicekn.webgame.DAO.Interface.GameItem;

import com.justicekn.webgame.Bean.GameItem.MyBoxBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GetMyBoxFromDataBase {
    @Select("select OrdinaryBox , LuckyBox ,RareBox ,LegendBox ,MysteryBox from usergameattributes where  id = #{id} limit 1" )
    public MyBoxBean getMyBox(int id);
}
