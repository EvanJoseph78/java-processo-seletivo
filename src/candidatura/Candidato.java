package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class Candidato{
    String nome;
    double salarioPretendido;
    
    public Candidato(String nome) {
        this.nome = nome;
        this.salarioPretendido = ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    @Override
    public String toString() {
        return "Candidato [nome=" + nome + ", salarioPretendido=" + salarioPretendido + "]";
    }

    
    
}
