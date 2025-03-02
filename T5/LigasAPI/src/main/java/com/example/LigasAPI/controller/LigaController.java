package com.example.LigasAPI.controller;

import com.example.LigasAPI.model.Liga;
import com.example.LigasAPI.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Se utiliza como punto de entrada para als pèticiones rest
@RestController
@RequestMapping("ligas")
public class LigaController {

    //todos los metodos que quiero qeu se ejecuten desde la url
    @Autowired
    private LigaService ligaService;

    @GetMapping("error")
    public String getError(){
        return "Error en la app";
    }

    @PostMapping("add")
    public String addLiga(@RequestBody Liga liga){
        ligaService.agregarLiga(liga);
        return "Liga agragada correctamente" + liga.getNombre();
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Liga>> getLigas(){

        return new ResponseEntity<>(ligaService.getAllLigas(),HttpStatus.OK);
    }


}
