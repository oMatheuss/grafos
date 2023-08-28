import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grafo {

    private final Map<String, List<String>> grafo;

    public Grafo(String path) throws IOException {
        grafo = criarGrafo(path);
    }

    public void printRepresentacaoMatematica() {
        System.out.println("Representação Matemática");
        System.out.println("vertices: {" + String.join(", ", grafo.keySet()) + "}");

        List<String> arestas = new ArrayList<>();
        for(String key: grafo.keySet()){
            for (String value: grafo.get(key)) {
                arestas.add("{" + key + ", " + value + "}");
            }
        }

        System.out.println("arestas: {" + String.join(", ", arestas) + "}");
    }

    public void printOrdem() {
        System.out.println("Ordem do grafo: " + grafo.size());
    }

    public void printGrauVertices() {
        for(String key: grafo.keySet()){
            System.out.println(key + ": " + grafo.get(key).size() + " grau");
        }
    }

    public void printGrauPar() {
        for(String key: grafo.keySet()){
            if((grafo.get(key).size() % 2) == 0) {
                System.out.println(key + " tem grau par");
            }else{
                System.out.println(key + " tem grau impar");
            }
        }
    }

    public void printExisteLaco() {
        for (String key: grafo.keySet()) {
            for (String value: grafo.get(key)) {
                if (key.equals(value)) {
                    System.out.println(key + " tem laço");
                }
            }
        }
    }

    public static Map<String, List<String>> criarGrafo(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));

        Map<String, List<String>> _grafo = new HashMap<>();

        String linha = "";
        while (linha != null) {
            if (linha.length() > 0) {
                String[] separarArestasEVertices = linha.split(":");
                String arestasArr = separarArestasEVertices[1];

                String[] arestasSplit = arestasArr.trim().split(" ");
                List<String> arestas = new ArrayList<>();
                Collections.addAll(arestas, arestasSplit);

                _grafo.put(separarArestasEVertices[0], arestas);
            }
            linha = buffRead.readLine();
        }
        buffRead.close();

        return _grafo;
    }
}
