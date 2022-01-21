package javaPackage;

public class Student<compareTo> {
    private String name;
    private int num ;
    Student(){

    }

    // 提供函数
    public int getNum() {
        return this.num;
    }
    public  String gerName(){
        return this.name;
    }

    public void setNum(String name, int temp) {
        this.name = name;
        this.num = temp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

}
