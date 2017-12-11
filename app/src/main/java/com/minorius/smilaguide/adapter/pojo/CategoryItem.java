package com.minorius.smilaguide.adapter.pojo;

/**
 * Created by minorius on 29.08.2017.
 */

public class CategoryItem {
    private String imageName;
    private String categoryName;

    public CategoryItem(String imageName, String categoryName) {
        this.imageName = imageName;
        this.categoryName = categoryName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
