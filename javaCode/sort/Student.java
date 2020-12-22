package javaCode.sort;

public class Student implements Comparable<Student> {
    private String uname;
    private int age;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return "Stu{ uname = " + uname + ", age = " + age + "}";
    }
	
}