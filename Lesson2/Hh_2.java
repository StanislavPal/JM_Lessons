package Lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Hh_2 {
    public static void main(String[] args) {

        //System.out.println("Введите данные:");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Edge[] edges = new Edge[count * 2];

        for (int i = 0; i < count; i++) {
            long time = Long.parseLong( in.next() );
            edges[i * 2] = new Edge(time - 1, 1);
            time = Long.parseLong( in.next() );
            edges[i * 2 + 1] = new Edge(time, -1);
        }

        in.close();

        Arrays.sort(edges);

        boolean bMax = false;
        int costCount = 0;
        int costCountMax = 0;
        long intervalSum = 0;
        int intervalCount = 0;

        for (Edge edge : edges ) {

            costCount += edge.getCost();

            if (costCount > costCountMax) {
                costCountMax = costCount;
                intervalCount = 1;
                intervalSum = - edge.getTime();
                bMax = true;
            } else if (costCount == costCountMax) {
                intervalCount++;
                intervalSum -= edge.getTime();
                bMax = true;
            } else if(bMax) {
                intervalSum += edge.getTime();
                bMax = false;
            }

        }
        System.out.printf("%d %d", intervalCount, intervalSum);
    }

}

class Edge implements Comparable<Edge> {
    private long time;
    private int cost;

    public Edge(long t, int c) {
        this.time = t;
        this.cost = c;
    }

    public int getCost() {
        return this.cost;
    }

    public long getTime() {
        return this.time;
    }

    @Override
    public int compareTo(Edge e) {
        if (this.time == e.time) {
            return this.cost - e.cost;
        } else {
            return (int) (this.time - e.time);
        }
    }
}

