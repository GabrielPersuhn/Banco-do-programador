package br.com.letscode.java;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
//                  Crie uma aplicação que simule uma app bancária. Os clientes podem ser pessoa física ou jurídica,
//          sendo que para PJ existe a cobrança de uma taxa de 0.5% para cada saque ou transferência.
//          Além do produto conta-corrente, os clientes PF podem abrir uma conta-poupança e conta-investimento.
//          Clientes PJ não abrem poupança, mas seus rendimentos em conta-investimento rendem 2% a mais.
//          Crie as funcionalidades: ABRIR CONTA, SACAR, DEPOSITAR, TRANSFERÊNCIA, INVESTIR, CONSULTAR SALDO.
//          Use a classe "Aplicacao" para criar seu método "main" e demonstrar o fucionamento do seu código.

        iniciar();

    }
    public static void iniciar(){

        int tipoConta;
        Scanner input = new Scanner(System.in);

        System.out.println("Bem vindo ao Banco dos programadores, deseja abrir uma conta PF[1] ou uma conta PJ[2]? ");
        tipoConta = input.nextInt();
        if (tipoConta == 1){
            ContaPF contaPf = new ContaPF();
            contaPf.abrirCOnta();
            contaPf.escolha();
        }
        if (tipoConta == 2){
            ContaPJ contaPj = new ContaPJ();
            contaPj.abrirCOnta();
            contaPj.escolha();
        }

    }
}
