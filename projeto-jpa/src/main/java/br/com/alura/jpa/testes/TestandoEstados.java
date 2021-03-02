package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {

		// Aqui temos um objeto do Tipo Trasient
		// Ela reside na memoria, possui informações, possui ID, 
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setNumero(123456);
		conta.setAgencia(6543);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		// Aqui estamos transformando um objeto que é Transient em Managed
		// agora ele tem uma característica que é a sincronização automática
		// com o banco de dados
		em.persist(conta);
		
		// Para remover um objeto do contexto da JPA
		// Com isso teremos o delete no banco de dados da conta
		// Aqui a conta deixa de ser Managed e vai para o estado Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		
	}

}
