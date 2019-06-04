package users;

public class Student extends Users {
    private String classID;
    public Student() {

    }

    public Student(String id,String name,String password,String sex,String birth,String phone,String email,String majorID,String classID) {
        super(id,name,password,sex,birth,phone,email,majorID);
        this.classID=classID;
    }

}
