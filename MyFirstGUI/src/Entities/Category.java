package Entities;

/**
 * Created by Daniel Shchepetov on 13.11.2015.
 */
public class Category {
private int id;
private String name;
    private String parent;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
