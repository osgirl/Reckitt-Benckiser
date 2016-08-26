package com.ad.reckittbenckiser.vo;

/**
 * Created by Shiva.Bansal on 8/22/2016.
 */
public class ASMInfo {

    private String asmName;
    private String qtdGrowth;
    private String monthlyGrowth;
    private String urbanStoreCount;
    private String ruralStoreCount;
    private int rank;

    public int getRank() {
        return rank;
    }

    public String getAsmName() {
        return asmName;
    }

    public void setAsmName(String asmName) {
        this.asmName = asmName;
    }

    public String getQtdGrowth() {
        return qtdGrowth;
    }

    public void setQtdGrowth(String qtdGrowth) {
        this.qtdGrowth = qtdGrowth;
    }

    public String getMonthlyGrowth() {
        return monthlyGrowth;
    }

    public void setMonthlyGrowth(String monthlyGrowth) {
        this.monthlyGrowth = monthlyGrowth;
    }

    public String getUrbanStoreCount() {
        return urbanStoreCount;
    }

    public void setUrbanStoreCount(String urbanStoreCount) {
        this.urbanStoreCount = urbanStoreCount;
    }

    public String getRuralStoreCount() {
        return ruralStoreCount;
    }

    public void setRuralStoreCount(String ruralStoreCount) {
        this.ruralStoreCount = ruralStoreCount;
    }

    public ASMInfo(String asmName, String monthlyGrowth, String qtdGrowth, String urbanStoreCount, String ruralStoreCount) {
        this.asmName = asmName;
        this.monthlyGrowth = monthlyGrowth;
        this.qtdGrowth = qtdGrowth;
        this.urbanStoreCount = urbanStoreCount;
        this.ruralStoreCount = ruralStoreCount;
    }

    public ASMInfo(String asmName, String monthlyGrowth, int rank) {
        this.asmName = asmName;
        this.monthlyGrowth = monthlyGrowth;
        this.rank = rank;
    }
}
