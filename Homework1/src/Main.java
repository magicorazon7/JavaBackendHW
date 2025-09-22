import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner writeScan = new Scanner(System.in);
        functions func = new functions();
        int isIntegerArray = 1;

        int nArray = func.getArraySize(writeScan);
        System.out.print("Выберите тип данных в массиве: 1 - целочисленные, 0 - дробные числа ");
        isIntegerArray = writeScan.nextInt();
        //small test
        if (isIntegerArray == 1) {

            int[] arr = new int[nArray];
            arr = func.randomWithRange(arr,writeScan,nArray);
            int arrayMaxVal = func.findMax(arr);
            int arrayMinVal = func.findMin(arr);
            int arrayAver = func.findAverage(arr);
            int[] sortArr = func.ascendedSortArr(arr);

            System.out.println("Max: " + arrayMaxVal);
            System.out.println("Min: " + arrayMinVal);
            System.out.println("Average: " + arrayAver);
            System.out.println("Sorted ascending: " + Arrays.toString(sortArr));

        } else {

            double[] arr = new double[nArray];
            arr = func.randomWithRange(arr,writeScan,nArray);
            double arrayMaxVal = func.findMax(arr);
            double arrayMinVal = func.findMin(arr);
            double arrayAver = func.findAverage(arr);
            double[] sortArr = func.ascendedSortArr(arr);

            System.out.println("Max: " + arrayMaxVal);
            System.out.println("Min: " + arrayMinVal);
            System.out.println("Average: " + arrayAver);
            System.out.println("Sorted ascending: " + Arrays.toString(sortArr));

        }

    }
}


class functions{

    double[] randomWithRange(double[] arr, Scanner scanner, int size) {
        double max;
        double min;
        System.out.println("Введите максимальное допустимое значение случайного числа ");
        max = scanner.nextDouble();
        System.out.println("Введите минимальное допустимое значение случайного числа ");
        min = scanner.nextDouble();
        double range = max - min;

        for(int i = 0; i < size; ++i) {
            arr[i] = Math.random() * range + min;
        }

        return arr;
    }

    int[] randomWithRange(int[] arr, Scanner scanner, int size) {
        int max;
        int min;
        System.out.println("Введите максимальное допустимое значение случайного числа ");
        max = scanner.nextInt();
        System.out.println("Введите минимальное допустимое значение случайного числа ");
        min = scanner.nextInt();
        int range = max - min + 1;

        for(int i = 0; i < size; ++i) {
            arr[i] = (int)(Math.random() * range) + min;
        }

        return arr;
    }

    double findMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    double findMin(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    int findMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    double findAverage(double[] array) {
        double average = 0;
        for (double v : array) {average += v;}
        return average/array.length;
    }

    int findAverage(int[] array) {
        int average = 0;
        for (int j : array) {average += j;}
        return average/array.length;
    }

    int getArraySize(Scanner scan) {
        int size;
        do {
            System.out.print("Введите размер массива (больше 0): ");
            size = scan.nextInt();
            if (size <= 0) {
                System.out.println("Ошибка! Размер массива должен быть больше 0.");
            }
        } while (size <= 0);

        return size;
    }

    int[] ascendedSortArr(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }

    double[] ascendedSortArr(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    double tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }

    int[] descendingSortArr(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }

    double[] descendingSortArr(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[j - 1]) {
                    double tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }
}