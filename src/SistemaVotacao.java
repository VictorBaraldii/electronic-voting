import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaVotacao {
    private Map<String, Integer> candidatos;
    private int totalVotos;

    public SistemaVotacao() {
        candidatos = new HashMap<>();
        totalVotos = 0;
    }

    public void adicionarCandidato(String nome) {
        candidatos.put(nome, 0);
    }

    public void votar(String nomeCandidato) {
        if (candidatos.containsKey(nomeCandidato)) {
            candidatos.put(nomeCandidato, candidatos.get(nomeCandidato) + 1);
            totalVotos++;
            System.out.println("Voto registrado para " + nomeCandidato);
        } else {
            System.out.println("Candidato não encontrado.");
        }
    }

    public void exibirResultados() {
        System.out.println("Resultados da votação: ");
        for (Map.Entry<String, Integer> entry : candidatos.entrySet()) {
            String candidato = entry.getKey();
            int votos = entry.getValue();
            double percentual = (totalVotos > 0) ? (votos * 100.0 / totalVotos) : 0;
            System.out.printf("%s: %d votos (%.2f%%)\n", candidato, votos, percentual);
        }
    }

    public static void main(String[] args) {
        SistemaVotacao sistema =  new SistemaVotacao();
        Scanner scanner = new Scanner(System.in);

        sistema.adicionarCandidato("Candidato A");
        sistema.adicionarCandidato("Candidato B");
        sistema.adicionarCandidato("Candidato C");

        String comando;
        do {
            System.out.println("\nDigite 'votar' para votar, 'resultados' para ver os Resultados ou 'Sair' para encerrar:");
            comando = scanner.nextLine();

            if (comando.equals("votar")) {
                System.out.print("Digite o nome do candidato: ");
                String nomeCandidato = scanner.nextLine();
                sistema.votar(nomeCandidato);
            } else if (comando.equals("resultados")) {
                sistema.exibirResultados();
            }
        } while (!comando.equals("sair"));

        scanner.close();
        System.out.println("Sistema de votação encerrado.");
    }
}