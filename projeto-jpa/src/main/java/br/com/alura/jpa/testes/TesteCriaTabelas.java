package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {

	public static void main(String[] args) {
		// Aqui temos o objeto que é responsável por criar a fabricar que irá conversar com o Banco de Dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		// Aqui estamos iniciando a nossa fabrica que irá crirar nossas tabelas
		EntityManager createEntityManager = emf.createEntityManager();
		// Aqui estamos fechando a nossa fabrica
		emf.close();
		
	}
}
