package A2018.Day4;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

public class Action implements Comparator<Action> {
    private LocalDateTime dateTime;
    private String action;

    //
    //EX :    DATETIME          ACTION
    //       [1518-11-22 00:00] Guard #1231 begins shift
    public Action(String input) {
        int years = Integer.parseInt(input.split("[]")[1].split("-")[0]);
        int month = Integer.parseInt(input.split("[]")[1].split("-")[1]);
        int day = Integer.parseInt(input.split("[]")[1].split("-")[2].split(" ")[0]);
        int hour = Integer.parseInt(input.split(" ")[1].split(":")[0]);
        int minute = Integer.parseInt(input.split(":")[1].split("]")[0]);
        this.dateTime = LocalDateTime.of(years,month,day,hour,minute);
        this.action = input.split("]")[1];
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getAction() {
        return action;
    }

    @Override
    public int compare(Action o1, Action o2) {
        if (o1.equals(o2))
            return 0;
        else
            return o1.getDateTime().compareTo(o2.getDateTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action)) return false;
        Action action = (Action) o;
        return Objects.equals(dateTime, action.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime);
    }



}
