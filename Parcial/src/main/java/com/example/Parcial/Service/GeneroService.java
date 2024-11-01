package com.example.Parcial.Service;

import com.example.Parcial.Model.Genero;
import com.example.Parcial.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;


    public Genero guardar(Genero genero) {
        return generoRepository.save(genero);
    }


    public List<Genero> listar() {
        return generoRepository.findAll();
    }


    public Genero buscarPorId(Integer id) {
        return generoRepository.findById(id).orElse(null);
    }


    public Genero actualizar(Genero genero) {
        if (genero.getId() != null && generoRepository.existsById(genero.getId())) {
            return generoRepository.save(genero);
        } else {
            throw new RuntimeException("Género no encontrado con ID: " + genero.getId());
        }
    }


    public void eliminar(Integer id) {
        if (generoRepository.existsById(id)) {
            generoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Género no encontrado con ID: " + id);
        }
    }
}
