package hh.z2;

import java.util.*;

    class Interval {
        public Integer start;
        public Integer end;

        public Interval(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
        public Integer length() {
            return end - start + 1;
        }
    }
    abstract class Point {
        public Integer value;
        public Point(Integer value) {
            this.value = value;
        }
        abstract Integer change();
    }
    class StartPoint extends Point {
        public StartPoint(Integer value) {
            super(value);
        }
        public Integer change() {
            return 1;
        }
    }
    class EndPoint extends Point {
        public EndPoint(Integer value) {
            super(value);
        }
        public Integer change() {
            return -1;
        }
    }

    public class Main_Anton {
        public static void main(String[] args) {
            // read input:
            Scanner scanner = new Scanner(System.in);
            String firstLine = scanner.nextLine();
            int inputLength = Integer.parseInt(firstLine);
            List<Interval> inputIntervals = new ArrayList<>();
            for (int i = 0; i < inputLength; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                inputIntervals.add(new Interval(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            }

            // convert intervals into points:
            List<Point> inputPoints = new ArrayList<>();
            for (Interval inputInterval : inputIntervals) {
                inputPoints.add(new StartPoint(inputInterval.start));
                inputPoints.add(new EndPoint(inputInterval.end));
            }

            // sort points:
            inputPoints.sort((a, b) -> a.value - b.value);

            // build intervals between points and calculate max value:
            Map<Integer, List<Interval>> output = new HashMap<>();
            Integer currentValue = 0, maxValue = 0;
            for (int i = 0; i < inputPoints.size() - 1; i++) {
                Point start = inputPoints.get(i);
                Point end = inputPoints.get(i + 1);
                currentValue += start.change();
                if (currentValue > maxValue) {
                    maxValue = currentValue;
                }
                if (!output.containsKey(currentValue)) {
                    output.put(currentValue, new ArrayList<>());
                }
                output.get(currentValue).add(new Interval(start.value, end.value));
            }

            // calculate intervals sum
            Integer intervalsTotalLength = 0;
            for (Interval interval : output.get(maxValue)) {
                intervalsTotalLength += interval.length();
            }

            // output
            Integer intervalsCount = output.get(maxValue).size();
            System.out.printf("%s %s%n", intervalsCount, intervalsTotalLength);
        }
    }