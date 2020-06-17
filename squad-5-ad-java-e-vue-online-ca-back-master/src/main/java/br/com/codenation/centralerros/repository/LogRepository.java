package br.com.codenation.centralerros.repository;

import br.com.codenation.centralerros.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    Page<Log> findAll(Pageable pageable);

    Page<Log> findByCategoria(Enum categoria, Pageable pageable);

    Page<Log> findByCategoriaAndLevel(Enum categoria, Enum level, Pageable pageable);

    @Query(" select l from Log l where categoria = :categoria and detalhe like %:descricao% ")
    Page<Log> findByCategoriaWithDescricao(@Param("categoria") Enum categoria,
                                           @Param("descricao") String descricao, Pageable pageable);

    @Query(" select l from Log l where categoria = :categoria and origem like %:origem%")
    Page<Log> findByCategoriaWithOrigem(@Param("categoria") Enum categoria,
                                        @Param("origem") String origem, Pageable pageable);


}
