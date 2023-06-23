package med.voll.api.domain.consulta.validacoes.validacoesAgendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.validacoes.ValidadorAgendamento;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ValidadorPacienteAtivo implements ValidadorAgendamento {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }

}
