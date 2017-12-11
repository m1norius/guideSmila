package com.minorius.smilaguide.mvp.transport;

import com.minorius.smilaguide.adapter.pojo.transport.MarkerTransport;

import java.util.ArrayList;

/**
 * Created by minorius on 13.09.2017.
 */

public class BusModel {

    public ArrayList<MarkerTransport> loadSmilaBusList(){
        return Data.getListCityBus();
    }
    public ArrayList<MarkerTransport> loadOutSmilaBusList(){
        return Data.getListBusOutCity();
    }
    public ArrayList<MarkerTransport> loadCharkassySmilaList(){
        return Data.getListBusCherkasySmila();
    }
    public ArrayList<MarkerTransport> loadSmilaCharkassyList(){
        return Data.getListBusSmilaCherkasy();
    }

}
