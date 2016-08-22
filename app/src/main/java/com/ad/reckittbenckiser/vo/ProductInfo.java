package com.ad.reckittbenckiser.vo;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class ProductInfo {

    private String productName;
    private String growth;
    private String opportunity;

    public ProductInfo(String productName, String growth, String opportunity) {
        this.productName = productName;
        this.growth = growth;
        this.opportunity = opportunity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getGrowth() {
        return growth;
    }

    public String getOpportunity() {
        return opportunity;
    }
}
