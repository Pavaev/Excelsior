package Entities;

/**
 * Created by Daniel Shchepetov on 07.12.2015.
 */
public class Unemployed {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String sp;
    private String home;
    private String address;
    private String phone;
    private String stud;
    private String prof;
    private String lastWork;
    private String lastPos;
    private String dismiss;
    private int archive;
    private String archiveN;


    public Unemployed(String name, int age,String sex, String sp, String home, String address, String phone, String stud, String prof, String lastWork, String lastPos, String dismiss) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.sp = sp;
        this.home = home;
        this.address = address;
        this.phone = phone;
        this.stud = stud;
        this.prof = prof;
        this.lastWork = lastWork;
        this.lastPos = lastPos;
        this.dismiss = dismiss;
    }
    public Unemployed(int id,String name, int age, String sp,String prof, String stud, String lastWork, String lastPos, String dismiss, String home, String address, String phone, int archive,String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.sp = sp;
        this.home = home;
        this.address = address;
        this.phone = phone;
        this.stud = stud;
        this.prof = prof;
        this.lastWork = lastWork;
        this.lastPos = lastPos;
        this.dismiss = dismiss;
        this.id = id;
        this.archive = archive;
    }
    public Unemployed(int id,String name, int age,String sex, String address, String phone, String stud, String prof) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.stud = stud;
        this.prof = prof;

    }
    public Unemployed(int id,String name, int age,String sex, String address, String phone, String stud, String prof, String archiveN) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.stud = stud;
        this.prof = prof;
        this.archiveN = archiveN;

    }

    public int getArchive() {
        return archive;
    }

    public void setArchive(byte archive) {
        this.archive = archive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStud() {
        return stud;
    }

    public void setStud(String stud) {
        this.stud = stud;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getLastWork() {
        return lastWork;
    }

    public void setLastWork(String lastWork) {
        this.lastWork = lastWork;
    }

    public String getLastPos() {
        return lastPos;
    }

    public void setLastPos(String lastPos) {
        this.lastPos = lastPos;
    }

    public String getDismiss() {
        return dismiss;
    }

    public void setDismiss(String dismiss) {
        this.dismiss = dismiss;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArchiveN() {
        return archiveN;
    }

    public void setArchiveN(String archiveN) {
        this.archiveN = archiveN;
    }
}
