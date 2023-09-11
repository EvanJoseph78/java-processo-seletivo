package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ProcessoSeletivo
 */
public class ProcessoSeletivo {

    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        // analisarCandidato(2001);
        String[] candidatos = { "Evandro",
                "José",
                "Evan",
                "Joseph",
                "Ednaldo",
                "Pereira",
                "Fernanda",
                "Antônio", 
                "Caneta azul" };
        List<Candidato> candidatosEscolhidos = selecaoCandidatos(candidatos);
        // System.out.println(candidatosEscolhidos);
        for (Candidato candidato : candidatosEscolhidos) {
            // System.out.println("Candidato " + candidato.nome + " escolhido");
            // System.out.printf("Pretensão salarial de: R$%.2f%n",
            // candidato.salarioPretendido);
            System.out.println("------------------------");
            entrandoEmContato(candidato.nome);
            System.out.println("------------------------");

        }
    }

    static void entrandoEmContato(String nomeCandidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!!!");
            }

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos entrar em contato com: " + nomeCandidato);
            System.out.println("Ligações realizadas:" + tentativasRealizadas);
        } else {
            System.out.println("Não conseguimos entrar em contato com: " + nomeCandidato);
        }

    }

    static List<Candidato> selecaoCandidatos(String[] candidatos) {

        List<Candidato> listaCandidatos = getCandidato(candidatos);

        int candidatosSelecionados = 0;
        double salarioBase = 2000;
        List<Candidato> candidatosEscolhidos = new ArrayList<>();

        for (Candidato candidato : listaCandidatos) {
            // System.out.println(candidato.nome + " " + candidato.salarioPretendido);
            if (candidato.salarioPretendido <= salarioBase) {

                candidatosSelecionados += 1;

                candidatosEscolhidos.add(candidato);

                if (candidatosSelecionados == 5) {
                    return candidatosEscolhidos;
                }
            }
        }

        return candidatosEscolhidos;

    }

    static List<Candidato> getCandidato(String[] nomeCandidatos) {
        List<Candidato> listaCandidados = new ArrayList<>();
        for (String candidato : nomeCandidatos) {
            listaCandidados.add(new Candidato(candidato));
        }
        return listaCandidados;
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para candidato");
        } else if (salarioPretendido == salarioBase) {
            System.out.println("Aguardando resultado dos outros candidatos");
        } else {
            System.out.println("Aguardando resultado dos outros candidatos");
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }
}