import model.Cena;
import model.Escolha;
import model.Item;
import model.Save;
import repository.CenaDAO;
import repository.EscolhaDAO;
import repository.ItemDAO;
import repository.SaveDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cenaAtualId = 1; // começa na primeira cena 1
        boolean jogoAtivo = true;



        try {
            Cena cenaInicial = CenaDAO.findCenaById(6);
            System.out.println(cenaInicial.getDescricao());
        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco de dados: " + e.getMessage());
            return;
        }

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
                String escolhaUsuario = scanner.next();
                scanner.nextLine();

                Escolha escolhaSelecionada = null;
                for (Escolha escolha : escolhas) {
                    if (escolha.getUse_descricao().equals(escolhaUsuario)) {
                        escolhaSelecionada = escolha;
                        break;
                    }



                }
                if (escolhaSelecionada != null) {
                    System.out.println("Você escolheu: " + escolhaSelecionada.getDescricao());
                    EscolhaDAO.inserirEscolha(escolhaSelecionada.getDescricao(), escolhaSelecionada.getResultado(), cenaAtualId, escolhaSelecionada.getUse_descricao());
                    //condição de avança ou volta o loop da cena
                    if ((escolhaSelecionada.getResultado().equals("help"))){
                        System.out.println("comandos de ajuda!" +
                                "break - acaba o jogo " +
                                "digite o comando desejado referente a cada opção");

                    }
                    if (escolhaSelecionada.getResultado().equals("break")){
                        jogoAtivo = false;
                    }
                    if (escolhaSelecionada.getResultado().equals("sucesso")) {
                        cenaAtualId++; // incrementa o id da cena qyue se identifica por altoincrementar
                    }
                    else {
                        System.out.println("Escolha novamente! "); //poderia adicionar uma condição para cada escolha mas não consegui implementar
                    }
                } else { //se for algum id invalido no bd
                    System.out.println("Escolha inválida. Tente novamente.");
                }
                if (cenaAtualId > 5) { //cena id 5 é a ultima, então o while precisa do false pra fechar
                    try {
                        Cena cenaFinal = CenaDAO.findCenaById(7);
                        System.out.println(cenaFinal.getDescricao());

                    }catch (SQLException e){
                        System.out.println("Erro ao acessar o banco de dados para a cena final: " + e.getMessage());
                    }
                    jogoAtivo = false;
                }
                System.out.println("Save atual: ");
                Save save = SaveDAO.novoJogo(cenaAtualId); // passa o id da cena atual
                System.out.println(save.getIdSave());

            } catch (SQLException e) {
                System.out.println("Erro ao acessar o banco de dados: " + e.getMessage());
                jogoAtivo = false;
            }
        }

        scanner.close();
    }
}
