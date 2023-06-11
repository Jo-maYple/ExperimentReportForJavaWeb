package main.java;

public class Student {
    private String number;
    private String userName;
    private enum Gender{MAN, WOMAN};
    private Gender sex;
    private String className;
    private String department;

    public Student(){;}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        if (this.sex==Gender.MAN){return "男";}
        else {return "女";}
    }

    public void setSex(String sex) {
        if (sex.equals("男")){
            this.sex = Gender.MAN;
        } else if (sex.equals("女")){
            this.sex = Gender.WOMAN;
        }
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return
                "学生姓名为:" + this.getUserName() +
                ",学生学号为:" + this.getNumber() +
                ",学生性别为:" + this.getSex() +
                ",学生班级为:" + this.getClassName() +
                ",学生所属院系为:" + this.getDepartment();
    }
}
