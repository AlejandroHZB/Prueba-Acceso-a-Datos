package com.example.LigasAPI.service;

import com.example.LigasAPI.model.Liga;

import java.util.List;

public interface LigaService {
    //escribo todos los metodos que quiero llamar desde el controlador
    //logica de negocio
    Liga agregarLiga(Liga liga);
    List<Liga> getAllLigas();
}
