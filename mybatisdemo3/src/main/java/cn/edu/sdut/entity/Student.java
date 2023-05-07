package cn.edu.sdut.entity;

public class Student {
    private Grade grade;
    private int stuid;
    private String stuname,gender,stunum;
    private int age;

    public Student() {}

    public Student(Grade grade, int stuid, String stuname, String gender, String stunum, int age) {
        this.grade = grade;
        this.stuid = stuid;
        this.stuname = stuname;
        this.gender = gender;
        this.stunum = stunum;
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", gender='" + gender + '\'' +
                ", stunum='" + stunum + '\'' +
                ", age=" + age +
                ",grade=" + grade+
        '}';
    }
}
