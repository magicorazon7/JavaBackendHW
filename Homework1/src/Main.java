import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner writeScan = new Scanner(System.in);
        int isIntegerArray = 1;

        int nArray = getArraySize(writeScan);
        System.out.print("Выберите тип данных в массиве: 1 - целочисленные, 0 - дробные числа ");
        isIntegerArray = writeScan.nextInt();
        //small test
        if (isIntegerArray == 1) {

            int[] arrayTest = new int[nArray];
            arrayTest = randomWithRange(arrayTest,writeScan,nArray);
            int arrayMaxVal = findMax(arrayTest);
            int arrayMinVal = findMin(arrayTest);
            double arrayAver = findAverage(arrayTest);
            int[] sortArrAsc = sortAscending(arrayTest);
            int[] sortArrDesc = sortDescending(arrayTest);

            System.out.println("Max: " + arrayMaxVal);
            System.out.println("Min: " + arrayMinVal);
            System.out.println("Average: " + arrayAver);
            System.out.println("Sorted ascending (Ascending): " + Arrays.toString(sortArrAsc));
            System.out.println("Sorted ascending (Descending): " + Arrays.toString(sortArrDesc));

        } else {

            double[] arrayTest = new double[nArray];
            arrayTest = randomWithRange(arrayTest,writeScan,nArray);
            double arrayMaxVal = findMax(arrayTest);
            double arrayMinVal = findMin(arrayTest);
            double arrayAver = findAverage(arrayTest);
            double[] sortArrAsc = sortAscending(arrayTest);
            double[] sortArrDesc = sortDescending(arrayTest);

            System.out.println("Max: " + arrayMaxVal);
            System.out.println("Min: " + arrayMinVal);
            System.out.println("Average: " + arrayAver);
            System.out.println("Sorted ascending (Ascending): " + Arrays.toString(sortArrAsc));
            System.out.println("Sorted ascending (Descending): " + Arrays.toString(sortArrDesc));

        }

    }

    static  double[] randomWithRange(double[] array, Scanner scanner, int size) {
        double[] arrCopy = Arrays.copyOf(array, array.length);
        double max;
        double min;
        System.out.println("Введите максимальное допустимое значение случайного числа ");
        max = scanner.nextDouble();
        System.out.println("Введите минимальное допустимое значение случайного числа ");
        min = scanner.nextDouble();
        double range = max - min;

        for(int i = 0; i < size; ++i) {
            arrCopy[i] = Math.random() * range + min;
        }

        return arrCopy;
    }

    static int[] randomWithRange(int[] array, Scanner scanner, int size) {
        int[] arrCopy = Arrays.copyOf(array, array.length);
        int max;
        int min;
        System.out.println("Введите максимальное допустимое значение случайного числа ");
        max = scanner.nextInt();
        System.out.println("Введите минимальное допустимое значение случайного числа ");
        min = scanner.nextInt();
        int range = max - min + 1;

        for(int i = 0; i < size; ++i) {
            arrCopy[i] = (int)(Math.random() * range) + min;
        }

        return arrCopy;
    }

    static double findMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static double findMin(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    static int findMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    static double findAverage(double[] array) {
        double average = 0;
        for (double v : array) {average += v;}
        return average/array.length;
    }

    static double findAverage(int[] array) {
        int average = 0;
        for (int j : array) {average += j;}
        return (double)average/array.length;
    }

    static int getArraySize(Scanner scan) {
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

    static int[] sortAscending(int[] array) {
        int length = array.length;
        int[] arrCopy = Arrays.copyOf(array, length);

        for (int i = 0; i < arrCopy.length - 1; i++) {
            for (int j = 1; j < arrCopy.length - i; j++) {
                if (arrCopy[j] < arrCopy[j - 1]) {
                    int tmp = arrCopy[j];
                    arrCopy[j] = arrCopy[j - 1];
                    arrCopy[j - 1] = tmp;
                }
            }
        }
        return arrCopy;
    }

    static double[] sortAscending(double[] array) {
        int length = array.length;
        double[] arrCopy = Arrays.copyOf(array, length);

        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length - i; j++) {
                if (arrCopy[j] < arrCopy[j - 1]) {
                    double tmp = arrCopy[j];
                    arrCopy[j] = arrCopy[j - 1];
                    arrCopy[j - 1] = tmp;
                }
            }
        }
        return arrCopy;
    }

    static int[] sortDescending(int[] array) {
        int length = array.length;
        int[] arrCopy = Arrays.copyOf(array, length);

        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length - i; j++) {
                if (arrCopy[j] > arrCopy[j - 1]) {
                    int tmp = arrCopy[j];
                    arrCopy[j] = arrCopy[j - 1];
                    arrCopy[j - 1] = tmp;
                }
            }
        }
        return arrCopy;
    }

    static double[] sortDescending(double[] array) {
        int length = array.length;
        double[] arrCopy = Arrays.copyOf(array, length);

        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length - i; j++) {
                if (arrCopy[j] > arrCopy[j - 1]) {
                    double tmp = arrCopy[j];
                    arrCopy[j] = arrCopy[j - 1];
                    arrCopy[j - 1] = tmp;
                }
            }
        }
        return arrCopy;
    }
}


