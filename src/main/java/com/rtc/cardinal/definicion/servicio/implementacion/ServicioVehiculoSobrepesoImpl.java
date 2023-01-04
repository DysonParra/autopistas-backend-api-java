/*
 * @fileoverview {ServicioVehiculoSobrepesoImpl} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {ServicioVehiculoSobrepesoImpl} fue realizada el 31/07/2022.
 * @Dev - La primera version de {ServicioVehiculoSobrepesoImpl} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio.implementacion;

import com.rtc.cardinal.definicion.dominio.VehiculoSobrepeso;
import com.rtc.cardinal.definicion.repositorio.RepositorioVehiculoSobrepeso;
import com.rtc.cardinal.definicion.servicio.ServicioVehiculoSobrepeso;
import com.rtc.cardinal.definicion.servicio.dto.VehiculoSobrepesoDTO;
import com.rtc.cardinal.definicion.servicio.implementacion.excepciones.ExcepcionEntidadNoEncontrado;
import com.rtc.cardinal.definicion.servicio.mapeo.MapeoVehiculoSobrepeso;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Definición de {@code ServicioVehiculoSobrepesoImpl}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Service
@Transactional
public class ServicioVehiculoSobrepesoImpl implements ServicioVehiculoSobrepeso {

    private final Logger log = LoggerFactory.getLogger(ServicioVehiculoSobrepesoImpl.class);

    private final RepositorioVehiculoSobrepeso repositorioEntidad;

    private final MapeoVehiculoSobrepeso mapeoEntidad = Mappers.getMapper(MapeoVehiculoSobrepeso.class);

    /**
     * TODO: Definición de {@code ServicioVehiculoSobrepesoImpl}.
     *
     * @param repositorioEntidad
     */
    public ServicioVehiculoSobrepesoImpl(RepositorioVehiculoSobrepeso repositorioEntidad) {
        this.repositorioEntidad = repositorioEntidad;
    }

    /**
     * TODO: Definición de {@code guardarActualizar}.
     *
     */
    @Override
    public VehiculoSobrepesoDTO guardarActualizar(VehiculoSobrepesoDTO entidadDTO) throws Exception {
        log.debug("Solicitud para guardar la entidad : {}", entidadDTO);

        //TODO: agregar validacion especifica del servicio.
        VehiculoSobrepeso entidad = mapeoEntidad.obtenerEntidad(entidadDTO);
        entidad = repositorioEntidad.save(entidad);

        VehiculoSobrepesoDTO entidadActual = mapeoEntidad.obtenerDto(entidad);
        return entidadActual;
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     */
    @Override
    public List<VehiculoSobrepesoDTO> obtenerEntidades() throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return mapeoEntidad.obtenerDto(repositorioEntidad.findAll());
    }

    /**
     * TODO: Definición de {@code buscarEntidad}.
     *
     */
    @Override
    public VehiculoSobrepesoDTO buscarEntidad(String id) throws Exception {
        log.debug("Solicitud para buscar la Entidad : {}", id);
        VehiculoSobrepeso entidadBuscada = repositorioEntidad.findById(Long.parseLong(id))
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
    public List<VehiculoSobrepesoDTO> obtenerEntidades(String strId) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return (List<VehiculoSobrepesoDTO>) mapeoEntidad.obtenerDto(repositorioEntidad.findByIntIdRepeso(Long.parseLong(strId)));
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     * @param pageable
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public Page<VehiculoSobrepesoDTO> obtenerEntidades(Pageable pageable) throws Exception {
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
    public Page<VehiculoSobrepesoDTO> query(String query, Pageable pageable) {
        log.debug("Solicitud de búsqueda de una pagina de la entidad para consulta {}", query);
        return repositorioEntidad.buscarEntidades(query, pageable).map(mapeoEntidad::obtenerDto);
    }
}