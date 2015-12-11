package Entities;

/**
 * Created by Daniel Shchepetov on 11.12.2015.
 */
public class Find {
    private int id;
    private int u_id;
    private String pos;
    private int archive;

    public Find(int u_id, String pos) {
        this.u_id = u_id;
        this.pos = pos;
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
}
