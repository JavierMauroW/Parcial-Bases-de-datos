package com.example.Parcial.Service;

import com.example.Parcial.Model.Cliente;
import com.example.Parcial.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }


    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }


    public Cliente actualizar(Cliente cliente) {
        if (cliente.getId() != null && clienteRepository.existsById(cliente.getId())) {
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + cliente.getId());
        }
    }


    public void eliminar(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }
}
