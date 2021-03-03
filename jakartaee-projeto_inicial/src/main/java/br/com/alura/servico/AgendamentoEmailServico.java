package br.com.alura.servico;

import java.util.List;

import javax.ejb.Stateless;

// Aqui não quero guardar estado da minha aplicação
// quero que a cada requisição do usuario seja criado um novo EJB
// para isso vamos utilizar a anotação @Stateless
// abaixo acabamos de criar um EJB apartir da nossa classe

@Stateless
public class AgendamentoEmailServico {
	
	public List<String> listar() {
		return List.of("joao@alura.com.br");
	}

}
