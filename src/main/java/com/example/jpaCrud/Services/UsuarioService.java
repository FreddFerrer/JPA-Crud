package com.example.jpaCrud.Services;

import com.example.jpaCrud.Models.UsuarioModel;
import com.example.jpaCrud.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel user){
        return usuarioRepository.save(user);
    }

    public Optional findById(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> buscarPorEnabled(Integer enabled){
        return usuarioRepository.findByEnabled(enabled);
    }

    public void eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        } else{
            throw new RuntimeException("Usuario no encontrado");
        }
    }
}
