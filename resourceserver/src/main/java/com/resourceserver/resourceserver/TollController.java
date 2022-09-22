package com.resourceserver.resourceserver;

import java.util.ArrayList;
import java.util.List;

public class TollController {

    private List<TollData> tollStationList;

    public TollController() {
        tollStationList = new ArrayList<TollData>();
        tollStationList.add(new TollData("100","MH-04-4078","22-09-2022:8:46"));
        tollStationList.add(new TollData("101","MH-04-4079","25-09-2022:8:46"));
        tollStationList.add(new TollData("102","MH-04-4080","26-09-2022:8:46"));
        tollStationList.add(new TollData("103","MH-04-4081","20-09-2022:8:46"));
    }
}
