package com.example.Parcial.Service;

import com.example.Parcial.Model.Libro;
import com.example.Parcial.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    public Libro buscarPorId(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro actualizar(Libro libro) {
        return libroRepository.save(libro);
    }

    public boolean eliminar(Integer id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<Libro> obtenerLibrosPorTitulo(String titulo) {
        return libroRepository.findLibrosByTitulo(titulo);
    }
}
