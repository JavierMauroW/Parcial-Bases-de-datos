package com.example.Parcial.Service;

import com.example.Parcial.Model.Autor;
import com.example.Parcial.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor actualizar(Autor autor) {
        return autorRepository.save(autor);
    }

    public boolean eliminar(Integer id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<Autor> obtenerAutoresPorNacionalidad(String nacionalidad) {
        return autorRepository.findAutoresByNacionalidad(nacionalidad);
    }
}