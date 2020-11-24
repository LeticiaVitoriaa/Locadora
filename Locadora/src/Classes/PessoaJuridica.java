package Classes;

import java.util.*;

public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String inscrição_Estadual;

    public PessoaJuridica(String cnpj, String inscrição_Estadual, String codigo, String nome, String logradouro, String bairro, String municipio, String estado, String telefone, String cep, int numero) {
        super(codigo, nome, logradouro, bairro, municipio, estado, telefone, cep, numero);
        this.cnpj = cnpj;
        this.inscrição_Estadual = inscrição_Estadual;
    }

    public PessoaJuridica() {

    }

    public PessoaJuridica CadastrarPessoaJuridica() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Insira o CNPJ: ");
        this.cnpj = leitor.next();
        System.out.println("Insira a Inscrição Estadual: ");
        this.inscrição_Estadual = leitor.next();

        super.cadastraCliente();
        PessoaJuridica pessoaJuridica = new PessoaJuridica(this.cnpj, this.inscrição_Estadual, this.codigo, this.nome, this.logradouro, this.bairro, this.municipio, this.estado, this.telefone, this.cep, this.numero);
        System.out.println("---------------------------");
        System.out.println("Pessoa física cadastrada!");
        System.out.println("---------------------------");

        return pessoaJuridica;
    }

    //fazer consulta
    public void consultaCliente(ArrayList<Cliente> arrayCliente) {
        boolean encontrou = false;

        System.out.println("Insira o cpf: ");
        String cnpjauxiliar;
        cnpjauxiliar = in.next();

        for (int i = 0; i < arrayCliente.size(); i++) {
            Cliente cliente = (Cliente) arrayCliente.get(i);
            if (cliente instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) cliente;

                if (pessoaJuridica.getNome().equals(cnpjauxiliar)) {
                    cliente.imprimeCliente();
                    pessoaJuridica.ImprimirDadosPessoaJuridica();
                    encontrou = true;
                }
            }
        }
        if (encontrou != true) {
            if (encontrou != true) {
                System.out.println("-------------------------");
                System.out.println("O cliente (pessoa jurídica) não foi encontrado, verifique se ele está cadastrado!");
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

            if (cliente instanceof PessoaJuridica) {
                Cliente pessoaJuridica = (PessoaJuridica) cliente;

                if (pessoaJuridica.getNome().equals(nomeauxiliar)) {
                    super.excluiCliente(arrayCliente, pessoaJuridica);
                    encontrou = true;
                    System.out.println("-------------------------");
                    System.out.println("O cliente (pessoa jurídica) foi excluido!");
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

    // relatório de todos
    public void relatorioCliente(ArrayList arrayCliente) {
        if (super.verificaCadastrosCliente(arrayCliente)) {
            System.out.println("Não há clientes cadastrados, por favor faça os cadastros!");
        } else {
            System.out.println("Pacientes cadastrados:");
            for (int i = 0; i < arrayCliente.size(); i++) {
                Cliente cliente = (Cliente) arrayCliente.get(i);

                if (cliente instanceof PessoaJuridica) {
                    PessoaJuridica pessoaJuridica = (PessoaJuridica) cliente;
                    cliente.imprimeCliente();
                    ImprimirDadosPessoaJuridica();
                }
            }
        }

    }

    public void ImprimirDadosPessoaJuridica() {
        System.out.println("CNPJ: " + this.cnpj + " ");
        System.out.println("Inscrição Estadual: " + this.inscrição_Estadual + " ");
        super.imprimeCliente();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscrição_Estadual() {
        return inscrição_Estadual;
    }

    public void setInscrição_Estadual(String inscrição_Estadual) {
        this.inscrição_Estadual = inscrição_Estadual;
    }
}
