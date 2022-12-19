package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;




public class Graph_AdjacencyList {

 
    public static class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
  
    public Graph(ArrayList<GraphNode> nodeList) {
      this.nodeList = nodeList;
    }
  
    public void addUndirectedEdge(int i, int j) {


      GraphNode Node = nodeList.get(i); // Linha
      GraphNode Edge = nodeList.get(j); // coluna
      Node.conexoes.add(Edge);
      Edge.conexoes.add(Node);
    }
}

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

   
    // List Breath First Search ( In Level )  Graph
    public static void BFSVisit(GraphNode node, Graph g)
    {
      LinkedList<GraphNode> queue = new LinkedList<>();
      queue.add(node);

      while(!queue.isEmpty())  // O(V)
      {
          GraphNode currentNode = queue.remove(0);
          currentNode.isVisited = true;

          System.out.println(currentNode.name + " ");

          for(GraphNode conexao : currentNode.conexoes) // O(E) because elements
          {
            if(conexao.isVisited == false) // O(1)
            {
              queue.add(conexao); // O(1)
              conexao.isVisited = true; // O(1)
            }
          }


          // Time Comeplexity O(V+E)



      }
    }

    //List DFS  Depth First Search 
    public static void DFS_Visit(GraphNode node, Graph g)
    {
      Stack<GraphNode> stack = new Stack<>();
      stack.push(node); //add element at top of stack pilha

      while(!stack.isEmpty()) // -O(v)  vertices
      {
        GraphNode currentNode  = stack.pop(); //return the top element da pilha  O(1)
        currentNode.isVisited = true;  

        System.out.println(currentNode.name + " "); //O(1)

        for(GraphNode conexao : currentNode.conexoes)
        {
          if(conexao.isVisited == false)
          {
            stack.push(conexao); //adiciona no topo da pilha O(adj)
            conexao.isVisited = true;
          }
        }

        // O(V) * O(E) = O ( V + E)   vertices + edges 
      }
    }

    public static void main(String[] args) throws Exception {
       
      

        // Create Nodes of graph in array list with name and index        
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        // 2 - After we create the adjecence list to union nodes with edges  ( connections )
        Graph g = new Graph(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);
    

        System.out.println("\n");
        System.out.println("bfs - Search" );
        System.out.println("\n");

        // 3 - Call BFS interating in NodeList (A B C D E) and find if the node is visited or not and show the node 
        for(GraphNode node : nodeList)
        {
          if(!node.isVisited)
            BFSVisit(node, g);
        }

        System.out.println("\n");
        System.out.println("DFS - Search" );
        System.out.println("\n");

        //4  - DFS 
        // for(GraphNode node : nodeList)
        // {
        //   if(!node.isVisited)
        //     DFS_Visit(node, g);
        // }

        
        System.out.println("\n");
        System.out.println("Adjacency List - connections Nodes" );
        System.out.println("\n");

        StringBuilder s = new StringBuilder();

        s.append("\n");
        s.append("\n");

        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + ": ");
          for (int j =0; j < nodeList.get(i).conexoes.size(); j++) {
            if (j == nodeList.get(i).conexoes.size()-1 ) {
              s.append((nodeList.get(i).conexoes.get(j).name) );
            } else {
              s.append((nodeList.get(i).conexoes.get(j).name) + " -> ");
            }
          }
          s.append("\n");
        }
        System.out.println(s);


    }
}
