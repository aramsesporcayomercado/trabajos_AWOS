package mx.edu.utez.personal4b.controller.estudiante;
import mx.edu.utez.personal4b.estudiante.BeanEstudiante;
import mx.edu.utez.personal4b.estudiante.DaoEstudiante;
import mx.edu.utez.personal4b.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Path("/api/student")
public class studentServices {
        Map<String,Object> response = new HashMap<>();

        @GET
        @Path("/")
        @Produces(value = {"application/json"})
        public List<BeanEstudiante> getAll(){
            return new DaoEstudiante().findAll();
        }

        @POST
        @Path("/")
        @Consumes(value = {"application/json"})
        @Produces(value = {"application/json"})
        public Map<String, Object> save(BeanEstudiante estudiante){
            Response<BeanEstudiante> result = new DaoEstudiante().save(estudiante);
            response.put("result",result);
            return response;
        }
    @GET
    @Path("/{matricula}")
    @Produces(MediaType.APPLICATION_JSON)
    public BeanEstudiante getByMatricula(@PathParam("matricula") String matricula){
        BeanEstudiante estudiante = new BeanEstudiante();
        System.out.println(matricula);
        return new DaoEstudiante().findByMatricula(matricula);
    }
    @PUT
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Map<String, Object> update(BeanEstudiante estudiante){
        Response<BeanEstudiante> result = new DaoEstudiante().update(estudiante);
        response.put("result",result);
        return response;
    }
    @DELETE
    @Path("/{matricula}")
    public Response delete(@PathParam("matricula") String matricula){
        System.out.println(matricula);
        return new DaoEstudiante().delete(matricula);
    }

}
