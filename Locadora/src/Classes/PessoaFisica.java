package Classes;

import java.util.*;

public class PessoaFisica extends Cliente {

    Scanner in = new Scanner(System.in);

    private String cpf;
    private String identidade;
    
    //inicializar
    public PessoaFisica(String cpf, String identidade, String codigo, String nome, String logradouro, String bairro, String municipio, String estado, String telefone, String cep, int numero) {
        super(codigo, nome, logradouro, bairro, municipio, estado, telefone, cep, numero);
        this.cpf = cpf;
        this.identidade = identidade;
    }

    public PessoaFisica() {

    }

    public PessoaFisica(String cpf, String identidade) {
        this.cpf = cpf;
        this.identidade = identidade;
    }

    // faz cadastro
    public PessoaFisica CadastrarPessoa() {

        System.out.println("Insira o CPF: ");
        this.cpf = in.next();
        System.out.println("Insira a identidade: ");
        this.identidade = in.next();
        super.cadastraCliente();

        PessoaFisica pessoa = new PessoaFisica(this.cpf, this.identidade, this.codigo, this.nome, this.logradouro, this.bairro, this.municipio, this.estado, this.telefone, this.cep, this.numero);
        System.out.println("---------------------------");
        System.out.println("Pessoa física cadastrada!");
        System.out.println("---------------------------");

        return pessoa;
    }
    
    //fazer consulta
    public void consultaCliente(ArrayList<Cliente> arrayCliente) {
        boolean encontrou = false;

        System.out.println("Insira o cpf: ");
        String cpfauxiliar;
        cpfauxiliar = in.next();

        for (int i = 0; i < arrayCliente.size(); i++) {
            Cliente cliente = (Cliente) arrayCliente.get(i);
            if (cliente instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) cliente;

                if (pessoaFisica.getNome().equals(cpfauxiliar)) {
                    cliente.imprimeCliente();
                    pessoaFisica.ImprimirDadosPessoaFisica();
                    encontrou = true;
                }
            }
        }
        if (encontrou != true) {
            if (encontrou != true) {
                System.out.println("-------------------------");
                System.out.println("O cliente (pessoa fisíca) não foi encontrado, verifique se ele está cadastrado!");
                System.out.println("-------------------------");
            }
        }
    }

    //excluir cliente
    public void excluirCliente(ArrayList<Cliente> arrayCliente) {

        boolean encontrou = false;
        System.out.println("Nome: ");
        String nomeauxiliar;
        nomeauxiliar = in.next();

        for (int i = 0; i < arrayCliente.size(); i++) {

            Cliente cliente = (Cliente) arrayCliente.get(i);

            if (cliente instanceof PessoaFisica) {
                Cliente pessoaFisica = (PessoaFisica) cliente;

                if (pessoaFisica.getNome().equals(nomeauxiliar)) {
                    super.excluiCliente(arrayCliente, pessoaFisica);
                    encontrou = true;
                    System.out.println("-------------------------");
                    System.out.println("O cliente (pessoa fisíca) foi excluido!");
                    System.out.println("-------------------------");

                }
            }
        }

        if (encontrou != true) {
            System.out.println("-------------------------");
            System.out.println("O cliente não foi encontrado, verifique se ele está cadastrado!");
            System.out.println("-------------------------");
        }
    }

    // imprimir dados
    public void ImprimirDadosPessoaFisica() {
        System.out.println("CPF: " + this.cpf + " ");
        System.out.println("Identidade: " + this.identidade + " ");
        super.imprimeCliente();
    }

    // relatório de todos
    public void relatorioCliente(ArrayList arrayCliente) {
        if (super.verificaCadastrosCliente(arrayCliente)) {
            System.out.println("Não há clientes cadastrados, por favor faça os cadastros!");
        } else {
            System.out.println("Pacientes cadastrados:");
            for (int i = 0; i < arrayCliente.size(); i++) {
                Cliente cliente = (Cliente) arrayCliente.get(i);

                if (cliente instanceof PessoaFisica) {
                    PessoaFisica pessoaFisica = (PessoaFisica) cliente;
                    cliente.imprimeCliente();
                    ImprimirDadosPessoaFisica();
                }
            }
        }

    }

    //getter e setters
    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

}
