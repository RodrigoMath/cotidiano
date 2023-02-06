package pway;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
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
		int numMenu;
		numMenu = leitor.nextInt();
		leitor.nextLine();

//		first Passo fácil: por na lista.
//		second Passo médio: Vários usuários e proceder na lista seguindo a lógica de nome.
//		Digitar o nome toda vez?!
//		*transações internas
		Function<Cliente, String> msg = n -> "Transação:R$ " + Double.toString(n.getTransacao());
		Function<Cliente, Double> apenasValor = n -> n.getTransacao();
		BinaryOperator<Double> soma = (n, m) -> n + m;
		// Consumer<String> iguais = n -> n.equals(m);
		// -------------------------------------------------------------------------------
		// tem uso ?!
		// --------------------------------------------------------------------------------------------------------------
		
		
		for (int cont = 0; cont < 1000; cont++) {
			while (numMenu > 0 && numMenu < 6) {
				if (numMenu == 1) {
					System.out.println("Digite o nome do usuário:");
					usuario = leitor.nextLine();
					numMenu = solicitarProxOperacao(leitor);
				}
				if (numMenu == 2) {

					System.out.println("Digite o valor da transação:");
					valor = leitor.nextDouble();
					Cliente cliente = new Cliente(usuario, valor);
					financeiro.add(cliente);

					numMenu = solicitarProxOperacao(leitor);
				}
				if (numMenu == 3) {
					System.out.println("Digite o nome do usuário que deseja ver o saldo:");
					String a = leitor.nextLine();
					Cliente x = new Cliente(a);
					if (financeiro.contains(x)) {
						double saldo = financeiro.stream().filter(cliente -> cliente.getNome().equals(a)).map(v -> v.getTransacao())
								.reduce(soma).get(); // -----------------------------------------------------------------------
														// será que pega todos usuários ?
														// -----------------------------------------------------
						System.out.println("Usuário " + a + "tem saldo de R$:  " + saldo);

					} else {
						System.out.println("Nome inválido, tente novamente!");

					}

					numMenu = solicitarProxOperacao(leitor);
				}
				if (numMenu == 4) {

					System.out.println(financeiro);

					numMenu = solicitarProxOperacao(leitor);
				}
				if (numMenu == 5) {
					System.out.println("Digite o nome do Usuário: ");
					String name = leitor.nextLine();
					System.out.println(
							"Digite o valor da transferência, (-) caso envie a outra conta e (+) caso vá receber:");
					valor = leitor.nextDouble();
					leitor.nextLine();
					Cliente cliente = new Cliente(name, valor);
					financeiro.add(cliente);
					System.out.println("Agora o nome do usuário que irá ser afetado:");
					String name2 = leitor.nextLine();
					// da problema usar só cliente???
					// --------------------------------------------------------------------------------------
					// EXCEPTION ?!
					// ----------------------------------------------------------------------------------------------
					Cliente cliente2 = new Cliente(name2, -(valor));
					financeiro.add(cliente2);
					// Achar o total da conta da pessoa

					//
					// financeiro.stream().filter(a-> a.equals(name)).map(soma.apply(valor,
					// valorTransac ));

					numMenu = solicitarProxOperacao(leitor);
				}

				if (numMenu == 6) {
					break;

				}
			}
		}
		System.out.println("Obrigado(a) por usar nosso aplicativo!");

	}
	
	/**
	 *  descrever o método
	 * @param leitor
	 * @return
	 */
	private static int solicitarProxOperacao(Scanner leitor) {
		int numMenu= 0;
		do {
			try {
				
				numMenu = leitor.nextInt();
				leitor.nextLine();

			} catch (InputMismatchException e) {
				System.out.println("Você deve digitar números para funcionar a aplicação.");
			}
			 
		} while (numMenu <= 0 && numMenu >= 7);
		return numMenu;
	}

}
