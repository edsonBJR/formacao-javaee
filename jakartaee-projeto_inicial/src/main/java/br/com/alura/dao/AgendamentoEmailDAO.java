package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import br.com.alura.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {

	@PersistenceContext
	private EntityManager entityManager;

//  Como nossa classe é um EJB Stateless não precisamos mais cuidar das configurações da infra
//	para conexão com o banco de dados
//	public AgendamentoEmailDAO() {
//		EntityManagerFactory entityManagerFactory = 
//				Persistence.createEntityManagerFactory("AgendamentoEmailDS");
//		this.entityManager = entityManagerFactory.createEntityManager();
//	}

	public List<AgendamentoEmail> listar() {
//		entityManager.getTransaction().begin();
//		List<AgendamentoEmail> resultado = 
		return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae", AgendamentoEmail.class).getResultList();
//		return resultado;
	}

	public void inserir(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);
	}

}
