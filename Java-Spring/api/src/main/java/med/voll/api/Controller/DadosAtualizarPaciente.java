package med.voll.api.Controller;

import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizarPaciente(Long id, String nome, String telefone, DadosEndereco endereco
) {
}
