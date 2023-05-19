package med.voll.api.Controller;

import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

public record DadosAtualizarPaciente(Long id, String nome, String telefone, DadosEndereco endereco
) {
}
