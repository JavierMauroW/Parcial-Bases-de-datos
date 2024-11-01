package com.example.Parcial.Repository;

import com.example.Parcial.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {


    @Query(value = "SELECT * FROM libro WHERE titulo LIKE %:titulo%", nativeQuery = true)
    List<Libro> findLibrosByTitulo(@Param("titulo") String titulo);
}