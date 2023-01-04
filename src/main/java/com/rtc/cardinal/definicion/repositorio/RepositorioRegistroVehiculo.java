/*
 * @fileoverview {RepositorioRegistroVehiculo} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {RepositorioRegistroVehiculo} fue realizada el 31/07/2022.
 * @Dev - La primera version de {RepositorioRegistroVehiculo} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.repositorio;

import com.rtc.cardinal.definicion.dominio.RegistroVehiculo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO: Definición de {@code RepositorioRegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Repository
public interface RepositorioRegistroVehiculo extends JpaRepository<RegistroVehiculo, Long> {

    public List<RegistroVehiculo> findByIntTiqueteNro(Long id);

    @Query("SELECT m FROM RegistroVehiculo m WHERE m.strPlacaVehiculo LIKE CONCAT('%', :strBusqueda, '%') ORDER BY m.dtFechaHoraEstatica desc")
    public List<RegistroVehiculo> buscarRegistroVehiculo(@Param("strBusqueda") String strBusqueda);

    @Query("SELECT m FROM RegistroVehiculo m WHERE m.strPlacaVehiculo LIKE CONCAT('%', :strBusqueda, '%')")
    public Page<RegistroVehiculo> buscarEntidades(@Param("strBusqueda") String strBusqueda, Pageable pageable);
}