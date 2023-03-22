/*
 * @fileoverview    {ServicioMenu}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementación realizada.
 * @version 2.0     Documentación agregada.
 */
package com.project.dev.api.servicio;

import com.project.dev.api.dto.MenuDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioMenu}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public interface ServicioMenu extends ServicioGenerico<MenuDTO> {

    public List<MenuDTO> obtenerEntidades(String id) throws Exception;

    public Page<MenuDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<MenuDTO> query(String query, Pageable pageable);
}
