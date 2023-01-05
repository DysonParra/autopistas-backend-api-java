/*
 * @fileoverview    {ServicioImplementacionBase} se encarga de realizar tareas específicas.
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
package com.rtc.cardinal.definicion.servicio;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: Definición de {@code ServicioImplementacionBase}.
 *
 * @author Dyson Parra
 * @param <T>
 * @since 1.8
 */
public class ServicioImplementacionBase<T> implements ServicioGenerico<T> {

    private Class<T> type;

    private final Logger log = LoggerFactory.getLogger(type);

    /**
     * TODO: Definición de {@code ServicioImplementacionBase}.
     *
     */
    public ServicioImplementacionBase() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    /**
     * TODO: Definición de {@code guardarActualizar}.
     *
     */
    @Override
    public T guardarActualizar(T entidadDTO) throws Exception {
        return null;
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     */
    @Override
    public List<T> obtenerEntidades() throws Exception {
        return null;
    }

    /**
     * TODO: Definición de {@code buscarEntidad}.
     *
     */
    @Override
    public T buscarEntidad(String id) throws Exception {
        return null;
    }

    /**
     * TODO: Definición de {@code eliminarEntidad}.
     *
     */
    @Override
    public void eliminarEntidad(String id) throws Exception {

    }
}
