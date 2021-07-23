package br.com.letscode.java;

import java.math.BigDecimal;

public class ContaPF extends Conta {

    public void abrirCOnta() {
        System.out.println("Digite o seu nome: ");
        this.nome = input.nextLine();
        setNomeDaEmpresa(this.nome);
        System.out.printf("Olá, %s digite abaixo seu CPF: ", getNome());
        this.cpf = input.nextLine();
        setCpf(this.cpf);
        System.out.println("\nJá estamos abrindo sua conta corrente, conta investimento e conta poupança. ");
        System.out.println("Você gostaria de adicionar dinheiro à sua conta? Se sim, qual quantia? ");
        this.saldoCC = input.nextBigDecimal();
        System.out.println("Valor adicionado com sucesso.");
        setSaldoCC(this.saldoCC);
        setSaldoCI(this.saldoCI = new BigDecimal("0"));
        setSaldoCP(this.saldoCP = new BigDecimal("0"));
    }

    public void sacar() {
        BigDecimal qtdeSaque;
        System.out.printf("%s quanto você gostaria de sacar? ", getNome());
        qtdeSaque = input.nextBigDecimal();
        if (qtdeSaque.compareTo(this.saldoCC) < 1) {
            this.saldoCC = this.saldoCC.subtract(qtdeSaque);
            System.out.printf("Você sacou R$ %.2f e agora seu saldo é de R$ %.2f.", qtdeSaque, getSaldoCC());
        } else System.err.println("Saldo insuficiente na conta. ");
    }

    public void contaInvestimentos() {
        this.rendimentoCI = new BigDecimal("1.03");
        this.saldoCI = this.saldoCI.multiply(this.rendimentoCI);
    }

    public void extrato() {
        System.out.println("----------------------------- EXTRATO-----------------------------------");
        System.out.printf("Nome: %s\n", getNome());
        System.out.printf("Cpf: %s", getCpf());
        System.out.println();
        System.out.printf("O saldo atual da conta corrente é de: R$ %.2f", getSaldoCC());
        System.out.println();
        System.out.printf("Para pessoa física a conta investimento rende 3%% e seu saldo é R$ %.2f", getSaldoCI());
        System.out.println();
        System.out.printf("O saldo atual da conta poupança é de: R$ %.2f", getSaldoCP());
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");

    }

    public void transferir() {
        int tipoDaConta;
        BigDecimal tranferir;
        String transferenciaConta;

        System.out.printf("%s você deseja tranferir para sua conta de:\ninvestimentos[1]\nPoupança[2]\nOu para outra pessoa[3]?\n ", getNome());
        tipoDaConta = input.nextInt();

        if (tipoDaConta == 1) {
            System.out.printf("%s seu saldo atual na conta corrente é de R$ %.2f. ", getNome(), getSaldoCC());
            System.out.println("Quanto você gostaria de transferir? ");
            tranferir = input.nextBigDecimal();
            System.out.printf("Você transferiu R$ %.2f para sua conta de investimentos. ", tranferir);
            this.saldoCC = this.saldoCC.subtract(tranferir);
            this.saldoCI = this.saldoCI.add(tranferir);
            System.out.printf("Depois dessa operação o saldo da sua conta corrente é de R$ %.2f\nE da sua conta de investimentos é R$ %.2f.", getSaldoCC(), getSaldoCI(), getSaldoCP());
        }
        else if (tipoDaConta == 2) {
            System.out.printf("%s seu saldo da conta poupança é de R$ %.2f.", getNome(), getSaldoCP());
            System.out.println("Quanto você gostaria de transferir? ");
            tranferir = input.nextBigDecimal();
            System.out.printf("Depois dessa operação o saldo da sua conta corrente é de R$ %.2f\n E da sua conta poupança é R$ %.2f. ", tranferir);
        }
        else if (tipoDaConta == 3) {
            System.out.printf("%s seu saldo atual na conta corrente é de R$ %.2f,\n digite o número da conta que você quer transferir: ",getNome(), getSaldoCC());
            transferenciaConta = input.next();
            System.out.printf("QUanto você quer transferir para a conta %.0f ? ", transferenciaConta);
            tranferir = input.nextBigDecimal();
            this.saldoCC = this.saldoCC.subtract(tranferir);
            System.out.printf("Você transferiu para a conta %.0f e seu saldo na conta corrente é de:\n R$ %f", transferenciaConta, getSaldoCC());
        }
    }

    public void depositar() {
        BigDecimal depositarMinhaConta;
        System.out.printf("%s quanto você gostaria de depositar na sua conta? ", getNome());
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
