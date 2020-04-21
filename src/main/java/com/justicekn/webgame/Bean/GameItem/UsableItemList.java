package com.justicekn.webgame.Bean.GameItem;

public class UsableItemList
{
    private int id;
    private int identifyId;
    private String itemClass;
    private String itemName;

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getIdentifyId()
    {
        return identifyId;
    }

    public void setIdentifyId(int identifyId)
    {
        this.identifyId = identifyId;
    }

    public String getItemClass()
    {
        return itemClass;
    }

    public void setItemClass(String itemClass)
    {
        this.itemClass = itemClass;
    }
}
