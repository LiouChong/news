package com.example.paixu;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = new int[]{7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(shellSort(a)));
    }

    /**
     * 插入排序
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int cur = 0;
        int pre, index;
        for (int i = 1; i < array.length - 1; i++) {
            cur = array[i];
            pre = i - 1;
            while (pre >= 0 && cur < array[pre]) {
                array[i] = array[pre];
                pre --;
            }
            array[pre + 1] = cur;
        }
        return array;
    }

    /**
     * 希尔排序
     * @return
     */
    public static int[] shellSort(int[] array) {
        int length = array.length;
        int startAndUnit = length / 2;
        while (startAndUnit > 0) {
            for (int i = startAndUnit; i < length; i ++) {
                int curValue = array[i];
                int preIndex = i - startAndUnit;
                while (preIndex >= 0 && array[preIndex] > curValue) {
                    array[preIndex + startAndUnit] = array[preIndex];
                    preIndex -= startAndUnit;
                }
                array[preIndex + startAndUnit] = curValue;
            }
            startAndUnit /= 2;
        }
        return array;
    }

    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2 ;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
