package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws FileNotFoundException {
        File file3 = new File(args[0]);
        Scanner scanner = new Scanner(file3);
        ArrayList<Integer> numbersArr = new ArrayList<>();

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            numbersArr.add(num);
        }
        getMinTurnNum(numbersArr);
    }

    /**
     * Метод выводит минимальное количество ходов для приведения всех элементов к одному числу.
     *
     * @param arrayList массив чисел
     */
    private static void getMinTurnNum(ArrayList<Integer> arrayList) {
        int sum = 0;
        int elemAmount = 0;
        for (Integer num : arrayList) {
            sum += num;
            elemAmount++;
        }
        int midNum = sum / elemAmount;
        int count = 0;
        for (Integer elem : arrayList) {
            while (elem != midNum) {
                if (elem < midNum) {
                    elem++;
                    count++;
                }
                if (elem > midNum) {
                    elem--;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}