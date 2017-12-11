package com.minorius.smilaguide.retrofit.buy.pojo;

/**
 * Created by minorius on 26.09.2017.
 */

public class OfferForPurchase {

    private int id;
    private String topic;
    private String title;
    private String description;
    private String price;
    private String date;
    private String contacts;

    private String key;
    private String email;

    private Boolean isModeration = false;


    public OfferForPurchase() {
    }


    public OfferForPurchase(String topic, String title, String description, String price, String date, String contacts, String key, String email, boolean isModeration) {
        this.topic = topic;
        this.title = title;
        this.description = description;
        this.price = price;
        this.date = date;
        this.contacts = contacts;
        this.key = key;
        this.email = email;
        this.isModeration = isModeration;
    }

    public boolean isModeration() {
        return isModeration;
    }

    public void setModeration(boolean moderation) {
        isModeration = moderation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "OfferForPurchase{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", date='" + date + '\'' +
                ", contacts='" + contacts + '\'' +
                ", key='" + key + '\'' +
                ", email='" + email + '\'' +
                ", isModeration=" + isModeration +
                '}';
    }
}
