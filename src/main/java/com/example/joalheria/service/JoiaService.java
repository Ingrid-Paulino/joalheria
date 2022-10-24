package com.example.joalheria.service;

import com.example.joalheria.model.JoiaBD;
import com.example.joalheria.repository.JoiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<JoiaBD> findAll() {
        return repo.findAll();
    }
    @Override
    public Optional<JoiaBD> findByid(long id) {
        return repo.findById(id);
    }

    //@Override
    //public JoiaBD update(JoiaBD joia) {
    //return repo.save(joia);
    //}

    // Ou
    @Override
    public JoiaBD update(JoiaBD joia, long numero_identificacao) {
        List<JoiaBD> existJoia = findAll().stream().filter(j -> j.getIdentificationNumber() == numero_identificacao).collect(Collectors.toList());
        return repo.save(joia);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
