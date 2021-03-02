package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 2L);
		Conta conta = movimentacao.getConta();
		
		//Buscando a quantidade de movimentações de uma determinada Conta
		int quantidadeDeMovimentacoes = conta.getMovimentacoes().size();
		System.out.println("Quantidade de movimentacões: " + quantidadeDeMovimentacoes);
		System.out.println(conta.getTitular());
	}

}
