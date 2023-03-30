package com.example.suanfa.dataStructure.recursion;

/**
 * Created by Elliot Ji on 2020/2/28.
 */
public class MiGong {
    public static void main(String[] args) {
        //1.使用二维数组模拟迷宫
        int[][] map = new int[8][7];
        //1代表墙,上下设为1
        for(int i = 0;i<7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置为1
        for(int i = 0;i< 8; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        setWay(map,1,1);

        //走完后的地图
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    //使用递归回溯来给小球找路
    //前置说明:
    //1. i,j 表示从哪个位置开始出发(1,1);
    //2.如果小球能到map[6][5],则通路找到;
    //3.约定: map[i][j] = 0 :表示该点没有走过,1表示为墙; 2:表示通路可以走,3:表示该点走过,但不通;
    //4.走迷宫,确定一个策略: 下->右->上->左 如果该点走不通,再回溯
    /**
     *
     * @param map 表示地图
     * @param i  从哪个位置开始
     * @param j  从哪个位置开始
     * @return 如果找到路就返回true, 否则false
     */
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){ //表示通路找到
            return true;
        } else{
            if(map[i][j] == 0){ //如果当前这个点还没有走过
                map[i][j] = 2; //假定改定可以走通
                //按照策略 下->右->上->左
                if(setWay(map, i+1, j)){//向下走
                    return true;
                }else if(setWay(map, i, j+1)){//向右走
                    return true;
                }else if(setWay(map, i-1, j)){//向上走
                    return true;
                }else if(setWay(map, i, j-1)){//向左走
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;//说明该路走不通.置为3
                }
            }else{ //map[i][j] 可能为1,2,3
                return false;
            }
        }
    }

}
