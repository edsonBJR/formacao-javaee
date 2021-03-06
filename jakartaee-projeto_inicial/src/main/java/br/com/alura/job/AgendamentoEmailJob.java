package br.com.alura.job;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

//@Stateless
@Singleton
public class AgendamentoEmailJob {
	
//	private static AgendamentoEmailJob instance;
//	
//	private AgendamentoEmailJob() {}
//
//	public synchronized static AgendamentoEmailJob getInstance() {
//		if(instance == null) {
//			instance = new AgendamentoEmailJob();
//		} return instance;
//	}
	
	@Inject
	private AgendamentoEmailServico agendamentoEmailServico;
	
	@Schedule(hour = "*", minute = "*", second = "*/10") // Quando o segundo for divisivel por 10 com resto 0 o email é método o invocado
	public synchronized void enviarEmail() {
		List<AgendamentoEmail> listarPorNaoAgendado = agendamentoEmailServico.listarPorNaoAgendado();
		listarPorNaoAgendado.forEach(emailNaoAgendado -> {
			agendamentoEmailServico.enviar(emailNaoAgendado);;
			agendamentoEmailServico.alterar(emailNaoAgendado);
		});
	}

}
