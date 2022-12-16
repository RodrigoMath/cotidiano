package pway;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import test.While;

public class AgenciaBancaria {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		/*
		 * System.out.println("Digite seu nome:"); String nomeUsuario =
		 * leitor.nextLine();
		 */
		
		List<Cliente> financeiro = new ArrayList<>();
		System.out.println("Bem vindo ao sistema bancário, digite o nome de usuário para primeiro acesso:");
		String usuario = leitor.nextLine();
		double valor;
		Menu menu = new Menu();
		menu.chamaMenu();
		int numMenu = leitor.nextInt();

//		first Passo fácil: por na lista.
//		second Passo médio: Vários usuários e proceder na lista seguindo a lógica de nome.
//		Digitar o nome toda vez?!
//		*transações internas
		Function<Cliente, String> msg = n -> "Transação:R$ " + n.transacao.toString();
		Function<Cliente, Double> apenasValor = n -> n.transacao;
		BinaryOperator<Double> soma = (n, m) -> n + m;

		for (int cont = 0; cont < 1000; cont++) {
			while (numMenu > 0 && numMenu < 6) {
				if (numMenu == 1) {
					System.out.println("Digite o nome do usuário:");
					usuario = leitor.nextLine();
					
					numMenu = leitor.nextInt();
				}
				if (numMenu == 2) {

					System.out.println("Digite o valor da transação:");
					valor = leitor.nextDouble();
					Cliente cliente = new Cliente(usuario, valor);
					financeiro.add(cliente);
					
					numMenu= leitor.nextInt();
				}
				if(numMenu==3) {
					Double total = financeiro.stream().map(apenasValor).reduce(soma).get();
					System.out.println("R$ " + total);
					numMenu = leitor.nextInt();

					
				}
				if(numMenu == 4) {

					System.out.println(financeiro);
					
					numMenu = leitor.nextInt();
				}
				if(numMenu==5) {
					System.out.println("Digite ")
				}
				
				if(numMenu==6) {
					break;
				}
				}
			}
			System.out.println("Obrigado(a) por usar nosso aplicativo!");

		}
	}

