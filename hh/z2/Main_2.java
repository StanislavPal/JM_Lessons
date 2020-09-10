package hh.z2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {

        System.out.println("Введите данные:");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Edge[] edges = new Edge[count * 2];

        int j = 0;
        for (int i = 0; i < count; i++) {
            int time = Integer.parseInt( in.next() );
            edges[j] = new Edge(time - 1, 1);
            j++;
            time = Integer.parseInt( in.next() );
            edges[j] = new Edge(time, -1);
            j++;
        }

        Arrays.sort(edges);

        boolean bMax = false;
        int costCount = 0;
        int costCountMax = 0;
        int intervalSum = 0;
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
    private int time;
    private int cost;

    public Edge(int t, int c) {
        this.time = t;
        this.cost = c;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCost() {
        return this.cost;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public int compareTo(Edge e) {
        return this.time - e.time;
    }
}

