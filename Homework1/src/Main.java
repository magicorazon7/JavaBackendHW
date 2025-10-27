import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner writeScan = new Scanner(System.in);
        int isIntegerArray = getDataType(writeScan);
        int nArray = getArraySize(writeScan);
        
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
        double max, min;
        while (true) {
            try {
                System.out.println("Введите максимальное допустимое значение случайного числа ");
                max = scanner.nextDouble();
                System.out.println("Введите минимальное допустимое значение случайного числа ");
                min = scanner.nextDouble();
                
                if (min >= max) {
                    throw new IllegalArgumentException("Минимальное значение должно быть меньше максимального!");
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка! Введите числовое значение.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                scanner.nextLine();
            }
        }
       
        double[] arrCopy =  new double[size];
        double range = max - min;

        for(int i = 0; i < size; ++i) {
            arrCopy[i] = Math.random() * range + min;
        }

        return arrCopy;
    }

    static int[] randomWithRange(int[] array, Scanner scanner, int size) {
        int max, min;
        
        while (true) {
            try {
                System.out.println("Введите максимальное допустимое значение случайного числа ");
                max = scanner.nextInt();
                System.out.println("Введите минимальное допустимое значение случайного числа ");
                min = scanner.nextInt();
                
                if (min >= max) {
                    throw new IllegalArgumentException("Минимальное значение должно быть меньше максимального!");
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка! Введите числовое значение.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                scanner.nextLine();
            }
        }
        
        
        int[] arrCopy =  new int[size];
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
        while (true) {
            try {
                System.out.println("Введите размер массива (больше 0): ");
                int size = scan.nextInt();
                if (size <= 0) {
                    throw new IllegalArgumentException("Размер массива не может быть меньше или равен нулю!");
                }
                return size;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка! Недопустимый тип переменной, введите целое число");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                scan.nextLine();
            }
        }
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
    
    static int getDataType(Scanner scan) {
        while (true) {
            try {
                System.out.println("Выберите тип данных в массиве: 1 - целочисленные, 0 - дробные числа ");
                int choice = scan.nextInt();
                if (choice != 0 && choice != 1) {
                    throw new IllegalArgumentException("Выберите либо 1, либо 0!");
                }
                return choice;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка! Недопустимый тип переменной, введите целое число");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                scan.nextLine();
            }
        }
    }
}


