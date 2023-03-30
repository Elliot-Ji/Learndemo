package com.example.suanfa.dataStructure.recursion;

/**
 * 八皇后问题
 * @author Elliot Ji
 * @date 2020/3/18.
 */
public class Queen8 {
    int max = 8;
    static int counter = 0;
    int[] array = new int[max];

    public static void main(String[] args) {
        Queen8 q = new Queen8();
        q.check(0);
        System.out.println("一共有"+ counter +"解法");
    }

    /**
     * 依次放置第n个皇后,
     * @param n
     */
    private void check(int n){
        if(n == max){  // n=8时,第8 个皇后已经放好
            print();
            return;
        }
        //依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n,放到该行的第一列
            array[n] = i;
            //判断当前放置第n个皇后到i列时,是否冲突
            if(judge(n)){ //不冲突
                check(n+1); //接着放n+1个皇后,开始递归
            }
            //如果冲突,继续执行array[n] = i;
        }
    }

    /**
     * 查看当我们放置第n个皇后,就是检测该皇后是否和前面已经摆放的皇后冲突
     * @param n  表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        for(int i = 0; i < n; i++ ){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                 return false;
            }
        }
        return true;
    }

    private  void print(){
        counter++;
        for (int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }



}
