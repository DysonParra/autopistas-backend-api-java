/*
 * @fileoverview {Badge} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {Badge} fue realizada el 31/07/2022.
 * @Dev - La primera version de {Badge} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Definición de {@code Badge}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Entity
//@Table(name = "Badge", schema = "cardinal", catalog = "cardinal")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Badge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String strTitle;
    @Column(length = 250)
    private String strClasses;

}
