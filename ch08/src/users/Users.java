package users;

public class Users {
    private String id;
    private String name;
    private String password;
    private String sex;
    private String birth;
    private String phone;
    private String email;
    private String majorID;

    public Users() {

    }

    public Users(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Users(String id, String name, String password, String sex,
                 String birth, String phone, String email, String majorID) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birth = birth;
        this.phone = phone;
        this.email = email;
        this.majorID = majorID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    public String getId() {
        return (this.id);
    }

    public String getName() {
        return (this.name);
    }

    public String getPassword() {
        return (this.password);
    }

    public String getSex() {
        return (this.sex);
    }

    public String getBirth() {
        return (this.birth);
    }

    public String getPhone() {
        return (this.phone);
    }

    public String getEmail() {
        return (this.email);
    }

    public String getMajorID() {
        return (this.majorID);
    }
}
