package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph_Adjacency_Matrix {


  public static class Graph {

    // crio uma lista com os nodes do tipo node dos grafos exemplo ( A B C D E F G)
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix; // uma matriz para representar as ligacoes ou o edges
  
    //inicialzo o objeto graph
    public Graph(ArrayList<GraphNode> nodeList) {
      this.nodeList = nodeList;
      adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }
  
    //Grafo birirecional tanto i j como j i podem ter conexoes em ambas direcoes - I e J sao direcoes / index
    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
      }
}
  
//crio o o objeto node que vai ser um item dentro do grafo com nome, index do node e se foi visitado ou nao e uma lista com as suas conexoes.
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

   


// retorna as conexoes de um no especifico passado como parametro do grafo tambem tambem passado como parametro
    public static ArrayList<GraphNode> ReturnConexoes(GraphNode node, Graph g)
    {
      ArrayList<GraphNode> conexoes = new ArrayList<>();
      int nodeindex = node.index;   // recebo o index do node aqui e verifico se tem conexoes

      for(int i =0;i<g.adjacencyMatrix.length;i++)   // verifico se tem ligacao na matriz de ligacao - adjacency list 
      {
         //Se estiver 1 na coluna tem uma conexao  nodeindex e i 
         //se tem 1 e eu adiciono o node na lista  de conexoes e retorno as conexoes.
         if(g.adjacencyMatrix[nodeindex][i] == 1)
         {
            conexoes.add(g.nodeList.get(i));
         }
      }
        return conexoes;
    }


    // Metodo de procura BSF inLevel
    public static void BFS_Search(GraphNode node,Graph g)
    {

      //crio uma lista linkada e adiciono o node do loop no lista
      LinkedList<GraphNode> q = new LinkedList<>();
      q.add(node);

      //se a lista nao for nula como se fosse uma fila 
      while(!q.isEmpty())
      {
        //eu atribuo o primeiro node ao node current e e marco como visited, pra nao passar por ele de novo
        GraphNode currentnode = q.remove(0);
        currentnode.isVisited = true;
        
        System.out.print(currentnode.name + " ");
        
        //retorno todas conexoes daquele node 
        ArrayList<GraphNode> conexoes = ReturnConexoes(currentnode, g);

        //faco um loop nas conexoes verificando se ja foi passado por ele com o visible e senao for eu adiciono na fila pra listar e marco como visitado.
        for(GraphNode conexao: conexoes)
        {
          if(conexao.isVisited == false)
            q.add(conexao);
            conexao.isVisited = true;
        }
      }
    }


    public static void DFS_Visit(GraphNode node, Graph g)
    {
      Stack<GraphNode> stack = new Stack<>();
      stack.push(node);

      while(!stack.isEmpty())
      {
        GraphNode currentNode  = stack.pop(); //return the top element da pilha
        currentNode.isVisited = true;

        System.out.println(currentNode.name + " ");


          //retorno todas conexoes daquele node 
          ArrayList<GraphNode> conexoes = ReturnConexoes(currentNode, g);

        for(GraphNode conexao : conexoes)
        {
          if(conexao.isVisited == false)
          {
            stack.push(conexao); //adiciona no topo da pilha
            conexao.isVisited = true;
          }
        }

      }
    }




    public static void main(String[] args) throws Exception {
       
        // region 1  - Crio os nodes do grafo atribuindo um nome e o indice no objeto GraphNode

        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        //endregion


        // region 2 - faco a ligacao de quem tem conexao com quem pelos indices e atribui 1 na matriz 
        Graph g = new Graph(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);

        //endregion


          // region 3 - Faco um loop node (vertice) a node e vejo se foi visitado, senao eu chamo BFS - Breath First Search


          for(GraphNode node : nodeList)
          {
            if(node.isVisited == false)
              BFS_Search(node, g);
          }
  
          //endregion

        
          // region 4 - Faco um loop node (vertice) a node e vejo se foi visitado, senao eu chamo DFS - Depth First Search
          for(GraphNode node : nodeList)
          {
            if(node.isVisited == false)
              DFS_Visit(node, g);
          }

        //endregion
        
         
        
        //region Mostro a Matriz de adjacencia aonde os nodes se conversa

        StringBuilder s = new StringBuilder();

        s.append("   ");
        
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + " ");
        }

        s.append("\n");


        for (int i = 0; i < nodeList.size(); i++)
        {
            s.append(nodeList.get(i).name + ": ");
            
            for (int j : g.adjacencyMatrix[i]) 
            {
                s.append((j) + " ");
            }
            s.append("\n");
        }

        System.out.println(s);

        //endregion 
       

      

    }
    
}
