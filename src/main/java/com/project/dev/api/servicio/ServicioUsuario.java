/*
 * @fileoverview    {ServicioUsuario}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.api.servicio;

import com.project.dev.api.dto.UsuarioDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Description of {@code ServicioUsuario}.
 *
 * @author Dyson Parra
 * @since 11
 */
public interface ServicioUsuario extends ServicioGenerico<UsuarioDTO> {

    public List<UsuarioDTO> obtenerEntidades(String id) throws Exception;

    public Page<UsuarioDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<UsuarioDTO> query(String query, Pageable pageable);
}
