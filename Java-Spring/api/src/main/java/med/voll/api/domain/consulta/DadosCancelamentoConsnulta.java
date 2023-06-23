package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsnulta(
        @NotNull
        Long idConsulta,
        @NotNull
        String motivoCancelamento

) {
}
