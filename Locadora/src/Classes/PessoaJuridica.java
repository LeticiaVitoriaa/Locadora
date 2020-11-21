package Classes;

import java.util.*;

public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String inscrição_Estadual;

    public PessoaJuridica CadastrarPessoaJuridica() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Insira o CNPJ: ");
        this.cnpj = leitor.next();
        System.out.println("Insira a Inscrição Estadual: ");
        this.inscrição_Estadual = leitor.next();

        super.cadastraCliente();
        PessoaJuridica pessoaJuridica = new PessoaJuridica(this.cnpj, this.inscrição_Estadual, this.codigo,
                this.nome, this.logradouro, this.bairro,
                this.municipio, this.estado, this.telefone, this.cep, this.numero);
        return pessoaJuridica;
    }

    public void ConsultarPessoaJuridica(ArrayList clientes) {
        Scanner leitor = new Scanner(System.in);
        String cnpj;

        System.out.println("Insira o CNPJ: ");
        cnpj = leitor.next();

        for (int i = 0; i < clientes.size(); i++) {
            PessoaJuridica pessJ = (PessoaJuridica) clientes.get(i);
            if (pessJ instanceof PessoaJuridica) {
                PessoaJuridica pesJuridica = (PessoaJuridica) pessJ;
                if (pesJuridica.getCnpj().equals(cnpj)) {
                    pesJuridica.ImprimirDadosPessoaJuridica();
                }
            } else {
                System.out.println("Pessoa Jurídica não encontrada!");
            }
        }
    }

    public void ImprimirDadosPessoaJuridica() {
        System.out.println("CNPJ: " + this.cnpj + " ");
        System.out.println("Inscrição Estadual: " + this.inscrição_Estadual + " ");
        super.imprimeCliente();
    }

    public PessoaJuridica(String cnpj, String inscrição_Estadual, String codigo, String nome, String logradouro, String bairro, String municipio, String estado, String telefone, String cep, int numero) {
        super(codigo, nome, logradouro, bairro, municipio, estado, telefone, cep, numero);
        this.cnpj = cnpj;
        this.inscrição_Estadual = inscrição_Estadual;
    }

    public PessoaJuridica() {
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
