package com.example.LigasAPI.repository;

import com.example.LigasAPI.model.Liga;
import org.springframework.data.jpa.repository.JpaRepository;

//tantos metodos "adicionales" como necesitemos
//lOS METODOS POR DEFECTO ME LOS DA EL JPAREPOSITORY
//logica base de datos
    //persist
    //save
    //merge
    //list
public interface LigaRepository extends JpaRepository<Liga,Integer> {
    Liga findByNombre(String nombre);
}
