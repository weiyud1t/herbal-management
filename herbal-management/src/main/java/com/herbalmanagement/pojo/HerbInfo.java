package com.herbalmanagement.pojo;



public class HerbInfo {
    private Integer id;
    private String herbName;
    private String origin;
    private Integer stockQuantity;
    private String effects;
    public HerbInfo() {
    }
    public HerbInfo(Integer id, String herbName, String origin, Integer stockQuantity, String effects) {
        this.id = id;
        this.herbName = herbName;
        this.origin = origin;
        this.stockQuantity = stockQuantity;
        this.effects = effects;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHerbName() {
        return herbName;
    }

    public void setHerbName(String herbName) {
        this.herbName = herbName == null ? null : herbName.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }


    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects == null ? null : effects.trim();
    }
}