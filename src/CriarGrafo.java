import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CriarGrafo {
    public static Map<String, List<String>> criarGrafo(String path, Map<String, List<String>> grafo) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                if(!linha.equals("")){
                    String[] separarArestasEVertices = linha.split(":");
                    String arestasArr = separarArestasEVertices[1];
                    String[] arestasSplit = arestasArr.trim().split(" ");
                    List<String> arestas = new ArrayList<>();
                    for(String arr: arestasSplit){
                          arestas.add(arr);
                    }
                    grafo.put(separarArestasEVertices[0],arestas);

                }
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();

        System.out.println("Representação Matematica");

        for(String key: grafo.keySet()){
            System.out.println(key + ":" + grafo.get(key));
        }

        System.out.println("Ordem do Grafo");

        System.out.println("ordem: " + grafo.size());

        System.out.println("Grau dos vertices");

        for(String key: grafo.keySet()){
            System.out.println(key + ":" + grafo.get(key).size() + " grau");
        }
        System.out.println("5 - verificar se o vértice tem grau par ");

        for(String key: grafo.keySet()){
            if((grafo.get(key).size() % 2) == 0) {
                System.out.println(key + ":" + grafo.get(key).size() + " grau par");
            }else{
                System.out.println(key + ":" + grafo.get(key).size() + " grau impar");
            }
        }
        System.out.println("6 - calcular a somatoria dos graus");
        int somaGrau = 0;
        for(String key: grafo.keySet()){
            somaGrau += grafo.get(key).size();
        }
        System.out.println("somatorio dos graus:" + somaGrau);

        System.out.println("7.determinar o número de arestas");
        for(String key: grafo.keySet()){
            System.out.println(grafo.get(key) + " numero de arestas:");
        }

        System.out.println("8.verificar se algum vértice tem laço");
        for(String key: grafo.keySet()){
            for (String values: grafo.get(key)){
                if(key.equals(values)){
                    System.out.println(key + ":" + grafo.get(key) + "tem laço");
                }else {
                    System.out.println("não tem laço");
                }
            }
        }

        System.out.println("9.determinar a sequência de graus (resposta ordenada)");

        List<Integer> listaParaOrdenar = new ArrayList<>();
        for(String key: grafo.keySet()){
            //System.out.println(key);
            listaParaOrdenar.add(grafo.get(key).size());
        }
        Collections.sort(listaParaOrdenar, Collections.reverseOrder());
        System.out.println(listaParaOrdenar);

        System.out.println("10.determinar os vértices adjacentes de um dado vértice");

//        Scanner sc = new Scanner(System.in);
//        System.out.println("informe o vertice para a busca");
//        String vertice = sc.next();
//
//        for(String key: grafo.keySet()){
//            if(key.equals(vertice)){
//                System.out.println(grafo.get(key));
//            }
//        }
        //TODO fazer a 11

        System.out.println("12.remover um vértice, dado o vértice");

        Scanner scc = new Scanner(System.in);
        System.out.println("informe o vertice para remover");
        String verticee = scc.next();

        for(String key: grafo.keySet()){
            if(key.equals(verticee)){
                grafo.remove(key);
            }
        }
        //imprime o grafo sem o vertice;
        for(String key: grafo.keySet()){
            if(key.equals(verticee)){
                System.out.println(key + ":" + grafo.get(key));
            }
        }
        System.out.println("13.remover uma aresta, dado dois vértices");

        Scanner sccc = new Scanner(System.in);
        System.out.println("informe o vertice para remover");
        String arestas = sccc.next();

        //TODO logica para remover

        System.out.println("14.Sair do programa");

        return grafo;
    }
}
