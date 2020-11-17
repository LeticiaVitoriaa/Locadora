/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.*;

/**
 *
 * @author clara
 */
public class PessoaFisica extends Cliente {

    Scanner in = new Scanner(System.in);

    private int cpf;
    private int identidade;

    public PessoaFisica(int cpf, int identidade, int código, String nome, int logradouro, int numero, String bairro, String municipio, String estado, String cep, String telefone, int maxMidia) {
        super(código, nome, logradouro, numero, bairro, municipio, estado, cep, telefone, maxMidia);
        this.cpf = cpf;
        this.identidade = identidade;
    }

    public PessoaFisica(int cpf, int identidade) {
        this.cpf = cpf;
        this.identidade = identidade;
    }

    public PessoaFisica() {

    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdentidade() {
        return identidade;
    }

    public void setIdentidade(int identidade) {
        this.identidade = identidade;
    }

    public PessoaFisica CadastrarPessoa() {

        System.out.println("CPF: ");
        this.cpf = in.next();
        System.out.println("IDENTIDADE: ");
        this.identidade = in.next();
        //super.CadastrarCliente();

        PessoaFisica pessoa = new PessoaFisica(this.cpf, this.identidade);
        return pessoa;
    }

    public void ConsultarPessoaFisica(ArrayList clientes) {

        System.out.println("Por favor, insira seu cpf: ");
        int cpf = in.next();

        for (int i = 0; i < clientes.size(); i++) {
            PessoaFisica pessF = (PessoaFisica) clientes.get(i);
            if (pessF instanceof PessoaFisica) {
                PessoaFisica pesFisica = (PessoaFisica) pessF;
                if (pesFisica.getCpf().equals(cpf)) {
                    pesFisica.ImprimirDadosPessoaFisica();
                }
         }else {
                System.out.println("Desculpe, não foi possível encontrar a pessoa fisíca!");
            }
        }
    }

    public void ImprimirDadosPessoaFisica() {
        System.out.println("CPF: " + this.cpf + " ");
        System.out.println("Identidade: " + this.identidade + " ");
        //super.ImprimirDadosCliente();
    }
}