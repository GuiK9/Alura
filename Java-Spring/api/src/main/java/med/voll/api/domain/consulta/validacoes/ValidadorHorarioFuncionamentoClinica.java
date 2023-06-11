package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoClinica {

    public void validar(DadosAgendamentoConsulta dados){
        var daraConsulta = dados.data();
        var domingo = daraConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = daraConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = daraConsulta.getHour() > 18;
        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("A consulta fora do horário de funcionamento da clinica");
        }
    }
}
