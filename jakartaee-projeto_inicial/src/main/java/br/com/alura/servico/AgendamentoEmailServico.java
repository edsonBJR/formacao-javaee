package br.com.alura.servico;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

// Aqui não quero guardar estado da minha aplicação
// quero que a cada requisição do usuario seja criado um novo EJB
// para isso vamos utilizar a anotação @Stateless
// abaixo acabamos de criar um EJB apartir da nossa classe

@Stateless
public class AgendamentoEmailServico {
	
	private static final Logger LOGGER = 
			Logger.getLogger(AgendamentoEmailServico.class.getName());

	@Inject
	private AgendamentoEmailDAO dao;
	
	public List<AgendamentoEmail> listar() {
//		AgendamentoEmailDAO dao = new AgendamentoEmailDAO();
		return dao.listar();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(false);
		dao.inserir(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarPorNaoAgendado() {
		return dao.listarPorNaoAgendado();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void alterar(AgendamentoEmail agendamentoEmail) {
		if(agendamentoEmail.getEmail().equals("ebjr.tux@gmail.com")) {
			throw new RuntimeException("Não foi possível alterar");
		} else {
			agendamentoEmail.setAgendado(true);
			dao.alterar(agendamentoEmail);			
		}
	}

	public void enviar(AgendamentoEmail agendamentoEmail) {
		try {
			Thread.sleep(5000);
			LOGGER.info("O email do(a) usuário(a) " + agendamentoEmail.getEmail()
					+ " foi enviado!");
		} catch(Exception ex) {
			LOGGER.warning(ex.getMessage());
		}
	}
}