package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            selcet m from m
            where   
            m.ativo = 1
            and 
            m.especialidade = :especialidade
            and 
            
     
            """)
    Medico EscolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);
}
