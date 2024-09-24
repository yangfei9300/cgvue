package com.ruoyi;

public class YuanWeilan {
    private Double lat;
    private Double lon;
    private String areaName;
    private int radius;
    private String center;


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    @Override
    public String toString() {
        return "YuanWeilan{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", areaName='" + areaName + '\'' +
                ", radius=" + radius +
                ", center='" + center + '\'' +
                '}';
    }
}
