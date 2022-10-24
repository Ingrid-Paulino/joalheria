package com.example.joalheria.service;

import com.example.joalheria.model.JoiaBD;
import com.example.joalheria.repository.JoiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JoiaService implements IJoiaService{
    @Autowired
    private JoiaRepo repo;

    @Override
    public JoiaBD insert(JoiaBD joia) {
        JoiaBD newJoia = repo.save(joia);
        return newJoia;
    }

    // Forma 1: Declarando o repositorio(JoiaRepo) com CrudRepository
   // @Override
    //public List<JoiaBD> findAllJoias() {
       // Iterator<JoiaBD> iterator = repo.findAll().iterator();
        //List<JoiaBD> joias = new ArrayList<>();
       // while (iterator.hasNext()){
          //  joias.add(iterator.next());
       // }
        //return joias;
    //}

    // OU

    //Forma 2: Declarando o repositorio(JoiaRepo) com
    @Override
    public List<JoiaBD> findAllJoias() {
        return repo.findAll();
    }
}
