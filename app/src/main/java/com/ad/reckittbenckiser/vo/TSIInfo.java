package com.ad.reckittbenckiser.vo;

/**
 * Created by laxmi.khatri on 8/19/2016.
 */
public class TSIInfo {

    private String tsiName;
    private String channel;
    private String growth;
    private String aveSales;
    private String opportunity;

    public TSIInfo(String tsiName, String channel, String growth, String aveSales, String opportunity) {
        this.tsiName = tsiName;
        this.channel = channel;
        this.growth = growth;
        this.aveSales = aveSales;
        this.opportunity = opportunity;
    }

    public String getTsiName() {
        return tsiName;
    }

    public String getChannel() {
        return channel;
    }

    public String getGrowth() {
        return growth;
    }

    public String getAveSales() {
        return aveSales;
    }

    public String getOpportunity() {
        return opportunity;
    }

}
