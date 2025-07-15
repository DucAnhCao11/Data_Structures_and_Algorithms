package org.example.session_1;

public class  DeviceAndConquer {
   int mL = Integer.MIN_VALUE;
   int mR = Integer.MIN_VALUE;
   int mM = Integer.MIN_VALUE;

    int[] array = {3,4,-5,6,-12,-23,20,11};

   private Integer maxSum(int [] array, int low, int right) {
       int mid = (low + right) / 2;

       if(low == right)
           return low;
       else {
           mL = maxSum(array, low, mid);
           mR = maxSum(array, mid + 1, right);
           mM = sumCrossMidPoint(array, low, mid, right);
           return max(mL, mR, mM);
       }
   }

    private Integer max(int mL, int mR, int mM) {
       int max = mL;

       if (mR > mL)
           max = mR;

       if (mM > mL) {
           max = mM;
       }

       return max;
    }

    private int sumCrossMidPoint(int [] array, int low, int mid, int right) {
        return maxSumLeft(array, low, mid) + maxSumRight(array, mid + 1, right);
    }

    private Integer maxSumLeft(int [] array, int low, int right) {
        int maxSumLeft = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = low; i <= right; i++) {
            sum += array[i];

            maxSumLeft = Math.max(maxSumLeft, sum);
        }
        return maxSumLeft;
    }

    private Integer maxSumRight(int [] array, int low, int right) {
        int maxSumRight = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = right; i >= low; i--) {
            sum += array[i];

            maxSumRight = Math.max(maxSumRight, sum);
        }
        return maxSumRight;
    }

    public static void main(String[] args) {
        DeviceAndConquer dac = new DeviceAndConquer();
        System.out.println("Tổng giá trị lớn nhất của dãy số trong mảng là: "
                + dac.maxSum(dac.array, 0, dac.array.length - 1));

        System.out.println(dac.mL);
        System.out.println(dac.mR);
        System.out.println(dac.mM);
    }
}
