/*
 * @fileoverview {ServicioUsuarioImpl} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {ServicioUsuarioImpl} fue realizada el 31/07/2022.
 * @Dev - La primera version de {ServicioUsuarioImpl} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio.implementacion;

import com.rtc.cardinal.definicion.dominio.Usuario;
import com.rtc.cardinal.definicion.repositorio.RepositorioUsuario;
import com.rtc.cardinal.definicion.servicio.ServicioUsuario;
import com.rtc.cardinal.definicion.servicio.dto.UsuarioDTO;
import com.rtc.cardinal.definicion.servicio.implementacion.excepciones.ExcepcionEntidadNoEncontrado;
import com.rtc.cardinal.definicion.servicio.mapeo.MapeoUsuario;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Definición de {@code ServicioUsuarioImpl}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Service
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

    private final Logger log = LoggerFactory.getLogger(ServicioUsuarioImpl.class);

    private final RepositorioUsuario repositorioEntidad;

    private final MapeoUsuario mapeoEntidad = Mappers.getMapper(MapeoUsuario.class);

    /**
     * TODO: Definición de {@code ServicioUsuarioImpl}.
     *
     * @param repositorioEntidad
     */
    public ServicioUsuarioImpl(RepositorioUsuario repositorioEntidad) {
        this.repositorioEntidad = repositorioEntidad;
    }

    /**
     * TODO: Definición de {@code guardarActualizar}.
     *
     */
    @Override
    public UsuarioDTO guardarActualizar(UsuarioDTO entidadDTO) throws Exception {
        log.debug("Solicitud para guardar la entidad : {}", entidadDTO);

        //TODO: agregar validacion especifica del servicio.
        Usuario entidad = mapeoEntidad.obtenerEntidad(entidadDTO);
        entidad = repositorioEntidad.save(entidad);

        UsuarioDTO entidadActual = mapeoEntidad.obtenerDto(entidad);
        return entidadActual;
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     */
    @Override
    public List<UsuarioDTO> obtenerEntidades() throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return mapeoEntidad.obtenerDto(repositorioEntidad.findAll());
    }

    /**
     * TODO: Definición de {@code buscarEntidad}.
     *
     */
    @Override
    public UsuarioDTO buscarEntidad(String id) throws Exception {
        log.debug("Solicitud para buscar la Entidad : {}", id);
        Usuario entidadBuscada = repositorioEntidad.findById(Long.parseLong(id))
                .orElseThrow(() -> new ExcepcionEntidadNoEncontrado(id));
        return mapeoEntidad.obtenerDto(entidadBuscada);
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     * @param strId
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public List<UsuarioDTO> obtenerEntidades(String strId) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return (List<UsuarioDTO>) mapeoEntidad.obtenerDto(repositorioEntidad.findByIntCedulaUsuario(Long.parseLong(strId)));
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     * @param pageable
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public Page<UsuarioDTO> obtenerEntidades(Pageable pageable) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return repositorioEntidad.findAll(pageable).map(mapeoEntidad::obtenerDto);
    }

    /**
     * TODO: Definición de {@code eliminarEntidad}.
     *
     */
    @Override
    public void eliminarEntidad(String id) throws Exception {
        log.debug("Solicitud para eliminar la entidad : {}", id);
        repositorioEntidad.deleteById(Long.parseLong(id));
    }

    /**
     * TODO: Definición de {@code query}.
     *
     * @param query
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Page<UsuarioDTO> query(String query, Pageable pageable) {
        log.debug("Solicitud de búsqueda de una pagina de la entidad para consulta {}", query);
        return repositorioEntidad.buscarEntidades(query, pageable).map(mapeoEntidad::obtenerDto);
    }
}