package br.com.letscode.java;

import java.math.BigDecimal;
import java.util.Scanner;

public class Conta {

    protected String nome, nomeDaEmpresa;
    protected String cpf, cnpj;
    protected BigDecimal saldoCC, saldoCP, saldoCI;
    protected BigDecimal rendimentoCI, rendimentoCP, rendimentoPJ, taxa;

    protected Scanner input = new Scanner(System.in);

    public Conta() {

    }


    public Conta(String nome, String nomeDaEmpresa, String cpf, String cnpj, BigDecimal saldoCC, BigDecimal saldoCP,
                 BigDecimal saldoCI, int qtdeSaques, BigDecimal rendimentoCI, BigDecimal rendimentoCP,
                 BigDecimal rendimentoPJ, BigDecimal taxa, Scanner input) {

        this.nome = nome;
        this.nomeDaEmpresa = nomeDaEmpresa;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.saldoCC = saldoCC;
        this.saldoCP = saldoCP;
        this.saldoCI = saldoCI;
        this.rendimentoCI = rendimentoCI;
        this.rendimentoCP = rendimentoCP;
        this.rendimentoPJ = rendimentoPJ;
        this.taxa = taxa;
        this.input = input;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public BigDecimal getSaldoCC() {
        return saldoCC;
    }

    public void setSaldoCC(BigDecimal saldoCC) {
        this.saldoCC = saldoCC;
    }

    public BigDecimal getSaldoCP() {
        return saldoCP;
    }

    public void setSaldoCP(BigDecimal saldoCP) {
        this.saldoCP = saldoCP;
    }

    public BigDecimal getSaldoCI() {
        return saldoCI;
    }

    public void setSaldoCI(BigDecimal saldoCI) {
        this.saldoCI = saldoCI;
    }

    public BigDecimal getRendimentoCI() {
        return rendimentoCI;
    }

    public void setRendimentoCI(BigDecimal rendimentoCI) {
        this.rendimentoCI = rendimentoCI;
    }

    public BigDecimal getRendimentoCP() {
        return rendimentoCP;
    }

    public void setRendimentoCP(BigDecimal rendimentoCP) {
        this.rendimentoCP = rendimentoCP;
    }

    public BigDecimal getRendimentoPJ() {
        return rendimentoPJ;
    }

    public void setRendimentoPJ(BigDecimal rendimentoPJ) {
        this.rendimentoPJ = rendimentoPJ;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
}
