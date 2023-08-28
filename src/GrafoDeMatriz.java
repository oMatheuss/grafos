import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.IntStream;

public class GrafoDeMatriz {

    private String[] vertex;
    private int[][] grafo;

    private GrafoDeMatriz(int[][] grafo, String[] vertex) {
        this.grafo = grafo;
        this.vertex = vertex;
    }

    public static GrafoDeMatriz criarGrafo(String path) throws IOException {
        List <String> lines = Files.readAllLines(Path.of(path), StandardCharsets.UTF_8)
                .stream()
                .filter(x -> x.length() > 0)
                .toList();

        List<String> _vertex = new ArrayList<>(lines.size());

        for (String line : lines) {
            _vertex.add(line.split(":")[0]);
        }

        _vertex.sort(String::compareToIgnoreCase);
        int size = _vertex.size();

        int[][] _grafo = new int[size][size];
        for (int[] row : _grafo)
            Arrays.fill(row, 0);

        for (String line : lines) {
            String[] arestaEVertices = line.split(":");
            String aresta = arestaEVertices[0];
            String[] vertices = arestaEVertices[1].trim().split(" ");

            int lineIndex = _vertex.indexOf(aresta);

            for (int j = 0; j < size; j++) {
                String _vertexAtual = _vertex.get(j);
                _grafo[lineIndex][j] = Arrays.asList(vertices).contains(_vertexAtual) ? 1 : 0;
            }
        }

        return new GrafoDeMatriz(_grafo, _vertex.toArray(String[]::new));
    }

    public void printFormaMatematica() {
        System.out.println("vertices: {" + String.join(", ", vertex) + "}");

        List<String> arestas = new ArrayList<>();
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                if (grafo[i][j] == 1) {
                    arestas.add("{" + vertex[i] + "," + vertex[j] + "}");
                }
            }
        }

        System.out.println("arestas: {" + String.join(", ", arestas) + "}");
    }

    public void printOrdem() {
        System.out.println("ordem: " + vertex.length);
    }

    public void printGrauVertices() {
        for (int i = 0; i < vertex.length; i++) {
            System.out.println("vertice " + vertex[i] + " grau " + Arrays.stream(grafo[i]).sum());
        }
    }

    public void printGrauPar() {
        for (int i = 0; i < vertex.length; i++) {
            System.out.println("vertice " + vertex[i] + " grau " + (Arrays.stream(grafo[i]).sum() % 2 == 0 ? "par" : "impar"));
        }
    }

    public void printSomatoriaGraus() {
        int soma = 0;
        for (int i = 0; i < vertex.length; i++) {
            soma += Arrays.stream(grafo[i]).sum();
        }
        System.out.println("soma dos graus: " + soma * 2);
    }

    public void printNumeroArestas() {
        int soma = 0;
        for (int i = 0; i < vertex.length; i++) {
            soma += Arrays.stream(grafo[i]).sum();
        }
        System.out.println("arestas: " + soma);
    }

    public void printExisteLaco() {
        List<String> lacos = new ArrayList<>();
        for (int i = 0; i < vertex.length; i++) {
            if (grafo[i][i] == 1) {
                lacos.add(vertex[i]);
            }
        }

        if (lacos.size() == 0) {
            System.out.println("não existem laços");
        } else {
            System.out.println("existem laços em: " + lacos);
        }
    }

    public void printSequenciaGraus() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < vertex.length; i++) {
            list.add(Arrays.stream(grafo[i]).sum());
        }
        Collections.sort(list);

        System.out.println("sequencia de graus: " + list);
    }

    public void printVerticesAdjacentes() {
        for (int i = 0; i < vertex.length; i++) {
            int finalI = i;
            String adjacentes = Arrays.toString(IntStream.range(0, vertex.length)
                    .filter(x -> grafo[finalI][x] == 1)
                    .mapToObj(x -> vertex[x])
                    .toArray());

            System.out.println(vertex[i] + " adjacente a " + adjacentes);
        }
    }

    public void removerVertice() {
        Scanner sc = new Scanner(System.in);
        String vertice = sc.next();
        int vertexIndex = Arrays.binarySearch(vertex, vertice);
        if (vertexIndex < 0) return;
        int[][] newGrafo = new int[vertex.length - 1][vertex.length - 1];
        for (int i = 0, k = 0; i < vertex.length; i++, k++) {
            if (i == vertexIndex) {
                k--;
                continue;
            }
            for (int j = 0, l = 0; j < vertex.length; j++, l++) {
                if (j == vertexIndex) {
                    l--;
                    continue;
                }

                newGrafo[k][l] = grafo[i][j];
            }
        }

        String[] newVertex = new String[vertex.length - 1];
        for (int i = 0, j = 0; i < vertex.length; i++, j++) {
            if (i == vertexIndex) {
                j--;
                continue;
            }
            newVertex[j] = vertex[i];
        }

        grafo = newGrafo;
        vertex = newVertex;
    }

    public void removerAresta() {
        Scanner sc = new Scanner(System.in);
        String vertice1 = sc.next();
        String vertice2 = sc.next();
        int vertex1Index = Arrays.binarySearch(vertex, vertice1);
        int vertex2Index = Arrays.binarySearch(vertex, vertice2);

        if (vertex1Index < 0 || vertex2Index < 0) return;

        grafo[vertex1Index][vertex2Index] = 0;
    }
}
