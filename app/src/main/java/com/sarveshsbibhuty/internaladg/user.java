package com.sarveshsbibhuty.internaladg;

public class user {

    String regno;
    String name;
    String password;
    Boolean attendance;
    String workone;
    String worktwo;
    String workthree;

    public String getWorkone() {
        return workone;
    }

    public String getWorktwo() {
        return worktwo;
    }

    public String getWorkthree() {
        return workthree;
    }

    public String getRegno() {
        return regno;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAttendance() {
        return attendance;
    }

    public user(String regno,String name,String password,Boolean attendance,String workone,String worktwo,String workthree)

    {
        this.regno=regno;
        this.name=name;
        this.password=password;
        this.attendance=attendance;
        this.workone=workone;
        this.worktwo = worktwo;
        this.workthree = workthree;

    }
    public user()
    {
        this.regno=regno;
        this.password=password;
    }
}
