package javaPackage;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class HelloWorld {

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Hello Girl!");

        Comparator<Student> com = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num = o1.getNum()- o2.getNum();
                int num2 = num == 0? o1.gerName().compareTo(o2.gerName()) : num;
                return num2;
            }
        };

//        TreeSet<Student> s = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                int x = o1.gerName().compareTo(o2.gerName());
//                int y = x==0 ? o1.getNum()-o2.getNum() : x;
//                return y;
//            }
//        });
        TreeSet<Student> s = new TreeSet<>(com);
        Student a = new Student();
        a.setNum("abc", 999);
        Student b = new Student();
        b.setNum("abc", 666);
        Student c = new Student();
        c.setNum("aade", 999);

        s.add(a);
        s.add(b);
        s.add(c);
//        for(Student t : s){
//            System.out.println(t.gerName()+" "+t.getNum());
//        }
//        System.out.println("-+------------------");
        BufferedWriter bw = new BufferedWriter(new FileWriter("writeTest.txt"));
        for(Student t : s){
            bw.write(t.gerName()+" "+t.getNum());
            bw.newLine();
            bw.flush();
        }
        bw.close();

    }
}
