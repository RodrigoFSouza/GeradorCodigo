package com.rfs.data.GeradorDTO.service.builders;

import com.rfs.data.GeradorDTO.service.Atributo;
import com.rfs.data.GeradorDTO.service.ClasseEntity;
import com.rfs.data.GeradorDTO.transpiler.EntityTranspiler;

import java.util.Set;

public interface EntityBuilder {
    EntityBuilder nomeDaEntity(String nomeDaEntity);
    EntityBuilder nomeDaTabela(String nomeDaTabela);
    EntityBuilder nomeDoPacote(String nomeDoPacote);
    EntityBuilder anotationsDaClasse(Set<String> anotationsDaClasse);
    EntityBuilder imports(Set<String> imports);
    EntityBuilder atributosDaClasse(Set<Atributo> atributos);
    EntityBuilder adicionaGetAndSetters();
    EntityBuilder adicionaEqualsAndHashCode(EntityTranspiler transpiler);
    EntityBuilder adicionaConstructor(EntityTranspiler transpiler);
    EntityBuilder adicionaToString(EntityTranspiler transpiler);
    EntityBuilder adicionaMergeForUpdate(EntityTranspiler transpiler);
    ClasseEntity build();
}
