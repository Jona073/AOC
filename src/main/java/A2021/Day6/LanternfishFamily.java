package A2021.Day6;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LanternfishFamily {
    private Map<Integer,Long> lanternfishs = new HashMap<>();
    private static final int CYCLE_NEW_BORN = 8;
    private static final int CYCLE_NEXT_CYCLE = 6;


    public void nextDay() {
        Map<Integer,Long> lanterfishfamilys= new HashMap<>();

        lanterfishfamilys.put(CYCLE_NEW_BORN,this.lanternfishs.getOrDefault(0,0L));
        lanterfishfamilys.put(CYCLE_NEXT_CYCLE,this.lanternfishs.getOrDefault(0,0L));
        for (int i = 1; i <= CYCLE_NEW_BORN; i++) {
            if (lanterfishfamilys.containsKey(i-1)) {
                lanterfishfamilys.merge(i-1,this.lanternfishs.getOrDefault(i,0L),Long::sum);
            } else {
                lanterfishfamilys.put(i-1,this.lanternfishs.getOrDefault(i,0L));
            }
        }
        this.lanternfishs = new HashMap<>(lanterfishfamilys);
    }
    public long computeSizeFamily() {
        return this.lanternfishs.values().stream()
                .reduce(Long::sum)
                .orElse(0L);
    }
}
