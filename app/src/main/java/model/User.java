package model;

/**
 * Created by nguye on 10/7/2015.
 */
public class User {

    private String name;
    private int imageId;
    private int yBorn;

    public User(String name, int imageId, int yBorn) {
        this.name = name;
        this.imageId = imageId;
        this.yBorn = yBorn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int  getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getyBorn() {
        return yBorn;
    }

    public void setyBorn(int yBorn) {
        this.yBorn = yBorn;
    }
}