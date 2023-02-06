package pway;

import java.util.Objects;

public class Cliente {
	 private String nome;

	private Double transacao;
	
	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public Cliente(String nome, Double transacao) {
		super();
		this.nome = nome;
		this.transacao = transacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTransacao() {
		return transacao;
	}

	public void setTransacao(double transacao) {
		this.transacao = transacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, transacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Cliente nome: " + nome + ", transação: R$" + transacao;
	}
	
	
	
	

}
