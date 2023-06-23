package med.voll.api.domain.consulta.validacoes.validacoesCancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsnulta;
import med.voll.api.domain.consulta.validacoes.ValidadorCancelamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorCancelamentoconsultaAntecedencia implements ValidadorCancelamento {

    @Autowired
    ConsultaRepository consultaRepository;
    @Override
    public void validar(DadosCancelamentoConsnulta dados) {

        Consulta consulta = consultaRepository.getReferenceById(dados.idConsulta());
        System.out.println(consulta.getData().getHour() + "==============");
        System.out.println(LocalDateTime.now().getHour() + "==============");
        System.out.println(LocalDateTime.now().getHour() + consulta.getData().getHour() + "==============");
        System.out.println("hora e dia da consulta" );
        throw new ValidacaoException("a consulta só pode ser desmarcada com mais de 24 horas de antecedência");
//        if (consulta.getData().getHour() + LocalDateTime.now().getHour() >= 24){
//            throw new ValidacaoException("a consulta só pode ser desmarcada com mais de 24 horas de antecedência");
//        }
    }
}
