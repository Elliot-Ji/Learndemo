package com.example.enums;

/**
 * Created by Elliot Ji on 2019/6/25.
 */
public class TestReg {

    public static void main(String[] args) {
         String str = "We are Yong ";
        String s = replaceStr(str);
        System.out.println(s);
    }

    public static String replaceStr(String str){

        if(str.length() == 0){
            return str;
        }
        char[] chars = str.toCharArray();
        int index = 0;
        for(int i = 0;i<chars.length;i++){
              if(chars[i] != ' '){
                  chars[index] = chars[i];
                  chars[i] =' ';
                  index ++;
              }
        }
        return String.valueOf(chars);
    }
    /*public String replaceSpace(String str) {
        if(str.length() == 0) return str;
        char[] ch = str.toCharArray();
        int index = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != ' '){
                ch[index] = ch[i];
                ch[i] = ' ';
                index++;
            }

        }
        return String.valueOf(ch);
    }*/

}
