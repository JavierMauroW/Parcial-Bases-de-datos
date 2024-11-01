package com.example.Parcial.Repository;

import com.example.Parcial.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {


    @Query(value = "SELECT * FROM autor WHERE nacionalidad = :nacionalidad", nativeQuery = true)
    List<Autor> findAutoresByNacionalidad(@Param("nacionalidad") String nacionalidad);
}