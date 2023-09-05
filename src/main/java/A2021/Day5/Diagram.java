package A2021.Day5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Diagram {
    List<Segment> segments;

    public Diagram() {
        this.segments = new ArrayList<>();
    }

    public void addSegment(Segment segment) {
        this.segments.add(segment);
    }

    public int computeNodesNumber() {
        int count = 0;
        List<Point> points = new ArrayList<>();
        for (Segment segment: this.segments) {
            points.addAll(segment.getAllPoint());
        }
        Set<Point> uniquePoint = new HashSet<>();
        count = points.stream().filter(Predicate.not(uniquePoint::add)).collect(Collectors.toSet()).size();

        return count;
    }

}
