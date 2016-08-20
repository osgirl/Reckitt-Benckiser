package com.ad.reckittbenckiser.vo;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class StoreInfo {

    private String storeName;
    private String growth;
    private String opportunity;

    public StoreInfo(String storeName, String growth, String opportunity) {
        this.storeName = storeName;
        this.growth = growth;
        this.opportunity = opportunity;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getGrowth() {
        return growth;
    }

    public String getOpportunity() {
        return opportunity;
    }
}
