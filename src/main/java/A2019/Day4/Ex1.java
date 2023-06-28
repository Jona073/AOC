package A2019.Day4;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
            String input = "125730-579381";
           System.out.println("result : " + computeNumberCorrectPassword(input));
    }

    public static int computeNumberCorrectPassword(String input) {
        String[] stringInput = input.split("-");
        int min = Integer.parseInt(stringInput[0]);
        int max = Integer.parseInt(stringInput[1]);
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
        char lastCarac = 0;
        for (char car : number.toCharArray()) {
            if (car == lastCarac) {
                hasDouble = true;
            }
            if (lastCarac > car) {
                return false;
            }
            lastCarac = car;
        }
        return hasDouble;
    }

    public static boolean isCorrectPasswordV2(String number) {
        boolean hasDouble = false;
        char lastCarac = 0;
        Map<Character, Integer> numberOccurence = new HashMap<>();
        for (char car : number.toCharArray()) {
            if (lastCarac > car) {
                return false;
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
        return hasDouble;
    }
}
