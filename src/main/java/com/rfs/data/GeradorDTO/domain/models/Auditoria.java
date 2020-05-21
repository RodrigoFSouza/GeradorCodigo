package com.rfs.data.GeradorDTO.domain.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Embeddable
public class Auditoria implements Serializable {

    @Column(name = "NM_USUINC")
    private String usuarioInclusao;

    @Column(name = "NM_USUALT")
    private String usuarioAlteracao;

    @Column(name = "DT_USUINC")
    private LocalDateTime dataInclusao;

    @Column(name = "DT_USUALT")
    private LocalDateTime dataAlteracao;

}
