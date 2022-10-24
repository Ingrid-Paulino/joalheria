package com.example.joalheria.service;

import com.example.joalheria.model.JoiaBD;

import java.util.List;
import java.util.Optional;

public interface IJoiaService {
    JoiaBD insert(JoiaBD joia);
    List<JoiaBD> findAll();
    void delete(long id);
    Optional<JoiaBD> findByid(long id);
}
