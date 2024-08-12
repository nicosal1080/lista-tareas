package com.ListaTareas.listaTareas.domain;

import com.ListaTareas.listaTareas.data.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tareas")
public class TareaControlador {
    private final TareaRepositorio tareaRepositorio;

    @Autowired
    public TareaControlador(TareaRepositorio tareaRepositorio) {
        this.tareaRepositorio = tareaRepositorio;
    }

    @GetMapping
    public List<Tarea> getTareas() {
        List<Tarea> tareas = tareaRepositorio.findAll();
        tareas.sort(Comparator.comparing(Tarea::getId));
        return tareas;
    }

    @GetMapping("/obtener")
    public String verTareas(Model model) {
        return actualizarModeloConTareas(model);
    }

    @PostMapping("/agregar")
    public String agregarTarea(Tarea tarea, Model model) {
        tarea.setEstaCompletada("N");
        this.tareaRepositorio.save(tarea);
        return actualizarModeloConTareas(model);
    }

    @PostMapping("/eliminar")
    public String deleteTarea(@RequestParam Long id, Model model) {
        Optional<Tarea> tareaEncontrada = this.tareaRepositorio.findById(id);
        tareaEncontrada.ifPresent(this.tareaRepositorio::delete);
        return actualizarModeloConTareas(model);
    }

    @PostMapping("/actualizar")
    public String actualizarDescripcion(@RequestParam Long id, @RequestParam String nuevaDescripcion, Model model) {
        Optional<Tarea> tareaEncontrada = this.tareaRepositorio.findById(id);
        tareaEncontrada.ifPresent(tarea -> tarea.setDescripcion(nuevaDescripcion));
        tareaEncontrada.ifPresent(this.tareaRepositorio::save);
        return actualizarModeloConTareas(model);
    }

    @PostMapping("/completar")
    public String marcarComoCompletado(@RequestParam Long id, @RequestParam String estaCompletada, Model model) {
        Optional<Tarea> tareaEncontrada = this.tareaRepositorio.findById(id);
        if(estaCompletada.equalsIgnoreCase( "Y")) {
            tareaEncontrada.ifPresent(value -> value.setEstaCompletada("N"));
        } else if (estaCompletada.equalsIgnoreCase( "N")) {
            tareaEncontrada.ifPresent(value -> value.setEstaCompletada("Y"));
        }

        tareaEncontrada.ifPresent(this.tareaRepositorio::save);
        return actualizarModeloConTareas(model);
    }

    private String actualizarModeloConTareas(Model model) {
        List<Tarea> tareas = tareaRepositorio.findAll();
        tareas.sort(Comparator.comparing(Tarea::getId));
        model.addAttribute("tareas", tareas);
        return "fragmentos/tareas :: listaTareas";
    }


}
