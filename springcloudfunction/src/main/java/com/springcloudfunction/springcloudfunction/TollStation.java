package com.springcloudfunction.springcloudfunction;

public class TollStation {

    private String tollStationId;


    private Float mileMarker;

    private int stallCount;

    public TollStation(String tollStationId, Float mileMarker, int stallCount) {
        this.tollStationId = tollStationId;
        this.mileMarker = mileMarker;
        this.stallCount = stallCount;
    }

    public String getTollStationId() {
        return tollStationId;
    }

    public void setTollStationId(String tollStationId) {
        this.tollStationId = tollStationId;
    }

    public Float getMileMarker() {
        return mileMarker;
    }

    public void setMileMarker(Float mileMarker) {
        this.mileMarker = mileMarker;
    }

    public int getStallCount() {
        return stallCount;
    }

    public void setStallCount(int stallCount) {
        this.stallCount = stallCount;
    }



}
