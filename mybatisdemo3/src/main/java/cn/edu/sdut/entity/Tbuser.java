package cn.edu.sdut.entity;

import java.util.Date;

public class Tbuser {
    private int userid;
    private String username,password,userroles,nickname;
    private Date regtime;

    public Tbuser() {
    }

    public Tbuser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Tbuser(int userid, String username, String password, String userroles, String nickname, Date regtime) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.userroles = userroles;
        this.nickname = nickname;
        this.regtime = regtime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserroles() {
        return userroles;
    }

    public void setUserroles(String userroles) {
        this.userroles = userroles;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "Tbuser{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userroles='" + userroles + '\'' +
                ", nickname='" + nickname + '\'' +
                ", regtime=" + regtime +
                '}';
    }
}
