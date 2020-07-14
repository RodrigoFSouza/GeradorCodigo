package com.rfs.data.GeradorDTO.service.builders;

import com.rfs.data.GeradorDTO.domain.model.Atributo;
import com.rfs.data.GeradorDTO.domain.model.Entidade;
import com.rfs.data.GeradorDTO.service.ClasseEntity;

import java.util.Set;

public interface EntityBuilder {
    EntityBuilder nomeDaEntity(String nomeDaEntity);
    EntityBuilder nomeDaTabela(String nomeDaTabela);
    EntityBuilder nomeDoPacote(String nomeDoPacote);
    EntityBuilder anotationsDaClasse(Set<String> anotationsDaClasse);
    EntityBuilder imports(Set<String> imports);
    EntityBuilder atributosDaClasse(Set<Atributo> atributos);
    EntityBuilder adicionaGetAndSetters();
    EntityBuilder adicionaEqualsAndHashCode(Entidade transpiler);
    EntityBuilder adicionaConstructor(Entidade transpiler);
    EntityBuilder adicionaToString(Entidade transpiler);
    EntityBuilder adicionaMergeForUpdate(Entidade transpiler);

    ClasseEntity build();
}
