package com.example.Parcial.Controller;

import com.example.Parcial.Model.Autor;
import com.example.Parcial.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/guardar")
    public ResponseEntity<Autor> guardar(@RequestBody Autor autor) {
        Autor nuevoAutor = autorService.guardar(autor);
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public List<Autor> listar() {
        return autorService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Integer id) {
        Autor autor = autorService.buscarPorId(id);
        if (autor != null) {
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Autor> actualizar(@RequestBody Autor autor) {
        Autor autorActualizado = autorService.actualizar(autor);
        if (autorActualizado != null) {
            return new ResponseEntity<>(autorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        boolean eliminado = autorService.eliminar(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/nacionalidad/{nacionalidad}")
    public ResponseEntity<List<Autor>> obtenerAutoresPorNacionalidad(@PathVariable String nacionalidad) {
        List<Autor> autores = autorService.obtenerAutoresPorNacionalidad(nacionalidad);
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }
}