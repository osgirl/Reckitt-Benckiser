package com.ad.reckittbenckiser.vo;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class DbsrInfo {

    private String dbsrName;
    private String growth;
    private String opportunity;

    public DbsrInfo(String dbsrName, String growth, String opportunity) {
        this.dbsrName = dbsrName;
        this.growth = growth;
        this.opportunity = opportunity;
    }

    public String getDbsrName() {
        return dbsrName;
    }

    public String getGrowth() {
        return growth;
    }

    public String getOpportunity() {
        return opportunity;
    }
}
