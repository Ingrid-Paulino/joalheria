package com.example.joalheria.service;

import com.example.joalheria.advisor.exception.NotFoundException;
import com.example.joalheria.model.JoiaBD;

import java.util.List;
import java.util.Optional;

public interface IJoiaService {
    JoiaBD insert(JoiaBD joia);
    List<JoiaBD> findAll();
    Optional<JoiaBD> findById(long id) throws NotFoundException;

    //JoiaBD update(JoiaBD joia);
    // ou
    JoiaBD update(JoiaBD joia, long numero_identificacao) throws NotFoundException;

    void delete(long id) throws NotFoundException;



}
