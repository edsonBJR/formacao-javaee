package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		query.select(sum);
		
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		
		System.out.println("A Soma das Movimentações é: " + typedQuery.getSingleResult());

		//		MovimentacaoDao dao = new MovimentacaoDao(em);

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
