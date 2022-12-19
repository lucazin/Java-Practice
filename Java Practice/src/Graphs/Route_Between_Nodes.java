package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import Graphs.Route_Between_Nodes.Graph.State;

public class Route_Between_Nodes {


     public static class Graph {

        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
      
        public Graph(ArrayList<GraphNode> nodeList) {
          this.nodeList = nodeList;
        }
      
        public void addDirectEdges(int i, int j) {
    
    
          GraphNode Node = nodeList.get(i); // Linha
          GraphNode Edge = nodeList.get(j); // coluna
          Node.conexoes.add(Edge);
          //Edge.conexoes.add(Node);  é um direct edge nao tem volta.
        }

        public static enum State {
            Unvisited,Visited,Visiting;
        }
    }
    
     public static class GraphNode {
            public String name;
            public int index;
            public boolean isVisited = false;
            public GraphNode parent;
            public Graph.State state;
          
            public ArrayList<GraphNode> conexoes = new ArrayList<GraphNode>();
          
            public GraphNode(String name, int index) {
              this.name = name;
              this.index = index;
            }
        }
    
       
          // List Breath First Search ( In Level )  Graph
      public static boolean Check_Route_BetweenNodes(GraphNode nodeStart, GraphNode nodeEnd, Graph g)
          {
            LinkedList<GraphNode> queue = new LinkedList<>(); //Create queue

            for(GraphNode node : g.nodeList) 
                node.state = State.Unvisited; //Set all nodes not visited
            

            nodeStart.state = State.Visiting;
            queue.add(nodeStart); //insert startrnode to queue
            GraphNode currentNode;

            while(!queue.isEmpty())  // O(V)   // while queu is not empty  get the queue init value
            {
                currentNode = queue.remove(0); // get init value
      
                for(GraphNode conexao : currentNode.conexoes) // O(E) 
                {
                  if(conexao.state == State.Unvisited) // O(1)
                  {
                    if(conexao == nodeEnd)   //check elements is iterating is equal do the end node searching if find return true;
                        return true;
                    else
                    {
                        conexao.state = State.Visiting; // if not find add the node in queue and get the conections of their node 
                        queue.add(conexao);
                    }
                  }
                
                  currentNode.state = State.Visited;

                }
            }
            return false;
                // Time Comeplexity O(V+E)
            }
    
    
        public static void main(String[] args) throws Exception {
       
            // Create Nodes of graph in array list with name and index        
            ArrayList<GraphNode> nodeList = new ArrayList<>();
            nodeList.add(new GraphNode("A", 0));
            nodeList.add(new GraphNode("B", 1));
            nodeList.add(new GraphNode("C",2));
            nodeList.add(new GraphNode("D", 3));
            nodeList.add(new GraphNode("E", 4));
            nodeList.add(new GraphNode("F", 5));
            nodeList.add(new GraphNode("G", 6));
            nodeList.add(new GraphNode("H",7));
            nodeList.add(new GraphNode("I", 8));
            nodeList.add(new GraphNode("J", 9));
    
            // 2 - After we create the adjecence list to union nodes with edges  ( connections )
            Graph g = new Graph(nodeList);
            g.addDirectEdges(0, 1); // A -> B
            g.addDirectEdges(0, 2); // A -> C
            g.addDirectEdges(0, 3); // A -> D
            g.addDirectEdges(1, 9); // B -> J
            g.addDirectEdges(2, 6); // C -> G
            g.addDirectEdges(4, 0); // E -> A
            g.addDirectEdges(4, 5); // E -> F
            g.addDirectEdges(5, 8); // F -> I
            g.addDirectEdges(6, 7); // G -> H
            g.addDirectEdges(6, 3); // G -> D
    
            System.out.println("\n");
            System.out.println("Check if exist route in graph between Node Start and Node End" );
            
            if(Check_Route_BetweenNodes(nodeList.get(0),nodeList.get(6),g)) //A -> G
                 System.out.println(true);
            else  
            System.out.println(false);

    
        }

    
}
