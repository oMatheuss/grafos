import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, List<String>> grafo = new HashMap<>();
        String path = "/home/joulucas/projects/grafos/resources/grafo.txt";
        LeitorDeArquivo.leitor(path);
        CriarGrafo.criarGrafo(path,grafo);

    }

}