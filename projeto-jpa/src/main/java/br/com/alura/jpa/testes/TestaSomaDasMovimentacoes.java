package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		MovimentacaoDao dao = new MovimentacaoDao();
		System.out.println("A Soma das Movimentações é: " + dao.getSomaDasMovimentacoes());


//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
//		EntityManager em = emf.createEntityManager();
//		
//		// Aqui estamos buscando a soma
//		// String jpql = "select sum(m.valor) from Movimentacao m";
//		// Aqui estamos buscando a média
//		String jpql = "select avg(m.valor) from Movimentacao m";
//		
//		// Aqui o tipo correto para armazenar a soma das movimentações
//		// TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
//		
//		// Aqui o tipo correto para armazenar a média das movimentações
//		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
//		
//		// BigDecimal somaDasMovimentacoes = query.getSingleResult();
//		Double mediaDasMovimentacoes = query.getSingleResult();
		
	}
}
