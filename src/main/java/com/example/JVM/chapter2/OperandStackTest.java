package com.example.JVM.chapter2;

/**
 * @author: Elliot Ji
 * @createDate: 2023-04-24
 **/
public class OperandStackTest {

    public void testAddOperation() {
         byte i = 15;
         int j = 8;
         int k = i + j;
    }

    public int getSum() {
        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }

    public void testGetSum() {
        int i = getSum();
        int j = 10;
    }

}
