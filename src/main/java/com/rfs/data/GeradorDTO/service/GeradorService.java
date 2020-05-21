package com.rfs.data.GeradorDTO.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class GeradorService {

    public void gerandoDto() {
        System.out.println("********************** INICIOU ***********************");


//        montarNovaClasseDTO(new Cidade());
//        montarNovaClasseDTO(new Cliente());
//        montarNovaClasseDTO(new Concorrente());
//        montarNovaClasseDTO(new CondicaoPagamento());
//        montarNovaClasseDTO(new Contabil());
//        montarNovaClasseDTO(new Contato());
//        montarNovaClasseDTO(new Contrato());
//        montarNovaClasseDTO(new Endereco());
//        montarNovaClasseDTO(new Estado());
//        montarNovaClasseDTO(new FormaPagamento());
//        montarNovaClasseDTO(new Fornecedor());
//        montarNovaClasseDTO(new IndiceEconomico());
//        montarNovaClasseDTO(new Pais());
//        montarNovaClasseDTO(new Regiao());
//        montarNovaClasseDTO(new TipoAtividade());
//        montarNovaClasseDTO(new Veiculo());
//        montarNovaClasseDTO(new Vendedor());

//        System.out.println("********************** DTOS GERADOS ***********************");
//
//        montarNovaInterfaceMapper(new CidadeDTO(),new Cidade());
//        montarNovaInterfaceMapper(new ClienteDTO(),new Cliente());
//        montarNovaInterfaceMapper(new ConcorrenteDTO(),new Concorrente());
//        montarNovaInterfaceMapper(new CondicaoPagamentoDTO(),new CondicaoPagamento());
//        montarNovaInterfaceMapper(new ContabilDTO(),new Contabil());
//        montarNovaInterfaceMapper(new ContatoDTO(),new Contato());
//        montarNovaInterfaceMapper(new ContratoDTO(),new Contrato());
//        montarNovaInterfaceMapper(new EnderecoDTO(),new Endereco());
//        montarNovaInterfaceMapper(new EstadoDTO(),new Estado());
//        montarNovaInterfaceMapper(new FormaPagamentoDTO(),new FormaPagamento());
//        montarNovaInterfaceMapper(new FornecedorDTO(),new Fornecedor());
//        montarNovaInterfaceMapper(new IndiceEconomicoDTO(),new IndiceEconomico());
//        montarNovaInterfaceMapper(new PaisDTO(),new Pais());
//        montarNovaInterfaceMapper(new RegiaoDTO(),new Regiao());
//        montarNovaInterfaceMapper(new TipoAtividadeDTO(),new TipoAtividade());
//        montarNovaInterfaceMapper(new VeiculoDTO(),new Veiculo());
//        montarNovaInterfaceMapper(new VendedorDTO(),new Vendedor());
//
//        montaImplementacaoClasseMapper(new CidadeDTO(),new Cidade());
//        montaImplementacaoClasseMapper(new ClienteDTO(),new Cliente());
//        montaImplementacaoClasseMapper(new ConcorrenteDTO(),new Concorrente());
//        montaImplementacaoClasseMapper(new CondicaoPagamentoDTO(),new CondicaoPagamento());
//        montaImplementacaoClasseMapper(new ContabilDTO(),new Contabil());
//        montaImplementacaoClasseMapper(new ContatoDTO(),new Contato());
//        montaImplementacaoClasseMapper(new ContratoDTO(),new Contrato());
//        montaImplementacaoClasseMapper(new EnderecoDTO(),new Endereco());
//        montaImplementacaoClasseMapper(new EstadoDTO(),new Estado());
//        montaImplementacaoClasseMapper(new FormaPagamentoDTO(),new FormaPagamento());
//        montaImplementacaoClasseMapper(new FornecedorDTO(),new Fornecedor());
//        montaImplementacaoClasseMapper(new IndiceEconomicoDTO(),new IndiceEconomico());
//        montaImplementacaoClasseMapper(new PaisDTO(),new Pais());
//        montaImplementacaoClasseMapper(new RegiaoDTO(),new Regiao());
//        montaImplementacaoClasseMapper(new TipoAtividadeDTO(),new TipoAtividade());
//        montaImplementacaoClasseMapper(new VeiculoDTO(),new Veiculo());
//        montaImplementacaoClasseMapper(new VendedorDTO(),new Vendedor());

    }

    private void montarNovaClasseDTO(Object objeto) {
        Class<?> classe = objeto.getClass();

        String templateImportsAndAnnotations = "import com.rfs.data.GeradorDTO.domain.models.enumeration.*;\n" +
                "import java.io.Serializable;\n" +
                "import java.math.BigDecimal;\n" +
                "import java.time.ZonedDateTime;\n" +
                "import java.util.HashSet;\n" +
                "import java.util.Set;\n" +
                "import java.time.LocalDateTime;\n" +
                "import java.io.Serializable;\n" +
                "import lombok.*;\n" +
                "\n" +
                "@Getter\n" +
                "@Setter\n" +
                "@NoArgsConstructor\n" +
                "@AllArgsConstructor\n" +
                "@EqualsAndHashCode\n" +
                "@ToString\n" +
                "@Builder\n";

        Field[] fields = classe.getDeclaredFields();

        StringBuilder builder = new StringBuilder();
        builder.append("package com.rfs.data.GeradorDTO.domain.dto;\n\n");

        builder.append(templateImportsAndAnnotations);
        builder.append("public class " + classe.getSimpleName() + "DTO implements Serializable {\n");
        builder.append("    private static final long serialVersionUID = 1L;\n");
        for (Field field: fields) {
            if (!field.getName().equals("serialVersionUID")) {
                builder.append("    private " + field.getType().getSimpleName() + " " + field.getName() + "; \n");
            }
        }
        builder.append("}");

        Path path = Paths.get("C:\\Users\\Usuario\\Desktop\\GeradorDTO\\src\\main\\java\\com\\rfs\\data\\GeradorDTO\\domain\\dto\\" + classe.getSimpleName()+"DTO.java");
        try {
            if(!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(builder.toString());
    }

    private void montarNovaInterfaceMapper(Object objetoDto, Object objetoEntity) {
        Class<?> classeDto = objetoDto.getClass();
        Class<?> classEntity = objetoEntity.getClass();

        String template = "package com.rfs.data.GeradorDTO.domain.mapper;\n" +
                
                "import com.rfs.data.GeradorDTO.domain.models.entityClassName;\n" +
                "import com.rfs.data.GeradorDTO.domain.dto.dtoClassName;\n\n" +
                
                "public interface className {\n" +
                "    dtoClassName toDto(entityClassName entityName);\n" +
                                "    entityClassName toEntity(dtoClassName dtoName);\n" +
                                "    default entityClassName fromId(Long id) {\n" +
                "        if (id == null) {\n" +
                "            return null;\n" +
                "        }\n" +
                "        entityClassName entityName = new entityClassName();\n" +
                "        entityName.setId(id);\n" +
                "        return entityName;\n" +
                "    }\n" +
                "}\n";

        String trocaValores = template
                .replace("className", classEntity.getSimpleName() + "Mapper")
                .replace("dtoClassName", classeDto.getSimpleName())
                .replace("dtoName", StringUtils.uncapitalize(classeDto.getSimpleName()))
                .replace("entityClassName", classEntity.getSimpleName())
                .replace("entityName", StringUtils.uncapitalize(classEntity.getSimpleName()));

        System.out.println(trocaValores);

        Path path = Paths.get("C:\\Users\\Usuario\\Desktop\\GeradorDTO\\src\\main\\java\\com\\rfs\\data\\GeradorDTO\\domain\\mapper\\" + classEntity.getSimpleName()+"Mapper.java");
        try {
            if(!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, trocaValores.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void montaImplementacaoClasseMapper(Object objetoDto, Object objetoEntity) {
        String template = "package com.rfs.data.GeradorDTO.domain.mapper.implementation;\n" +
                "\n" +
                "import com.rfs.data.GeradorDTO.domain.dto.classeNameDTO;\n" +
                "import com.rfs.data.GeradorDTO.domain.mapper.classeNameMapper;\n" +
                "import com.rfs.data.GeradorDTO.domain.models.classeName;\n" +
                "\n" +
                "public class classeNameMapperImpl implements classeNameMapper {\n" +
                "    @Override\n" +
                "    public classeNameDTO toDto(classeName parametro) {\n" +
                "        return classeNameDTO.builder()\n" +
                "atributosToDto" +
                "                .build();\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public classeName toEntity(classeNameDTO parametro) {\n" +
                "        return classeName.builder()\n" +
                "atributosToEntity" +
                "                .build();\n" +
                "    }\n" +
                "}";

        Class<?> classeDto = objetoDto.getClass();
        Class<?> classeEntity = objetoEntity.getClass();
        Field[] fieldsDto = classeDto.getDeclaredFields();
        Field[] fieldsEntity = classeEntity.getDeclaredFields();

        String classeName = classeEntity.getSimpleName();
        String classNameUncaptilize = StringUtils.uncapitalize(classeName);

        StringBuilder builderDto = new StringBuilder();

        for (Field field: fieldsDto) {
            if (!field.getName().equals("serialVersionUID")) {
                builderDto.append("                ." + field.getName() + "(" + classNameUncaptilize + ".get" + StringUtils.capitalize(field.getName()) + "())\n");
            }

        }

        StringBuilder builderEntity = new StringBuilder();
        for (Field field: fieldsEntity) {
            if (!field.getName().equals("serialVersionUID")) {
                builderEntity.append("                ." + field.getName() + "(" + classNameUncaptilize + ".get" + StringUtils.capitalize(field.getName()) + "())\n");
            }

        }

        String mapperClass = template
                .replaceAll("parametro", StringUtils.uncapitalize(classeName))
                .replaceAll("classeName", classeName)
                .replaceAll("atributosToDto", builderDto.toString())
                .replaceAll("atributosToEntity", builderEntity.toString());

        System.out.println(mapperClass);

        Path path = Paths.get("C:\\Users\\Usuario\\Desktop\\GeradorDTO\\src\\main\\java\\com\\rfs\\data\\GeradorDTO\\domain\\mapper\\implementation\\" + classeName +"MapperImpl.java");
        try {
            if(!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, mapperClass.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
