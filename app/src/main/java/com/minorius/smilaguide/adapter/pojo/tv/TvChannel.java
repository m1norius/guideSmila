package com.minorius.smilaguide.adapter.pojo.tv;

/**
 * Created by minorius on 04.09.2017.
 */

public class TvChannel implements TvMarker {

    private String nameChannel;
    private String img;
    private String url;

    public TvChannel(String nameChannel, String img, String url) {
        this.nameChannel = nameChannel;
        this.img = img;
        this.url = url;
    }

    public String getNameChannel() {
        return nameChannel;
    }

    public void setNameChannel(String nameChannel) {
        this.nameChannel = nameChannel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
