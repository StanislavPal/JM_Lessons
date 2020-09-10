//package hh.z2;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        ArrayList<Edge> edges = new ArrayList<Edge>();
//
//        System.out.println("Введите данные:");
//        Scanner in = new Scanner(System.in);
//        int count = in.nextInt();
//
//        for (int i = 0; i < count; i++) {
//            int time = Integer.parseInt( in.next() );
//            edges.add( new Edge(time, 1));
//            time = Integer.parseInt( in.next() );
//            edges.add( new Edge(time, -1));
//        }
//
//        Collections.sort(edges);
//
//        boolean bMax = false;
//        int costCount = 0;
//        int costCountMax = 0;
//        int intervalSum = 0;
//        int intervalCount = 0;
//
//        for (Edge edge : edges ) {
//
//            costCount += edge.getCost();
//            if (costCount > costCountMax) {
//                costCountMax = costCount;
//                intervalCount = 1;
//                intervalSum = 1 - edge.getTime();
//                bMax = true;
//            } else if (costCount == costCountMax) {
//                intervalCount++;
//                intervalSum += 1 - edge.getTime();
//                bMax = true;
//            } else if(bMax) {
//                intervalSum += edge.getTime();
//                bMax = false;
//            }
//
//        }
//        System.out.printf("%d %d", intervalCount, intervalSum);
//    }
//}
