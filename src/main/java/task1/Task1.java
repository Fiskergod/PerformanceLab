package task1;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        int index = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (true) {
            result.add(arr.get(index));
            index += m - 1;
            if (index >= n) {
                index %= n;
            }
            if (arr.get(index) == 1) {
                break;
            }
        }

        System.out.println(result);
    }
}