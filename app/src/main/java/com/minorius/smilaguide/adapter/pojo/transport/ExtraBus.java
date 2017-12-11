package com.minorius.smilaguide.adapter.pojo.transport;

/**
 * Created by minorius on 15.09.2017.
 */

public class ExtraBus implements MarkerTransport {

    private String title;
    private String description;
    private String url;

    public ExtraBus(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
