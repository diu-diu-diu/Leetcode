package javaPackage.Interface;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class Demo {
    public static void main(String[] args) {
        Cat a = new Cat();
        a.setName("qqq");
        a.setAge(6);

        a.test();
        //System.out.println(a.toString());
        Cat b = new Cat("qqq", 6);
        System.out.println(a.equals(b));

        PrintStream mp = new PrintStream(System.out){
            @Override
            public void println(String x) {
                super.println("woc " + x);
            }
        };
        System.setOut(mp);
        System.out.println(b.toString());

        String s = "91 27 54 96 32";
        String[] ss = s.split(" ");    // 分割String数组，存储到一个Integer类型的数组中
        Integer[] array = new Integer[ss.length];
        int i = 0;
        for(String z : ss){
           array[i++] = Integer.parseInt(z);
        }
        //System.out.println(Arrays.toString(array));
        Arrays.sort(array);      // 升序
        StringBuilder sb = new StringBuilder();   // 采用StringBuilder来实现拼接
        for(Integer temp : array){
            sb.append(temp).append(" ");
        }
        System.out.println(sb);


    }



}

