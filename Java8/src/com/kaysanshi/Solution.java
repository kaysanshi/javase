package com.kaysanshi;

import java.util.Arrays;

/**
 * @Author kay三石
 * @date:2019/5/12
 */
public class Solution {
    int[] arrys;
    public int removeDuplicates(int[] nums) {

        nums=sort(nums);
        System.out.println("数组长度："+nums.length+"  ");
            if (nums!=null && nums.length!=0 ) {
                if (nums.length==1){
//                    System.out.println("一的长度:"+nums.length);
                    return  nums.length;
                }else{
                    for (int i=0;i<nums.length-1;i++) {
                        //System.out.print(nums[i]+" ");
                        if (nums[i] == nums[i + 1]) {
                            //System.out.println(nums[i]+",,"+nums[i+1]);
                            nums = delete(i, nums);
                            //System.out.println("第"+i+"次删除重复的元素:剩余的长度"+nums.length);
                            int m = removeDuplicates(nums);
                            return m;
                        } else {
                            // System.out.print(nums[i]+",");
                            //continue;

                        }

                    }

                    for (int i=0;i<nums.length;i++){
                        System.out.print(nums[i]);
                    }

                    return  nums.length;

                }

            }else{
                return 0;
            }

    }
    public int[] delete(int index, int array[]) {
        //数组的删除其实就是覆盖前一位
        int[] arrNew = new int[array.length - 1];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        System.arraycopy(array, 0, arrNew, 0, arrNew.length);

        return arrNew;
    }
    public int[] sort(int arry[]){
        for(int i=0;i<arry.length;i++){
            for(int j=arry.length-1;j>i;j--){
                if (arry[j]<arry[j-1]) {
                    //进行交换
                    int temp;
                    temp=arry[j];
                    arry[j]=arry[j-1];
                    arry[j-1]=temp;
                }
            }
        }
        return arry;
    }
//    main
    public static void main(String[] args){
        int[] arry=new int[]{0,0,1,1,1,2,2,3,3,4};
        Solution solution=new Solution();
//        System.out.println("最终的长度："+solution.removeDuplicates(arry));
        int len = solution.removeDuplicates(arry);
        System.out.println(len);
        System.out.println(Arrays.toString(arry));
    }
}
