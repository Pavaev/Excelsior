package Entities;

/**
 * Created by Daniel Shchepetov on 11.12.2015.
 */
public class Find {
    private int id;
    private int u_id;
    private String name;
    private String pos;
    private int archive;

    public Find(int u_id, String pos) {
        this.u_id = u_id;
        this.pos = pos;
    }
    public Find(int id, String pos,  int u_id, String name) {
        this.id = id;
        this.pos = pos;
        this.u_id = u_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    public String getName() {
        return name;
    }

    public void setName(String u_name) {
        this.name = name;
    }
}