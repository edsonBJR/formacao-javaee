package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.com.alura.entidade.AgendamentoEmail;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AgendamentoEmailDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private UserTransaction userTransaction;

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
	
	
	public List<AgendamentoEmail> listarPorNaoAgendado() {
		return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae WHERE ae.agendado = false",
				AgendamentoEmail.class).getResultList();
	}

	
	public void alterar(AgendamentoEmail agendamentoEmail) {
		try {
			userTransaction.begin();
			entityManager.merge(agendamentoEmail);
			userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
