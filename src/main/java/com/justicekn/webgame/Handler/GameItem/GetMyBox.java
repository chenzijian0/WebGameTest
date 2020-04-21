package com.justicekn.webgame.Handler.GameItem;

import com.justicekn.webgame.Bean.GameItem.MyBoxBean;
import com.justicekn.webgame.DAO.Interface.GameItem.GetMyBoxFromDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetMyBox {
    @Autowired
    GetMyBoxFromDataBase getMyBoxFromDataBase;

    public MyBoxBean getMyBox(int id) {
        return getMyBoxFromDataBase.getMyBox(id);
    }
}
