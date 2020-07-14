package com.rfs.data.GeradorDTO.repository.spec;

import com.rfs.data.GeradorDTO.domain.model.Entidade;
import com.rfs.data.GeradorDTO.domain.repository.filter.EntidadeFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

import static java.util.Objects.nonNull;

public class EntidadeSpecs {
    public static Specification<Entidade> applyFilters(EntidadeFilter filtros) {
        return (root, criteriaQuery, builder) -> {
            var predicates = new ArrayList<Predicate>();

            if (nonNull(filtros.getEntidadeId())) {
                predicates.add(builder.equal(root.get("id"), filtros.getEntidadeId()));
            }

            if (nonNull(filtros.getNomeDaTabela())) {
                predicates.add(builder.like(root.get("nomeDaTabela"), filtros.getNomeDaEntidade()));
            }

            if (nonNull(filtros.getNomeDaEntidade())) {
                predicates.add(builder.like(root.get("nomeDaEntidade"), filtros.getNomeDaEntidade()));
            }

            if (nonNull(filtros.getDataCriacaoInicio())) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("dataCriacaoInicio"), filtros.getDataCriacaoInicio()));
            }

            if (nonNull(filtros.getDataCriacaoFim())) {
                predicates.add(builder.lessThanOrEqualTo(root.get("dataCriacaoFim"), filtros.getDataCriacaoFim()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
