package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
    static float r, x0, y0;

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        Scanner scanner = new Scanner(file1);

        x0 = scanner.nextFloat();
        y0 = scanner.nextFloat();
        r = scanner.nextFloat();
        scanner = new Scanner(file2);

        while (scanner.hasNextFloat()) {
            float x = scanner.nextFloat();
            float y = scanner.nextFloat();
            System.out.println(getPointPosition(x, y));
        }
    }

    /**
     * Метод вычисляет отношение точки к окружности. По теореме Пифагора.
     * @param x координата x
     * @param y координата y
     * @return положение точки
     */
    private static int getPointPosition(float x, float y) {
        if ((x - x0) * (x - x0) + (y - y0) * (y - y0) == r * r) {
            return 0;
        }
        if ((x - x0) * (x - x0) + (y - y0) * (y - y0) < r * r) {
            return 1;
        }
        return 2;
    }
}