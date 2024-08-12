package com.ListaTareas.listaTareas.data;

import com.ListaTareas.listaTareas.domain.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Long> {

}
