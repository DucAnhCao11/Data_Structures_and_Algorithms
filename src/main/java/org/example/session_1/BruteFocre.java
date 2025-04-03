package org.example.session_1;

public class BruteFocre {
    int[] array = {3,4,-5,6,-12,-23,20,11};
    int n = array.length;
    int maxSum = Integer.MIN_VALUE;

    // Hàm brute force thông thường
    public Integer maxSum(){
        for(int i = 0; i <= n -1 ; i++){
            for (int j = i ; j <= n - 1; j ++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum +=  array[k];
                    if(sum > maxSum){
                        maxSum = sum;
                    }
                }
            }
        }
        return maxSum;
    }

    // Hàm brute force thu gọn
    public Integer maxSum2(){
        for(int i = 0; i <= n -1 ; i++){
            int sum = 0;
            for (int j = i ; j <= n - 1; j ++){
                sum += array[j];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        BruteFocre bruteFocre = new BruteFocre();
        System.out.println("Giá trị lớn nhất của dãy số:" + bruteFocre.maxSum2());
    }
}
