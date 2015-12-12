package Entities;

/**
 * Created by Daniel Shchepetov on 12.12.2015.
 */
public class Vacancy {
    private int id;
    private int p_id;
    private int c_id;
    private int payment;
    private String cond;
    private String req;
    private String home;
    private int archive;
    private String company;
    private String pos;

    public Vacancy(int id, String pos, int c_id, String company, int payment, String cond, String req, String home ) {
        this.id = id;
        this.c_id = c_id;
        this.payment = payment;
        this.cond = cond;
        this.req = req;
        this.home = home;
        this.company = company;
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
