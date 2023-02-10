package com.hzauqkainan.ui.test;

import java.util.Random;

public class test1 {
        public static void main(String[] args) {
            int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8,};
            Random r = new Random();

            //将数组内元素打乱后，遍历数组
            for (int i = 0; i < arr.length; i++) {
                //获取随即索引
                int temp = r.nextInt(arr.length);
                //记录正常顺序下数组中的元素
                int num = arr[i];
                //将随机索引与正常索引进行交换
                arr[i] = arr[temp];
                //将之前记录的”正常顺序下数组中的元素“赋值给随机索引，从而实现打乱顺序
                arr[temp]  = num;
            }

            System.out.println(" ");

            //创建一个二维数组
            int [][] date = new int[3][3];
            int count = 0;

            //遍历二维数组
            for (int i = 0; i < date.length; i++) {
                for (int j = 0; j < date[i].length; j++) {
                    date [i][j] = arr[count];
                    count++;
                    System.out.print(date[i][j] + " ");
                }
                System.out.println(" ");
            }

            System.out.println(" ");

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
}
