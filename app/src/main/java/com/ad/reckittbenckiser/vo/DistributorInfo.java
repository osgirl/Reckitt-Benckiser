package com.ad.reckittbenckiser.vo;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class DistributorInfo {

    private String distributorName;
    private String growth;
    private String opportunity;

    public DistributorInfo(String distName, String growth, String opportunity) {
        this.distributorName = distName;
        this.growth = growth;
        this.opportunity = opportunity;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public String getGrowth() {
        return growth;
    }

    public String getOpportunity() {
        return opportunity;
    }
}
