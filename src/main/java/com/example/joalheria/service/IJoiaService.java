package com.example.joalheria.service;

import com.example.joalheria.model.JoiaBD;

import java.util.List;

public interface IJoiaService {
    JoiaBD insert(JoiaBD joia);
    List<JoiaBD> findAllJoias();
}
