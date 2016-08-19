package com.ad.reckittbenckiser.utils;

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
        tsiInfos.add(new TSIInfo("Bilaspur (TSI)", "URBAN", "23.2%", "99.7", "130.2"));
        tsiInfos.add(new TSIInfo("Pragati TSI (DURG CG)", "URBAN", "-39.7%", "80.5", "59.9"));
        tsiInfos.add(new TSIInfo("BILASPUR ASE", "URBAN", "39.6%", "165.6", "118.2"));
        tsiInfos.add(new TSIInfo("RAIPUR ASE", "URBAN", "31.8%", "222.2", "106.9"));

        return tsiInfos;
    }

}
