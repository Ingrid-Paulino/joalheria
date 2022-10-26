package com.example.joalheria.service;

import com.example.joalheria.advisor.exception.NotFoundException;
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
        JoiaBD newJoia = repo.save(joia); //save insere e atualiza as coisas no banco
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
    public Optional<JoiaBD> findById(long id) throws NotFoundException {
        List<JoiaBD> existJoia = findAll().stream()
                .filter(j -> j.getIdentificationNumber() == id)
                .collect(Collectors.toList());

        if(existJoia.isEmpty()) {
            throw new NotFoundException("Joia not found!");
        }
        return repo.findById(id);
    }

    //@Override
    //public JoiaBD update(JoiaBD joia) throws NotFoundException {
    //findByid(numero_identificacao);
    //return repo.save(joia);
    //}

    // Ou
    @Override
    public JoiaBD update(JoiaBD joia, long numero_identificacao) throws NotFoundException {
        findByid(numero_identificacao);
        return repo.save(joia);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        findByid(id);
        repo.deleteById(id);
    }
}
