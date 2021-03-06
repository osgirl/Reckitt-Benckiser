package com.ad.reckittbenckiser.utils;

import com.ad.reckittbenckiser.vo.ASMInfo;
import com.ad.reckittbenckiser.vo.DbsrInfo;
import com.ad.reckittbenckiser.vo.DistributorInfo;
import com.ad.reckittbenckiser.vo.ProductInfo;
import com.ad.reckittbenckiser.vo.StoreInfo;
import com.ad.reckittbenckiser.vo.TSIInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laxmi.khatri on 8/17/2016.
 */

public class Constants {

    public static List<TSIInfo> getTsiList() {

        List<TSIInfo> tsiInfos = new ArrayList<>();
        tsiInfos.add(new TSIInfo("Raipur TSI", "URBAN", "3.0%", "188.2", "168.6"));
        tsiInfos.add(new TSIInfo("Bilaspur TSI", "URBAN", "23.2%", "99.7", "130.2"));
        tsiInfos.add(new TSIInfo("Bilaspur ASE", "RURAL", "39.6%", "165.6", "118.2"));
        tsiInfos.add(new TSIInfo("Raipur ASE", "RURAL", "31.8%", "222.2", "106.9"));
        tsiInfos.add(new TSIInfo("Pragati TSI (Durg CG)", "URBAN", "-39.7%", "80.5", "59.9"));

        return tsiInfos;
    }

    public static String[] getTsiNameArray() {

        String[] tsiNames = new String[]{"Pragati TSI (DURG CG)", "RAIPUR ASE", "BILASPUR ASE", "Bilaspur (TSI)", "Raipur TSI",};

        return tsiNames;
    }


    public static List<ASMInfo> getASMList() {

        List<ASMInfo> asmInfoList = new ArrayList<>();
        asmInfoList.add(new ASMInfo("NORTH BENGAL", "10.4%", "13.6%", "762", "29"));
        asmInfoList.add(new ASMInfo("CHHATTISGARH", "14.1", "4.9%", "1339", "86"));
        asmInfoList.add(new ASMInfo("NORTH EAST", "18.4%", "17.6%", "34", "29"));
        asmInfoList.add(new ASMInfo("BIHAR", "24.1", "14.9%", "139", "89"));
        asmInfoList.add(new ASMInfo("NORTH BIHAR", "14.4%", "18.6%", "732", "60"));
        asmInfoList.add(new ASMInfo("ORISSA", "17.1", "5.9%", "39", "80"));
        asmInfoList.add(new ASMInfo("SOUTH BENGAL", "15.4%", "19.6%", "32", "69"));
        asmInfoList.add(new ASMInfo("CALCUTTA", "19.1", "5.9%", "639", "66"));
        return asmInfoList;
    }

    public static List<DistributorInfo> getDistributorList() {

        List<DistributorInfo> distInfos = new ArrayList<>();
        distInfos.add(new DistributorInfo("Agarwal Agency - ph2", "-8.7%", "70.17"));
        distInfos.add(new DistributorInfo("Shree Gopal Agency - Ph3", "22.8%", "62.56"));
        distInfos.add(new DistributorInfo("Rajpal Agency - ph2", "21.1%", "35.83"));

        return distInfos;
    }

    public static List<DbsrInfo> getDbsrList() {
        List<DbsrInfo> dbsrInfos = new ArrayList<>();
        dbsrInfos.add(new DbsrInfo("Yeshwant Sahu", "16%", "49.19"));
        dbsrInfos.add(new DbsrInfo("Rajesh Vyas", "-66%", "9.81"));
        dbsrInfos.add(new DbsrInfo("Rajkumar Bansod", "72%", "7.37"));
        dbsrInfos.add(new DbsrInfo("Vikas Mishra", "-45%", "3.80"));
        dbsrInfos.add(new DbsrInfo("NA", "-100%", "0.00"));
        dbsrInfos.add(new DbsrInfo("Amin Khan", "-100%", "0.00"));

        return dbsrInfos;
    }

    public static List<StoreInfo> getStoreList() {
        List<StoreInfo> storeInfos = new ArrayList<>();
        storeInfos.add(new StoreInfo("Vision", "-77.1%", "10.84"));
        storeInfos.add(new StoreInfo("Udaan", "82.5%", "37.19"));
        storeInfos.add(new StoreInfo("Wholesale", "3693.7%", "0.12"));
        storeInfos.add(new StoreInfo("A+B", "-82.7%", "1.01"));
        storeInfos.add(new StoreInfo("Rest", "408.8%", "0.05"));

        return storeInfos;
    }

    public static List<ProductInfo> getProductList() {
        List<ProductInfo> productInfos = new ArrayList<>();
        productInfos.add(new ProductInfo("Dettol Soap", "-95.1%", "3.20"));
        productInfos.add(new ProductInfo("Dettol Handwash", "-95.3%", "0.43"));
        productInfos.add(new ProductInfo("Harpic", "-39.2%", "3.79"));
        productInfos.add(new ProductInfo("Lizol", "-89.1%", "2.06"));
        productInfos.add(new ProductInfo("Mortein", "-83.3%", "0.32"));
        productInfos.add(new ProductInfo("Veet", "0.0%", "0.09"));
        productInfos.add(new ProductInfo("Healthcare", "383.5%", "0.12"));
        /*productInfos.add(new ProductInfo("SWB", "0.0%", "0.00"));
        productInfos.add(new ProductInfo("OTHERS", "-71.1%", "0.82"));*/

        return productInfos;
    }

    public static List<ASMInfo> getAsmLeadorBoard() {
        List<ASMInfo> asmInfos = new ArrayList<>();
        asmInfos.add(new ASMInfo("South Bengal", "21%", 1));
        asmInfos.add(new ASMInfo("North Bihar", "20%", 2));
        asmInfos.add(new ASMInfo("Bihar", "17%", 3));
        asmInfos.add(new ASMInfo("Chhattisgarh", "14%", 4));
        asmInfos.add(new ASMInfo("Orissa ", "11%", 5));
        asmInfos.add(new ASMInfo("Jharkhand", "9%", 6));
        asmInfos.add(new ASMInfo("Calcutta", "8%", 7));
        asmInfos.add(new ASMInfo("North East", "4%", 8));
        asmInfos.add(new ASMInfo("North Bengal", "-22%", 9));

        return asmInfos;
    }
}
