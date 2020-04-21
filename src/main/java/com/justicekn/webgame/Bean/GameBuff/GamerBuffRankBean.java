package com.justicekn.webgame.Bean.GameBuff;

public class GamerBuffRankBean {
    private String name;
    private int id;
    private double buff;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBuff() {
        return buff;
    }

    public void setBuff(double buff) {
        this.buff = buff;
    }
}
