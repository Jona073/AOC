package A2016.Day4;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Room {
    private String chaine;
    private int id;

    public int getId() {
        return id;
    }

    private String code;

    public Room(String input) {
        this.id = Integer.parseInt(input.substring(input.length() - 10, input.length() - 7));
        this.code = input.split("\\[")[1].split("]")[0];
        this.chaine = String.join("", input.split("\\[")[0].split("[^a-z]"));
    }

    public String computeCode() {
        Map<Character, Integer> numbersCaracs = new HashMap<>();
        for (char carac :
                this.chaine.toCharArray()) {
            int count = numbersCaracs.getOrDefault(carac, 0);
            numbersCaracs.put(carac, count + 1);
        }
        List<Map.Entry<Character, Integer>> sortList = sortByValue(numbersCaracs);

        return String.valueOf(sortList.get(0).getKey()) +
                sortList.get(1).getKey() +
                sortList.get(2).getKey() +
                sortList.get(3).getKey() +
                sortList.get(4).getKey();
    }

    private static List<Map.Entry<Character, Integer>> sortByValue(Map<Character, Integer> unsortMap) {
        List<Map.Entry<Character, Integer>> list =
                new LinkedList<>(unsortMap.entrySet());

        list.sort((o1, o2) -> {
            if (!Objects.equals(o1.getValue(), o2.getValue())) {
                return (o1.getValue()).compareTo(o2.getValue());
            } else {
                return (o2.getKey()).compareTo(o1.getKey());
            }
        });
        Collections.reverse(list);

        return list;
    }

    public boolean isReal() {
        return this.code.equals(computeCode());
    }

    public String decrypt() {
        StringBuilder message = new StringBuilder();
        for (char carac :
                this.chaine.toCharArray()) {
            if (carac == '-') {
                carac = ' ';
            } else {
                carac = (char) (carac + (this.id % 26));
                if (carac > 'z') {
                    carac = (char) (carac - 'z' + 'a' - 1);
                }
            }
            message.append(carac);
        }

        return message.toString();
    }

}
