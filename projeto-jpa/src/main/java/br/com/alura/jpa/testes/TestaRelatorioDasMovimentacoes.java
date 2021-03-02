package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// Criando a Query com jpql
		// Aqui estamos trazendo todas as contas cadastradas
		// String jpql = "select c from Conta c";
		
		// Aqui estamos trazendo toda as contas que tenham movimentações
		// String jpql = "select c from Conta c join fetch c.movimentacoes";
		
		// Aqui estamos trazendo todas as contas quer tenham ou não movimentações
		// String jpql = "select c from Conta c left join fetch c.movimentacoes";
		
		// Aqui estamos trazendo as contas e não repetindo as que tem movimentações
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		
		// Vamos abstrair a String dentro de um Objeto do tipo TypedQuery
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		
		List<Conta> contas = query.getResultList();
		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Agência: " + conta.getAgencia());
			System.out.println("Número: " + conta.getNumero());
			System.out.println("Movimentações: " + conta.getMovimentacoes());
		}
	}

}
