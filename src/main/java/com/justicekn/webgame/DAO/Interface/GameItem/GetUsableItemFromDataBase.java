package com.justicekn.webgame.DAO.Interface.GameItem;

import com.justicekn.webgame.Bean.GameItem.UsableItemList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GetUsableItemFromDataBase
{
    @Select("select * from userusableitem where id = #{id} ")
    public UsableItemList[] getUsableItemList(int id);
}
