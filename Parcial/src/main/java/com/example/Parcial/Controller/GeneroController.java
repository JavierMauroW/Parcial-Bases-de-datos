package com.example.Parcial.Controller;

import com.example.Parcial.Model.Genero;
import com.example.Parcial.Service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping("/guardar")
    public Genero guardar(@RequestBody Genero genero) {
        return generoService.guardar(genero);
    }

    @GetMapping("/listar")
    public List<Genero> listar() {
        return generoService.listar();
    }

    @GetMapping("/{id}")
    public Genero buscarPorId(@PathVariable Integer id) {
        return generoService.buscarPorId(id);
    }

    @PutMapping("/actualizar")
    public Genero actualizar(@RequestBody Genero genero) {
        return generoService.actualizar(genero);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        generoService.eliminar(id);
    }
}
