package users;

public class Teacher extends Users {
    private String graduateSchool;
    private String education;
    private String duty;
    private String title;
    private String study;
    private String resume;

    public Teacher() {

    }

    public Teacher(String id, String name, String password, String sex,
                   String birth, String phone, String email,
                   String graduateSchool, String education, String duty,
                   String title, String majorID, String study, String resume) {
        super(id, name, password, sex, birth, phone, email, majorID);
        this.graduateSchool = graduateSchool;
        this.education = education;
        this.duty = duty;
        this.title = title;
        this.study = study;
        this.resume = resume;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getGraduateSchool() {
        return (this.graduateSchool);
    }

    public String getEducation() {
        return (this.education);
    }

    public String getDuty() {
        return (this.duty);
    }

    public String getTitle() {
        return (this.title);
    }

    public String getStudy() {
        return (this.study);
    }

    public String getResume() {
        return (this.resume);
    }
}
