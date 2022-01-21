package main6;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class main6 {
    static Pattern pattern = Pattern.compile("(.*)^2");

    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("D:\\Program Files (x86)\\Tecent_File\\WeChat Files\\wxid_zlu3d3ylxpat21\\FileStorage\\File\\2021-11\\SCARA_minMatrix.txt");
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader bf = new BufferedReader(reader);

        File file = new File("D:\\Program Files (x86)\\Tecent_File\\WeChat Files\\wxid_zlu3d3ylxpat21\\FileStorage\\File\\2021-11\\SCARA_minMatrix(1).txt");
        if (file.exists()) {
            file.delete();
        }
        if (!file.createNewFile()) {
            System.out.println("create file failed!!!");
            return;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        String line;
        while ((line = bf.readLine()) != null) {
            StringBuilder sb = convertLine(line);

            writer.write(sb + "\n");
            writer.flush();
        }

        /*String line = "(a11+b11)^2 + c1^2";
        StringBuilder stringBuilder = convertLine(line);*/
        //System.out.println(stringBuilder);

    }

    private static StringBuilder convertLine(String line) {
        line = line.trim();
        StringBuilder sb = new StringBuilder(line);
        int idx = 0;
        for (; idx < sb.length(); idx++) {
            if (sb.charAt(idx) == '^') {
                if (sb.charAt(idx - 1) == ')') {
                    int rc = 1;
                    int li = idx - 2;
                    for (; li >= 0; li--) {
                        if (sb.charAt(li) == '(') {
                            rc--;
                            if (rc == 0) {
                                break;
                            }
                        } else if (sb.charAt(li) == ')') {
                            rc++;
                        }
                    }

                    sb = new StringBuilder(sb.substring(0, idx) + "*" + sb.substring(li, idx).trim() + sb.substring(idx + 2));
                    idx = idx + 1 + idx - li;
                } else {
                    int li = idx - 1;
                    for (; li >= 0; li--) {
                        if (!isValid(sb.charAt(li))) {
                            break;
                        }
                    }

                    sb = new StringBuilder(sb.substring(0, idx) + "*" + sb.substring(li + 1, idx).trim() + sb.substring(idx + 2));
                    idx = idx + 1 + idx - li;
                }
            }
        }
        return sb;
    }

    static boolean isValid(char c) {
        return Character.isLetterOrDigit(c) || c == ' ';
    }
}

