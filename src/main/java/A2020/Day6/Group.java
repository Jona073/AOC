package A2020.Day6;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Group {
    List<String> answersPeoples = new ArrayList<>();

    public void addPerson(String input) {
        this.answersPeoples.add(input);
    }

    public int getNumberYes() {
        Set<Character> questionsYes = new HashSet<>();
        this.answersPeoples.stream()
                .flatMap(x-> x.chars().mapToObj(i -> (char) i))
                .forEach(questionsYes::add);
        return questionsYes.size();
    }

    public int getEveryoneYes() {
        int count =0;
        String allResponse = this.answersPeoples.stream()
                .map(String::toString)
                .collect(Collectors.joining(""));

        Set<Character> questionsYes = new HashSet<>();

        allResponse.chars().mapToObj(i->(char) i)
                .forEach(questionsYes::add);

        //Si le même charactere 
        for (char carac : questionsYes) {
            int occurrence = (int) allResponse.chars().filter(character -> character == carac).count();
            if (occurrence == this.answersPeoples.size()) {
                count++;
            }
        }
        return count;
    }



}
