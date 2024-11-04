import model.Cena;
import model.Escolha;
import model.Item;
import repository.CenaDAO;
import repository.EscolhaDAO;
import repository.ItemDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cenaAtualId = 1; // Começa na primeira cena
        boolean jogoAtivo = true;


        System.out.println("Leon S. Kennedy é enviado para resgatar a filha do presidente dos Estados Unidos, Ashley\n" +
                "Graham, que foi sequestrada por um culto religioso em uma parte rural da Espanha. Ao chegar,\n" +
                "Leon se depara com horrores inimagináveis, enfrentando aldeões violentos e criaturas\n" +
                "mutantes controladas por um parasita mortal.\n" +
                "Leon deve usar toda sua habilidade e inteligência para infiltrar a Igreja onde Ashley está presa.\n" +
                "Cada decisão pode ser a diferença entre o sucesso e o fracasso, com escolhas que levarão ao\n" +
                "resgate ou à repetição de seus erros. Apenas um caminho é o certo (— qualquer deslize e Leon\n" +
                "será forçado a recomeçar sua missão mortal.)\n");

        while (jogoAtivo) {
            try {
                Cena cena = CenaDAO.findCenaById(cenaAtualId);
                System.out.println(cena.getDescricao());

                List<Escolha> escolhas = cena.getOpcoes();
                System.out.println("Escolha sabiamente entre as opções!: \n");

                for (Escolha escolha : escolhas) {
                    System.out.println(escolha.getId_escolha() + ": " + escolha.getDescricao());
                }

                System.out.print("Digite a escolha desejada: \n");
                int escolhaUsuario = scanner.nextInt();
                scanner.nextLine();

                Escolha escolhaSelecionada = null;
                for (Escolha escolha : escolhas) {
                    if (escolha.getId_escolha() == escolhaUsuario) {
                        escolhaSelecionada = escolha;
                        break;
                    }

                }
                if (escolhaSelecionada != null) {
                    System.out.println("Você escolheu: " + escolhaSelecionada.getDescricao());
                    EscolhaDAO.inserirEscolha(escolhaSelecionada.getDescricao(), escolhaSelecionada.getResultado(), cenaAtualId);
                    //condição de avança ou volta o loop da cena
                    if (escolhaSelecionada.getResultado().equals("sucesso")) {
                        cenaAtualId++; // incrementa o id da cena qyue se identifica por altoincrementar
                    } else {
                        System.out.println("Opção incorreta! Reiniciando a fase!! " + cena.getDescricao()); //poderia adicionar uma condição para cada escolha mas não consegui implementar
                    }
                } else { //se for algum id invalido no bd
                    System.out.println("Escolha inválida. Tente novamente.");
                }
                if (cenaAtualId > 5) { //cena id 5 é a ultima, então o while precisa do false pra fechar
                    System.out.println("Um helicóptero de resgate chega, permitindo que Leon e Ashley escapem da vila e\n" +
                            "completem a missão com sucesso. \"Missão cumprida. Ashley está a salvo, mas o pesadelo.... ainda não acabou.\"");
                    jogoAtivo = false;
                }

            } catch (SQLException e) {
                System.out.println("Erro ao acessar o banco de dados: " + e.getMessage());
                jogoAtivo = false;
            }
        }

        scanner.close();
    }
}
