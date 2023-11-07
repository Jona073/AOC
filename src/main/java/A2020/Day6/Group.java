package A2020.Day6;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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
        return (int) this.answersPeoples.stream()
                // Concat les réponses en un seul String
                .collect(Collectors.joining(""))
                // Fait un IntStream du String
                .chars()
                // Map en char
                .mapToObj(i -> (char) i)
                // Transforme en Map<char,int>
                .collect(groupingBy(character -> character, counting()))
                // Récupère valeur de la map
                .values().stream()
                // Garde que les char(réponse) == nombre personne
                .filter(nbOccurences -> nbOccurences == this.answersPeoples.size())
                .count();
    }


}
