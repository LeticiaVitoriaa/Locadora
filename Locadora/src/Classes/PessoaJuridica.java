package Classes;

import java.util.*;

/**
 *
 * @author Letícia
 */
public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String inscrição_Estadual;

    public PessoaJuridica(String cnpj, String inscrição_Estadual, int código, String nome, int logradouro, int numero, String bairro, String municipio, String estado, String cep, String telefone, int maxMidia) {
        super(código, nome, logradouro, numero, bairro, municipio, estado, cep, telefone, maxMidia);
        this.cnpj = cnpj;
        this.inscrição_Estadual = inscrição_Estadual;
    }

    public PessoaJuridica(String cnpj, String inscrição_Estadual) {
        this.cnpj = cnpj;
        this.inscrição_Estadual = inscrição_Estadual;
    }

    public PessoaJuridica() {

    }

    public PessoaJuridica CadastrarPaciente() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("CNPJ: ");
        this.cnpj = leitor.next();
        System.out.println("Inscrição Estadual: ");
        this.inscrição_Estadual = leitor.next();

        //super.CadastrarCliente();
        PessoaJuridica paciente = new PessoaJuridica(this.cnpj, this.inscrição_Estadual);
        return paciente;
    }

    public void ConsultarPessoaJuridica(ArrayList clientes) {
        Scanner leitor = new Scanner(System.in);
        String cnpj;

        System.out.println("Digite o cpf: ");
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
        //super.ImprimirDadosCliente();
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getInscrição_Estadual() {
        return inscrição_Estadual;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setInscrição_Estadual(String inscrição_Estadual) {
        this.inscrição_Estadual = inscrição_Estadual;
    }

}
