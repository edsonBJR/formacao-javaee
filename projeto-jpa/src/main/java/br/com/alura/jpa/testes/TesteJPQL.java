package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// Aqui temos query no formato de SQL armazenada em uma String
		// String jpql = "select * from movimentacao where conta_id = 2";
		
		// Criando a String com a query no formato JPQL
		// String jpql = "select m from Movimentacao m where m.conta.id = 2";
		
		// Aqui estamos instanciando um Objeto do tipo Conta
		// definindo o Id desse objeto como sendo 2
		Conta conta = new Conta();
		conta.setId(2L);
		
		// Aqui estamos criando a JPQL informando o parametro do tipo conta, por convenção chama-se :pConta
		// Dessa forma nossa query está mais proxima do mundo da orientaçao a objetos do que do mundo relacional
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
		
		// Agora precisamos instanciar uma interface que irá fornecer os métodos para executar a query
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		
		// Aqui estamos usando um método que encapsula o parametro e sua posição na query
		query.setParameter("pConta", conta);
		
		List<Movimentacao> resultList = query.getResultList();

		// Agora vamos criar um foreach para imprimir cada elemento desta lista
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}

}
