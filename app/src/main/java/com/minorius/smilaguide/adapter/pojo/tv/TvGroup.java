package com.minorius.smilaguide.adapter.pojo.tv;

/**
 * Created by minorius on 04.09.2017.
 */

public class TvGroup implements TvMarker{

    private String nameGroup;

    public TvGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
}
