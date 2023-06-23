package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public interface ValidadorAgendamento {
    void validar(DadosAgendamentoConsulta dados);
}
