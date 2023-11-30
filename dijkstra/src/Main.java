import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static class AdjListNode {
        int vertex, weight;

        AdjListNode(int v, int w) {
            vertex = v;
            weight = w;
        }
        public int getVertex() {return vertex ;}
        public int getWeight() {return weight ;}

        public static int[] dijkstra(int V, ArrayList<ArrayList<AdjListNode>> graph, int src) {
            int[] distance = new int[V];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[src] = 0;

            PriorityQueue<AdjListNode> pq = new PriorityQueue<>(Comparator.comparingInt(AdjListNode::getWeight));
            pq.add(new AdjListNode(src, 0));

            while (!pq.isEmpty()) {
                AdjListNode current = pq.poll();

                for(AdjListNode n : graph.get(current.getVertex())) {
                    if (distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]) {
                        distance[n.getVertex()] = n.getWeight() + distance[current.getVertex()];
                        pq.add(new AdjListNode(n.getVertex(), distance[n.getVertex()]));
                    }

                }
            }
            //distance[target]
            return distance;
        }
    }


    public static void main(String[] args) {
        String[] cities1 = {"Campeche", "Villa Hermosa", "Veracruz", "Xalapa", "Altamira", "Ciudad Victoria"};
        String[] cities2 = {"Tuxtla", "Villa Hermosa", "Veracruz", "Xalapa", "Altamira", "Ciudad Victoria"};
        String[] cities3 = {"Chilpancingo", "Toluca", "Queretaro", "San Luis Potosi","Ciudad Victoria"};
        String[] cities4 = {"Oaxaca", "Veracruz", "Xalapa", "Altamira","Ciudad Victoria"};
        String[] cities5 = {"Chetumal", "Campeche", "Villa Hermosa", "Veracruz","Xalapa", "Altamira", "Ciudad Victoria"};
        String[] cities6 = {"Villa Hermosa", "Veracruz", "Xalapa", "Altamira", "Ciudad Victoria"};
        String[] cities7 = {"Merida", "Campeche", "Villa Hermosa", "Veracruz","Xalapa", "Altamira", "Ciudad Victoria"};
        String[] cities8 = {"CDMX", "Queretaro", "San Luis Potosi", "Ciudad Victoria"};
        String[] cities9 = {"Aguascalientes", "Zacatecas", "San Luis Potosi", "Ciudad Victoria"};
        String[] cities10 = {"La paz", "Mexicali"};
        int V = cities10.length;
        ArrayList<ArrayList<AdjListNode>> graphTime = new ArrayList<>();
        ArrayList<ArrayList<AdjListNode>> graphDistance = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graphTime.add(new ArrayList<>());
            graphDistance.add(new ArrayList<>());
        }
        int source = 0;

        //time is set to minutes
        graphTime.get(0).add(new AdjListNode(1, 980));

        int[] time = AdjListNode.dijkstra(V, graphTime, source);

        System.out.println("Vertex "
                + " Time (in minutes) from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(cities10[i] + "\t"
                    + time[i] + "mins");
        }

        graphDistance.get(0).add(new AdjListNode(1, 1351));

        int[] distance = AdjListNode.dijkstra(V, graphDistance, source);

        System.out.println("\n\nVertex "
                + " Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(cities10[i] + "\t"
                    + distance[i] + "km");
        }

    }
}
