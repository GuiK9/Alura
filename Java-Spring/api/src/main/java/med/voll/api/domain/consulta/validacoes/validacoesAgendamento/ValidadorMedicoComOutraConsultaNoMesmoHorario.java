package med.voll.api.domain.consulta.validacoes.validacoesAgendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.validacoes.ValidadorAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamento {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Medico já possui outra consulta nesse mesmo horário");
        }
    }
}
