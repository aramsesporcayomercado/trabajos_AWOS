package mx.edu.utez.personal4b.model;

import mx.edu.utez.personal4b.docente.BeanDocente;
import mx.edu.utez.personal4b.utils.Response;

import java.util.List;

public interface Repository2 <T> {
    List<T> findAll();
    BeanDocente findByID(long id);

    Response saveDocente(T object);

    Response updateDocente(T object);

    Response deleteDocente(long id);

}
