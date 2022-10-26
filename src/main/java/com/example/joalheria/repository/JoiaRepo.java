package com.example.joalheria.repository;

import com.example.joalheria.model.JoiaBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// public interface JoiaRepo extends CrudRepository<JoiaBD, Long> {}
// Ou
public interface JoiaRepo extends JpaRepository<JoiaBD, Long> {
}