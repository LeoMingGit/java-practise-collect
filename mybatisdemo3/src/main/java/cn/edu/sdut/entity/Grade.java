package cn.edu.sdut.entity;

import java.util.List;

public class Grade {

    private List<Student> students;
    private int gradeid;
    private String gradename;

    public Grade() {}

    public Grade(int gradeid, String gradename) {
        this.gradeid = gradeid;
        this.gradename = gradename;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "students=" + students +
                ", gradeid=" + gradeid +
                ", gradename='" + gradename + '\'' +
                '}';
    }
}
