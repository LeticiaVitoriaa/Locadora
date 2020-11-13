package locadorae;

import Classes.*;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Letícia
 */
public class Locadora {

    public static int MenuPrincipal() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Escolha uma Opção ");
        System.out.println("1. Cliente");
        System.out.println("2. Mídia");
        System.out.println("3. Empréstimo");
        System.out.println("0. Sair");
        System.out.println(" ");
        return Integer.parseInt(leitor.nextLine());
    }

    public static int SubmenuMídia() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Escolha uma Opção ");
        System.out.println("1. Cadastrar");
        System.out.println("2. Excluir");
        System.out.println("3. Consultar");
        System.out.println("4. Relatório");
        System.out.println("5. Voltar ao menu principal");
        System.out.println(" ");
        return Integer.parseInt(leitor.nextLine());
    }


    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int continuar = 1, opcMenuPrinc = 0, opcSubMidia = 0, opcaSubCliente = 0;
        Mídia mid = new Mídia();
        ArrayList<Mídia> midias = new ArrayList<Mídia>();

       
        do {
            opcMenuPrinc = MenuPrincipal();
            switch (opcMenuPrinc) {
              

                case 2:
                    do {
                        opcSubMidia = SubmenuMídia();
                        switch (opcSubMidia) {
                            case 1:
                                mid.CadastrarMidia();
                                break;

                            case 2:
                                mid.ExcluirMidia(midias);
                                break;

                            case 3:
                                mid.ConsultarMidia(midias);
                                break;

                            case 4:
                                mid.RelatoriosMidias(midias);
                                break;

                            case 5:
                                opcSubMidia = 5;
                                break;
                        }
                    } while (opcSubMidia != 5);

                    break;

                case 3:
                    break;

                case 0:
                    continuar = 0;
                    System.out.println("Saindo..");
                    break;
            }

        } while (continuar != 0);

    }

}