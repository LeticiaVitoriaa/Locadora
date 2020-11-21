package Classes;

import java.util.*;

public class PessoaFisica extends Cliente {

    Scanner in = new Scanner(System.in);

    private String cpf, identidade;

    public PessoaFisica CadastrarPessoa() {

        System.out.println("Insira o CPF: ");
        this.cpf = in.nextLine();
        System.out.println("Insira a identidade: ");
        this.identidade = in.nextLine();
        super.cadastraCliente();

        PessoaFisica pessoa = new PessoaFisica(this.cpf, this.identidade, this.codigo, this.nome, this.logradouro, this.bairro,
                this.municipio, this.estado, this.telefone, this.cep, this.numero);

        System.out.println("Pessoa física cadastrada");
        return pessoa;
    }

    public void ConsultarPessoaFisica(ArrayList arrayCliente) {

        System.out.println("Por favor, insira seu cpf: ");
        String cpf = in.next();

        for (int i = 0; i < arrayCliente.size(); i++) {
            PessoaFisica pessF = (PessoaFisica) arrayCliente.get(i);
            if (pessF instanceof PessoaFisica) {
                PessoaFisica pesFisica = (PessoaFisica) pessF;
                if (pesFisica.getCpf().equals(cpf)) {
                    pesFisica.ImprimirDadosPessoaFisica();
                }
            } else {
                System.out.println("Desculpe, não foi possível encontrar a pessoa fisíca!");
            }
        }
    }

    public void ImprimirDadosPessoaFisica() {
        System.out.println("CPF: " + this.cpf + " ");
        System.out.println("Identidade: " + this.identidade + " ");
        super.imprimeCliente();
    }

    public PessoaFisica(String cpf, String identidade, String codigo, String nome, String logradouro, String bairro, String municipio, String estado, String telefone, String cep, int numero) {
        super(codigo, nome, logradouro, bairro, municipio, estado, telefone, cep, numero);
        this.cpf = cpf;
        this.identidade = identidade;
    }

    public PessoaFisica() {
    }

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
