package br.com.alura.job;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

//@Stateless
@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
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
	
	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext context;
	
	@Resource(mappedName = "java:/jms/queue/EmailQueue")
	private Queue queue;
	
	@Schedule(hour = "*", minute = "*", second = "*/10") // Quando o segundo for divisivel por 10 com resto 0 o email é método o invocado
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void enviarEmail() {
		List<AgendamentoEmail> listarPorNaoAgendado = agendamentoEmailServico.listarPorNaoAgendado();
		listarPorNaoAgendado.forEach(emailNaoAgendado -> {
//			agendamentoEmailServico.enviar(emailNaoAgendado);
			context.createProducer().send(queue, emailNaoAgendado);
			agendamentoEmailServico.alterar(emailNaoAgendado);
		});
	}

}
