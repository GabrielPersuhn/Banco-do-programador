package br.com.letscode.java;

import java.math.BigDecimal;

public class ContaPJ extends Conta{

    public void abrirCOnta() {
        System.out.println("Digite o nome da sua empresa: ");
        this.nomeDaEmpresa = input.nextLine();
        setNomeDaEmpresa(this.nomeDaEmpresa);
        System.out.printf("Olá, %s digite abaixo seu CNPJ: ", getNomeDaEmpresa());
        this.cnpj = input.nextLine();
        setCnpj(this.cnpj);
        System.out.println("\nJá estamos abrindo sua conta corrente e conta investimento.");
        System.out.println("Você gostaria de adicionar dinheiro à sua conta? Se sim, qual quantia? ");
        this.saldoCC =input.nextBigDecimal();
        System.out.println("Valor adicionado com sucesso.");
        setSaldoCC(this.saldoCC);
        setSaldoCI(this.saldoCI = new BigDecimal("0"));
    }

    public void sacar() {
        BigDecimal qtdeSaque;
        System.out.printf("%s quanto você gostaria de sacar? ", getNomeDaEmpresa());
        qtdeSaque = input.nextBigDecimal();
        if (qtdeSaque.compareTo(this.saldoCC) < 1) {
            this.saldoCC = this.saldoCC.subtract(qtdeSaque);
            System.out.printf("Você sacou R$ %.2f e agora seu saldo é de R$ %.2f.", qtdeSaque, getSaldoCC());
        } else System.err.println("Saldo insuficiente na conta. ");
    }

    public void contaInvestimentos() {
        this.rendimentoPJ = new BigDecimal("1.05");
        this.saldoCI = this.saldoCI.multiply(this.rendimentoPJ);
    }

    public void extrato() {
        System.out.println("----------------------------- EXTRATO-----------------------------------");
        System.out.printf("Nome da empresa: %s\n", getNomeDaEmpresa());
        System.out.printf("Cnpj: %s", getCnpj());
        System.out.println();
        System.out.println("O saldo atual da conta corrente da sua empresa é de: R$ %.2f" + getSaldoCC());
        System.out.println();
        System.out.printf("Para empresas a conta investimento rende 5%% e seu saldo é R$ %.2f", getSaldoCI());
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");

    }

    public void transferir() {
        int tipoDaConta;
        BigDecimal tranferir;
        this.taxa = new BigDecimal("0.995");
        String transferenciaConta;

        System.out.printf("%s você deseja tranferir para sua conta de investimentos[1]\n ou para outra pessoa[2]?\n Lembrando que cobramos 0,5% para realizar transferencias. ", getNomeDaEmpresa());
        tipoDaConta = input.nextInt();

        if (tipoDaConta == 1) {
            System.out.printf("%s seu saldo atual na conta corrente é de R$ %.2f. ", getNomeDaEmpresa(), getSaldoCC());
            System.out.println("Quanto você gostaria de transferir? ");
            tranferir = input.nextBigDecimal();
            System.out.printf("Você transferiu R$ %.2f para sua conta de investimentos. ", tranferir);
            this.saldoCC = this.saldoCC.subtract(tranferir);
            this.saldoCI = this.saldoCI.add(tranferir);
            this.saldoCI = this.saldoCI.multiply(this.taxa);
            System.out.printf("Depois dessa operação o saldo dasua conta corrente é de R$ %.2f\n e da sua conta de investimentos é R$ %.2f.", getSaldoCC(), getSaldoCI());
        }
        else if (tipoDaConta == 2) {
            System.out.printf("%s seu saldo atual na conta corrente é de R$ %.2f,\n digite o número da conta que você quer transferir: ",getNomeDaEmpresa(), getSaldoCC());
            transferenciaConta = input.next();
            System.out.printf("QUanto você quer transferir para a conta %.0f? ", transferenciaConta);
            tranferir = input.nextBigDecimal();
            this.saldoCC = this.saldoCC.subtract(tranferir);
            System.out.printf("Você transferiu para a conta %.0f e seu saldo na conta corrente é de:\n R$ %.2f", transferenciaConta, getSaldoCC());
        }
    }

    public void depositar() {
        BigDecimal depositarMinhaConta;
        System.out.printf("%s quanto você gostaria de depositar na sua conta? ", getNomeDaEmpresa());
        depositarMinhaConta = input.nextBigDecimal();
        this.saldoCC = this.saldoCC.add(depositarMinhaConta);
        System.out.printf("Você depositou R$ %.2f e seu saldo atualizado da sua conta é de R$ %.2f.", depositarMinhaConta, getSaldoCC());
    }


    public void menuBanco() {
        System.out.println();
        System.out.println("------ O que deseja fazer?---------");
        System.out.println(" 1 - Consultar Extrato");
        System.out.println(" 2 - Transferir");
        System.out.println(" 3 - Sacar");
        System.out.println(" 4 - Depositar");
        System.out.println(" 5 - Sair");
        System.out.println("__________________________________");
    }


    public void acoesMenu(int escolha) {
        switch (escolha) {
            case 1:
                extrato();
                break;
            case 2:
                transferir();
                break;
            case 3:
                sacar();
                break;
            case 4:
                depositar();
                break;
            case 5:
                System.out.println("Aplicação encerrada, obrigado pela preferência. ");
        }
    }

    public void escolha () {
        int escolha;
        do {
            menuBanco();
            escolha = this.input.nextInt();
            acoesMenu(escolha);
        } while (escolha != 5);
    }



}
