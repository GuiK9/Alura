package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosCancelamentoConsnulta;
import org.springframework.stereotype.Component;
@Component
public interface ValidadorCancelamento {
    void validar(DadosCancelamentoConsnulta dados);
}
