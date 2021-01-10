package Week_01.code;

/**
 * @author RenTian Liu
 * @version 1.0
 * @date 2021-01-10 11:59
 */
public class HelloByteCode {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        int i = 3;
        double d = sum(i, array);
        System.out.println(d);
    }

    public static int sum(int i,int [] array){
        if (array.length == 0) {
            return i;
        }else{
            int sum = 0;
            for (int a : array) {
                sum += a;
                sum += i;
            }
            return sum;
        }
    }
}
