import java.io.IOException;
import java.util.*;


public class Main {

    public static void printMenuPrograma() {
        System.out.println("""
                1. Mostrar o menu;
                2. Imprimir a representação matemática do grafo;
                3. Calcular a ordem do grafo;
                4. Determinar o grau de um vértice;
                5. Verificar se o vértice tem grau par;
                6. Calcular a somatoria dos graus;
                7. Determinar o número de arestas;
                8. Verificar se algum vértice tem laço;
                9. Determinar a sequência de graus (resposta ordenada);
                10. Determinar os vértices adjacentes de um dado vértice;
                11. Classificar o grafo quanto:
                    1. é simples
                    2. é um pseudografo, isto é, possui laços
                    3. é um multigrafo, possui arestas múltiplas
                    4. é um grafo nulo - não possui arestas
                    5. é um grafo completo - cada vertice tem ligação com
                        todos os outros vértices - grau do vertice completo é
                        |V|-1
                    6. é um grafo cíclico - 2 regular
                    7. é um grafo regular - todos os vértices tem o mesmo
                        grau
                12. Remover um vértice, dado o vértice;
                13. Remover uma aresta, dado dois vértices;
                14. Sair do programa;""");
    }

    public static void programa(GrafoDeMatriz grafo) {
        Scanner sc = new Scanner(System.in);
        String op;
        printMenuPrograma();
        while (true) {
            op = sc.next();

            switch (op) {
                case "1" -> printMenuPrograma();
                case "2" -> grafo.printFormaMatematica();
                case "3" -> grafo.printOrdem();
                case "4" -> grafo.printGrauVertices();
                case "5" -> grafo.printGrauPar();
                case "6" -> grafo.printSomatoriaGraus();
                case "7" -> grafo.printNumeroArestas();
                case "8" -> grafo.printExisteLaco();
                case "9" -> grafo.printSequenciaGraus();
                case "10" -> grafo.printVerticesAdjacentes();
                case "14" -> {
                    System.out.println("(╯°□°)╯︵ ┻━┻");
                    return;
                }
                default -> {}
            }
        }
    }

    public static void printMenuPrograma2() {
        System.out.println("""
                1. Mostrar o menu;
                2. Imprimir a representação matemática do grafo;
                3. Calcular a ordem do grafo;
                4. Determinar o grau de um vértice;
                5. Verificar se o vértice tem grau par;
                6. Verificar se algum vértice tem laço;
                7. Sair""");
    }

    public static void programa2(Grafo grafo) {
        Scanner sc = new Scanner(System.in);
        String op;
        printMenuPrograma2();
        while (true) {
            op = sc.next();

            switch (op) {
                case "1" -> printMenuPrograma2();
                case "2" -> grafo.printRepresentacaoMatematica();
                case "3" -> grafo.printOrdem();
                case "4" -> grafo.printGrauVertices();
                case "5" -> grafo.printGrauPar();
                case "6" -> grafo.printExisteLaco();
                case "7" -> {
                    System.out.println("(╯°□°)╯︵ ┻━┻");
                    return;
                }
                default -> {}
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "resources/grafo.txt";

        System.out.println("""
                Grafos
                1. Usando matriz;
                2. Usando lista;""");

        Scanner sc = new Scanner(System.in);
        String op = sc.next();

        if ("1".equals(op)) {
            GrafoDeMatriz grafo = GrafoDeMatriz.criarGrafo(path);
            programa(grafo);
        } else if ("2".equals(op)) {
            Grafo grafo = new Grafo(path);
            programa2(grafo);
        }
    }
}