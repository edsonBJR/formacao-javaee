package br.com.alura.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

// Aqui não quero guardar estado da minha aplicação
// quero que a cada requisição do usuario seja criado um novo EJB
// para isso vamos utilizar a anotação @Stateless
// abaixo acabamos de criar um EJB apartir da nossa classe

@Stateless
public class AgendamentoEmailServico {

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

}
