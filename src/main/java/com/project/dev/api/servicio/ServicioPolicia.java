/*
 * @fileoverview    {ServicioPolicia}
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

import com.project.dev.api.dto.PoliciaDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Description of {@code ServicioPolicia}.
 *
 * @author Dyson Parra
 * @since 11
 */
public interface ServicioPolicia extends ServicioGenerico<PoliciaDTO> {

    public List<PoliciaDTO> obtenerEntidades(String id) throws Exception;

    public Page<PoliciaDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<PoliciaDTO> query(String query, Pageable pageable);
}
