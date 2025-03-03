package com.example.LigasAPI.controller;

import com.example.LigasAPI.model.Usuario;
import com.example.LigasAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/error")
    public String getError(){
        return "Error en la conexion";
    }
    @PostMapping("/add")
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.insertarUsuario(usuario), HttpStatus.OK);
    }
    @GetMapping("/getMail")
    public ResponseEntity<List<Usuario>> getUserMail(@RequestParam String correo){
        return new ResponseEntity<>(usuarioService.getUsuarioCorreo(correo),HttpStatus.OK);
    }

}
