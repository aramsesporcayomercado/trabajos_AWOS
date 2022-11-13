package mx.edu.utez.personal4b.controller.docente;

import mx.edu.utez.personal4b.docente.BeanDocente;
import mx.edu.utez.personal4b.docente.DaoDocente;
import mx.edu.utez.personal4b.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Path("/api/Professor")
public class ProfessorServices {

    Map<String,Object> response = new HashMap<>();
    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanDocente> getAll(){
        return new DaoDocente().findAll();
    }

    @POST
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Map<String, Object> save(BeanDocente docente){
        Response<BeanDocente> result = new DaoDocente().saveDocente(docente);
        response.put("result",result);
        return response;
    }
    @GET
    @Path("/{matricula}")
    @Produces(MediaType.APPLICATION_JSON)
    public BeanDocente getByID(@PathParam("id") int id){
        BeanDocente docente = new BeanDocente();
        System.out.println(id);
        return new DaoDocente().findByID(id);
    }
    @PUT
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Map<String, Object> update(BeanDocente docente){
        Response<BeanDocente> result = new DaoDocente().updateDocente(docente);
        response.put("result",result);
        return response;
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){
        System.out.println(id);
        return new DaoDocente().deleteDocente(id);
    }

}
