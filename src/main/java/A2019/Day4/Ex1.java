package A2019.Day4;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
            String input = "125730-579381";
           System.out.println("result : " + computeNumberCorrectPassword(input));

        System.out.println("111111  : " + isCorrectPassword("111111"));
        System.out.println("223450  : " + isCorrectPassword("223450"));
        System.out.println("123789  : " + isCorrectPassword("123789"));

    }

    public static int computeNumberCorrectPassword(String input) {
        int min = Integer.parseInt(input.split("-")[0]);
        int max = Integer.parseInt(input.split("-")[1]);
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (isCorrectPasswordV2(String.valueOf(i))) {
                count++;
            }
        }
        return count;
    }

    public static boolean isCorrectPassword(String number) {
        boolean hasDouble = false;
        boolean isDecrease = true;
        char lastCarac = 0;
        for (char car : number.toCharArray()) {
            if (car == lastCarac) {
                hasDouble = true;
            }
            if (lastCarac > car && lastCarac != 0) {
                isDecrease = false;
            }
            lastCarac = car;
        }
        return hasDouble && isDecrease;
    }

    public static boolean isCorrectPasswordV2(String number) {
        boolean hasDouble = false;
        boolean isDecrease = true;
        char lastCarac = 0;
        Map<Character, Integer> numberOccurence = new HashMap<>();
        for (char car : number.toCharArray()) {
            if (lastCarac > car && lastCarac != 0) {
                isDecrease = false;
            }
            if (numberOccurence.containsKey(car)) {
                numberOccurence.replace(car,numberOccurence.get(car)+1);
            } else {
                numberOccurence.put(car,1);
            }
            lastCarac = car;
        }
        if (numberOccurence.containsValue(2)) {
            hasDouble = true;
        }
        return hasDouble && isDecrease;
    }
}
