public class Homework_3_1 {
    public static double getSum(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double getAverage(double[] array) {
        return getSum(array) / array.length;
    }

    public static int getValueOfLastElement(int[] array) {
        return array[array.length-1];
    }

    public static int getMinValue(int[] array) {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    public static int getMaxValue(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    public static int[] getMinMaxValue(int[] array) {
        int MinMax[] = {getMinValue(array), getMaxValue(array)};
        return MinMax;
    }

    public static String getLongestString(String[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() >= array[index].length()) index = i; 
        }
        return array[index];
    }

    public static int[] getInversedArray(int[] array) {
        int l = array.length;
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[l-i-1];
            array[l-i-1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        double arr[] = {5.0, 3.5, 4.4, 0.8, 1.8, 2.3, 0.6, 1.9, 3.0, 0.7};
        int num[] = {8, 7, 12, 5, 20, 10, 18, 6, 4, 13};
        String s[] = {"java", "class", "method", "double", "int", "string", "array"};

        System.out.print("[");
        int count = 0;
        for (double d : arr) {
            System.out.print(d);
            if (count < arr.length-1) {
                System.out.print(", ");
                count++;
            }
        } System.out.print("]\n");
        System.out.println("Sum = " + getSum(arr));
        System.out.println("Average = " + getAverage(arr));

        count = 0;
        System.out.print("\n[");
        for (int i : num) {
            System.out.print(i);
            if (count < num.length-1) {
                System.out.print(", ");
                count++;
            }
        } System.out.print("]\n");
        System.out.println("Last array element = " + getValueOfLastElement(num));
        System.out.println("Min value in array = " + getMinValue(num));
        System.out.println("Max value in array = " + getMaxValue(num));
        int minmax[] = getMinMaxValue(num);
        
        count = 0;
        System.out.print("Min and Max value = [");
        for (int i : minmax) {
            System.out.print(i);
            if (count < minmax.length-1) {
                System.out.print(", ");
                count++;
            }
        } System.out.print("]\n");

        int inverse[] = getInversedArray(num);
        count = 0;
        System.out.print("Inversed Array = [");
        for (int i : inverse) {
            System.out.print(i);
            if (count < inverse.length-1) {
                System.out.print(", ");
                count++;
            } 
        } System.out.print("]\n");

        count = 0;
        System.out.print("\n[");
        for (String st : s) {
            System.out.print(st);
            if (count < s.length-1) {
                System.out.print(", ");
                count++;
            } 
        } System.out.print("]\n");
        System.out.println("String terpanjang dalam array = " + getLongestString(s));
    }
}