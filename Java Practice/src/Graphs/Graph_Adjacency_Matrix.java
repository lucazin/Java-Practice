package Graphs;
import java.util.ArrayList;

public class Graph_Adjacency_Matrix {

    public static class GraphNode {
        public String name;
        public int index;
        public boolean isVisited = false;
      
        public ArrayList<GraphNode> conexoes = new ArrayList<GraphNode>();
      
        public GraphNode(String name, int index) {
          this.name = name;
          this.index = index;
        }
    }

    public static class Graph {

        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        int[][] adjacencyMatrix;
      
        public Graph(ArrayList<GraphNode> nodeList) {
          this.nodeList = nodeList;
          adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
        }
      
        public void addUndirectedEdge(int i, int j) {
            adjacencyMatrix[i][j] = 1;
            adjacencyMatrix[j][i] = 1;
          }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        Graph g = new Graph(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 0);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 0);
        g.addUndirectedEdge(3, 2);
        g.addUndirectedEdge(3, 4);
        g.addUndirectedEdge(4, 3);
        g.addUndirectedEdge(4, 1);



        StringBuilder s = new StringBuilder();

        s.append("   ");
        
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + " ");
        }

        s.append("\n");

        for (int i = 0; i < nodeList.size(); i++)
        {
            s.append(nodeList.get(i).name + ": ");
            
            for (int j : g.adjacencyMatrix[i]) {
                s.append((j) + " ");
            }

            s.append("\n");
        }

        System.out.println(s);

    }
    
}
