package com.example.jpaCrud.Controllers;

import com.example.jpaCrud.Models.UsuarioModel;
import com.example.jpaCrud.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel user){
        return usuarioService.guardarUsuario(user);
    }

    @GetMapping(path = "/{id}")
    public Optional obtenerPorId(@PathVariable("id") Long id){
        return usuarioService.findById(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerPorEnabled(@RequestParam("enabled") Integer enabled){
        return usuarioService.buscarPorEnabled(enabled);
    }

    @DeleteMapping( path = "/{id}")
    public void eliminarPorId(@PathVariable("id") Long id){
        usuarioService.eliminarUsuario(id);

    }


}
