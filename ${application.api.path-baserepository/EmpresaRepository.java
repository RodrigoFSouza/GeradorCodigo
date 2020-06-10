        package <package-base>.repository;

        import <package-base>.domain.<entity-base>;

        import org.springframework.data.jpa.repository.*;
        import org.springframework.stereotype.Repository;

        import java.util.Optional;

        @Repository
        public interface <entity-base>Repository extends JpaRepository<<entity-base>, Long>, JpaSpecificationExecutor<<entity-base>> {
            @Query(value = "SELECT MAX(e.id) FROM <entity-base> e")
            Optional<Long> getUltimoId();
        }

