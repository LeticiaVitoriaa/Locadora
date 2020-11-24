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
    
    public static int SubmenuEmprestimo() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("EMPRÉSTIMO");
        System.out.println("Escolha uma das opções:"
                + "\n1. Cadastro"
                + "\n2. Devolução"
                + "\n3. Relatório"
                + "\n4. Voltar ao Menu Principal");
        return Integer.parseInt(leitor.nextLine());
    }
    
    public static void inicializaObjetos(ArrayList<Cliente> arrayCliente, ArrayList<Mídia> arrayMidia) {
       PessoaFisica cla = new PessoaFisica("111.111.111-11", "MG-nseioq", "01", "Clara", "nseioqehisso", "seila", "Raposos", "Minas Gerais", "91111-1111", "11.111-111", 1); 
       arrayCliente.add(cla);
       PessoaFisica isa = new PessoaFisica("157.513.476-14", "MG-nseioq", "02", "Isadora", "nseioqehisso", "Graça", "Belo Horizonte", "Minas Gerais", "97514-8366", "31.140-020", 2); 
       arrayCliente.add(isa);
       PessoaFisica let = new PessoaFisica("333.333.333-33", "MG-nseioq", "03", "Letícia", "nseioqehisso", "seila", "Ibirité", "Minas Gerais", "93333-3333", "33.333-333", 3); 
       arrayCliente.add(let);
       PessoaFisica mar = new PessoaFisica("444.444.444-44", "MG-nseioq", "04", "Maria Fernanda", "nseioqehisso", "seila", "Raposos", "Minas Gerais", "94444-4444", "44.444-444", 4); 
       arrayCliente.add(mar);
       
       Mídia tita = new Mídia( 1, "Titanic", "Um barco afunda após bater em um iceberg.", "Romance", "Sim", 5.00);
       arrayMidia.add(tita);
       Mídia aveng = new Mídia( 2, "VingadoresUltimato", "Depois do Thanos acabar com metade das criaturas vivas, os Vingadores tentam reverter o ocorrido.", "Ficção Científica", "Sim", 60.00);
       arrayMidia.add(aveng);
       Mídia your = new Mídia( 3, "YourName", "Duas pessoas são coenctadas através das imagens de seus sonhos", "Romance", "Não", 30.00);
       arrayMidia.add(your);
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int continuar = 1, opcMenuPrinc = 0, opcSubMidia = 0, opcSubCliente = 0, opcSubEmprestimo = 0;
        
        Mídia mid = new Mídia();
        Emprestimo emprestimo = new Emprestimo();
        
        ArrayList<Mídia> arrayMidia = new ArrayList<Mídia>();
        ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
        ArrayList<Emprestimo> arrayEmprestimo = new ArrayList<Emprestimo>();

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
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Pessoa selecionada não existe, tente novamente.");
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
                                mid.ExcluirMidia(arrayMidia);
                                break;

                            case 3:
                                mid.ConsultarMidia(arrayMidia);
                                break;

                            case 4:
                                mid.RelatoriosMidias(arrayMidia);
                                break;

                            case 5:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção selecionada não existe, tente novamente.");
                                break;
                        }
                    } while (opcSubMidia != 5);

                    break;

                case 3:
                    do {
                        opcSubEmprestimo = SubmenuEmprestimo();
                        switch (opcSubEmprestimo) {
                            case 1:
                                arrayEmprestimo.add(emprestimo.cadastrarEmprestimo(arrayCliente, arrayMidia));
                                break;

                            case 2:
                                emprestimo.devolucaoEmprestimo(arrayEmprestimo);
                                break;

                            case 3:
                                emprestimo.relatorioEmprestimoCliente(arrayEmprestimo);
                                break;

                            case 4:
                                System.out.println("Voltando ao menu principal...");
                                break;
                                
                            default:
                                System.out.println("Opção selecionada não existe, tente novamente.");
                                break;
                        }
                    } while (opcSubEmprestimo != 4);
                    break;

                case 0:
                    continuar = 0;
                    System.out.println("Saindo..");
                    break;
            }

        } while (continuar != 0);

    }

}
