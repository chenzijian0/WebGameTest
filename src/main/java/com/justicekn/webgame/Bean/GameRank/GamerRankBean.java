package com.justicekn.webgame.Bean.GameRank;

public class GamerRankBean {

    private String name;
    private int floor;
    private int id;
    private int rankingCount;

    public int getRankingCount() {
        return rankingCount;
    }

    public void setRankingCount(int rankingCount) {
        this.rankingCount = rankingCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
