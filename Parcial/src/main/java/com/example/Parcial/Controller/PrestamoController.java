package com.example.Parcial.Controller;

import com.example.Parcial.Model.Prestamo;
import com.example.Parcial.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/guardar")
    public Prestamo guardar(@RequestBody Prestamo prestamo) {
        return prestamoService.guardar(prestamo);
    }

    @GetMapping("/listar")
    public List<Prestamo> listar() {
        return prestamoService.listar();
    }

    @GetMapping("/{id}")
    public Prestamo buscarPorId(@PathVariable Integer id) {
        return prestamoService.buscarPorId(id);
    }

    @PutMapping("/actualizar")
    public Prestamo actualizar(@RequestBody Prestamo prestamo) {
        return prestamoService.actualizar(prestamo);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        prestamoService.eliminar(id);
    }
}
