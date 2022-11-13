package mx.edu.utez.personal4b.model;


import mx.edu.utez.personal4b.docente.BeanDocente;
import mx.edu.utez.personal4b.estudiante.BeanEstudiante;
import mx.edu.utez.personal4b.utils.Response;

import java.util.List;

public interface Repository <T>{
    List<T> findAll();

    BeanEstudiante findByMatricula(String matricula);
    Response save(T object);
    Response update(T object);

    Response delete(String matricula);









}
