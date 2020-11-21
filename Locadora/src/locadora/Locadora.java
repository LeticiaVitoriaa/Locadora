package locadora;

import Classes.*;
import java.util.*;
import java.util.ArrayList;

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
        System.out.println("MÍDIA");
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Cadastrar");
        System.out.println("2. Excluir");
        System.out.println("3. Consultar");
        System.out.println("4. Relatório");
        System.out.println("5. Voltar ao menu principal");
        System.out.println(" ");
        return Integer.parseInt(leitor.nextLine());
    }

    public static int SubmenuCliente() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("CLIENTE");
        System.out.println("O cliente é: "
                + "1. Pessoa física"
                + "2. Pessoa jurídica"
                + "3. Voltar ao menu principal");
        return Integer.parseInt(leitor.nextLine());
    }

    public static int SubmenuPessoaFisica() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("CLIENTE - PESSOA FÍSICA");
        return Integer.parseInt(leitor.nextLine());
    }

    public static int SubmenuPessoaJuridica() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("CLIENTE - PESSOA JURÍDICA");
        return Integer.parseInt(leitor.nextLine());
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int continuar = 1, opcMenuPrinc = 0, opcSubMidia = 0, opcSubCliente = 0;
        Mídia mid = new Mídia();
        ArrayList<Mídia> midias = new ArrayList<Mídia>();
        ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();

        do {
            opcMenuPrinc = MenuPrincipal();
            switch (opcMenuPrinc) {
                case 1:
                    opcSubCliente = SubmenuCliente();
                    do {
                        switch (opcSubCliente) {
                            case 1:
                                SubmenuPessoaFisica();
                                break;
                            case 2:
                                SubmenuPessoaJuridica();
                                break;
                            case 3:
                                System.out.println("Voltando ao menu principal");
                                break;
                            default:
                                System.out.println("Pessoa selecionada não existe, tente novamente");
                                break;
                        }
                    } while (opcSubCliente != 3);
                    break;
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
                                System.out.println("Voltando ao menu principal");
                                break;
                            default:
                                System.out.println("Opção selecionada não existe, tente novamente");
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
