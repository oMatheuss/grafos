public class Vertice {

    String nome;
    Aresta arestaA;
    Aresta arestasB;
    Aresta arestasC;
    Aresta arestasD;
    Aresta arestasE;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Aresta getArestaA() {
        return arestaA;
    }

    public void setArestaA(Aresta arestaA) {
        this.arestaA = arestaA;
    }

    public Aresta getArestasB() {
        return arestasB;
    }

    public void setArestasB(Aresta arestasB) {
        this.arestasB = arestasB;
    }

    public Aresta getArestasC() {
        return arestasC;
    }

    public void setArestasC(Aresta arestasC) {
        this.arestasC = arestasC;
    }

    public Aresta getArestasD() {
        return arestasD;
    }

    public void setArestasD(Aresta arestasD) {
        this.arestasD = arestasD;
    }

    public Aresta getArestasE() {
        return arestasE;
    }

    public void setArestasE(Aresta arestasE) {
        this.arestasE = arestasE;
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "nome='" + nome + '\'' +
                ", arestaA=" + arestaA +
                ", arestasB=" + arestasB +
                ", arestasC=" + arestasC +
                ", arestasD=" + arestasD +
                ", arestasE=" + arestasE +
                '}';
    }
}
