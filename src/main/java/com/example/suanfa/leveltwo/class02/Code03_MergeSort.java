package com.example.suanfa.leveltwo.class02;

/**
 * 归并排序: 时间复杂度O(N*logN)
 * @author: Elliot Ji
 * @createDate: 2023-01-30
 **/
public class Code03_MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,22,34,1,-3,99,39,44,34,46};
        mergeSort1(arr);
        for (int t:arr) {
            System.out.print(t + " ");
        }

    }

    //递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr,0,arr.length -1);
    }

    public static void process(int[] arr,int L,int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R-L) >> 1);
        process(arr,L,mid);
        process(arr,mid + 1,R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr,int L,int M,int R) {
        int[] help = new int[R -L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        //p1和p2都不越界
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //此时p2越界
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        //此时p1越界
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    //非递归方法实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;//步长
        while (mergeSize < N) {
            int L = 0;//当前左组的第一个位置
            while (L < N) {
                int M = L + mergeSize -1;//当前左组的最后一个位置
                if (M >= N) {
                    break;
                }
                int R = Math.min(M + mergeSize, M -1);//右组的最后一个数的位置
                merge(arr,L,M,R);
                L = R + 1;
            }
            //防止溢出,当mergeSize 无限接近N(N为接近int整型的最大值的数组长度),但还是小于N的,如果再乘以2,就会溢出
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    //题目1: 小和问题: 判断标准: (1).右组比左组小,不产生小和
    public static int samllSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process2(arr,0,arr.length - 1);
    }

    public static int process2(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r -l) >> 1);
        return process2(arr, l,mid) + process2(arr,mid + 1,r) + merge2(arr,l,mid,r);
    }

    public static int merge2(int[] arr,int L,int m,int r) {
        int[] help = new int[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0;  i < help.length ; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }

    //题目2: 一个数组中有多少个逆序对(提示:从右往左合并)

    //题目3: 一个数组中,每个数,右边的数再乘以2之后,还比当前这个数小的有多少个
    public static  int biggerTwice(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process3(arr, 0,arr.length - 1);
    }

    public static int process3(int[] arr, int l,int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process3(arr,l,mid) + process3(arr,mid + 1,r) + merge3(arr,l,mid,r);
    }

    public static int merge3(int[] arr,int L,int m,int r) {
        int ans = 0;
        int windowR = m + 1;
        for (int i = L; i <= m; i++) {
            while (windowR <= r && arr[i] > (arr[windowR] << 1)) {
                windowR++;
            }
            ans += windowR - m -1;
        }
        int[] help = new int[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length ; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

    //题目4:
    public static int countRangeSum(int[] nums,int lower,int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length ; i++) {//获取一个数组的前缀和数组
            sum[i] = sum[i - 1] + nums[i];
        }
        return count(sum,0,nums.length -1,lower,upper);
    }

    public static int count (int[] sum,int L,int R,int lower,int upper) {
        if (L ==R) {
            if (sum[L] >= lower && sum[L] <= upper) {
                return 1;
            }else {
                return 0;
            }
        }
        int mid = ( L + R) / 2;
        int leftPart = count(sum,L,mid,lower,upper);
        int rightPart = count(sum,mid + 1,R,lower,upper);
        int merge = merge4(sum,L,mid,R,lower,upper);
        return leftPart + rightPart + merge;
    }

    public static int merge4(int[] arr,int L,int M,int R,int lower,int upper) {
        int ans = 0;
        int windowL = L;
        int windowR = R;
        for (int i = M + 1; i <= R ; i++) {
            int min = arr[i] - upper;
            int max = arr[i] - lower;
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            ans += Math.max(0,windowR - windowL);
        }
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length ; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

}































