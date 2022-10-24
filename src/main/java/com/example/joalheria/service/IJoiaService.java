package com.example.joalheria.service;

import com.example.joalheria.model.JoiaBD;

import java.util.List;
import java.util.Optional;

public interface IJoiaService {
    JoiaBD insert(JoiaBD joia);
    List<JoiaBD> findAll();
    Optional<JoiaBD> findByid(long id);

    //JoiaBD update(JoiaBD joia);
    // ou
    JoiaBD update(JoiaBD joia, long numero_identificacao);

    void delete(long id);



}
