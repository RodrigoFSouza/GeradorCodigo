        package com.rfs.data.GeradorDTO.repository;

        import com.rfs.data.GeradorDTO.domain.UnidadeMedida;

        import org.springframework.data.jpa.repository.*;
        import org.springframework.stereotype.Repository;

        import java.util.Optional;

        @Repository
        public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Long>, JpaSpecificationExecutor<UnidadeMedida> {
            @Query(value = "SELECT MAX(e.id) FROM UnidadeMedida e")
            Optional<Long> getUltimoId();
        }

