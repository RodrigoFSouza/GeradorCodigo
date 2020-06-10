        package com.rfs.data.GeradorDTO.repository;

        import com.rfs.data.GeradorDTO.domain.Usuario;

        import org.springframework.data.jpa.repository.*;
        import org.springframework.stereotype.Repository;

        import java.util.Optional;

        @Repository
        public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
            @Query(value = "SELECT MAX(e.id) FROM Usuario e")
            Optional<Long> getUltimoId();
        }

