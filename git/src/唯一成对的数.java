/*
    1-1000这1000个数放在含有1001个元素的数组中，只有唯一的一个元素值重复，其他均只出现一次。
    每个数组元素只能访问一次，设计一个算法，将它找出来，不用辅助存储空间，能否设计一个算法实现

    解题思路：
    异或运算（^），A^A = 0, B^0 = B，比如A^A^B^C^C = B，可见异或运算可以将重复的值去除，则把数组中所有的元素和1-1000，这2001个数全部异或
    起来，除了数组中重复的那一位，其他的数两两对应直接去除
 */

import java.util.Random;

public class 唯一成对的数 {
    public static void main(String[] args) {
        int i = 0;

        int N = 1001;
        int[] arr = new int[N];
        //除了最后一位，数组的其他位置全部放上值
        for(i = 0; i < arr.length-1;i ++){
            arr[i] = i + 1;
        }
        //给数组最后一个位置随机生成一个数
        arr[arr.length -1] = new Random().nextInt(N - 1) + 1;
        for(int num : arr){
            System.out.print(num + ",");
        }
        int S = 0;
        for(i = 1;i <= N-1;i ++){
            S = (S ^ i);
        }

        for(i = 0;i < arr.length;i ++){
            S = S ^ arr[i];
        }
        System.out.println();
        System.out.println(S);
        System.out.println("============");
        //下面给出用辅助空间的解法:
        //创建另外一个数组，扫描arr数组,若第一个是3，则helper下标为3的位置+1，第二个为10，则下标为10的地方+1，最后扫描helper数组看哪个下标的值为2
        int[] helper = new int[N];
        for(i = 0;i < N;i ++){
            helper[arr[i]]++;
        }
        for(i = 0;i < N;i ++){
            if(helper[i] == 2){
                System.out.println(i);
                break;
            }
        }
    }
}
