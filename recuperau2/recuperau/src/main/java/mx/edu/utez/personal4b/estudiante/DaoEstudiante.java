package mx.edu.utez.personal4b.estudiante;



import mx.edu.utez.personal4b.materias.BeanMaterias;
import mx.edu.utez.personal4b.model.Repository;
import mx.edu.utez.personal4b.utils.MySQLConnection;
import mx.edu.utez.personal4b.utils.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEstudiante implements Repository<BeanEstudiante> {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanEstudiante> findAll() {
        List<BeanEstudiante> estudiantes = new ArrayList<>();
        BeanEstudiante estudiante = null;
        BeanMaterias materia = null;
        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT es.*,ma.* FROM estudiante es JOIN materias ma ON es.matricula = ma.calificaciones avg(calificaciones)");
            rs = pstm.executeQuery();
            while (rs.next()) {
                estudiante = new BeanEstudiante();
                materia = new BeanMaterias();
                estudiante.setMatricula(rs.getString("matricula"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("Apellido"));
                estudiante.setCurp(rs.getString("CURP"));
                estudiante.setFecha_nacimiento(rs.getDate("fecha de Nacimiento"));
                estudiante.setCalificaciones(rs.getInt("calificaciones"));
                materia.setId(rs.getLong(" ma.id"));
                materia.setNombre(rs.getString("nombre"));
                materia.setCalificaciones(rs.getInt("calificaciones"));
                materia.setProm(rs.getInt("Promedio"));
                estudiante.setMaterias(materia);


                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        } finally {
            client.close(connection, pstm, rs);
        }
        return estudiantes;
    }

    @Override
    public BeanEstudiante findByMatricula(String matricula) {
        BeanEstudiante estudiante = new BeanEstudiante();
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT es.*,ma.* FROM estudiante es JOIN materias ma ON es.matricula = ma.calificacion avg(calificaciones) WHERE es.matricula = ?;");
            pstm.setString(1,matricula);
            rs = pstm.executeQuery();
            while(rs.next()) {
                BeanMaterias materias = new BeanMaterias();
                estudiante = new BeanEstudiante();

                materias = new BeanMaterias();
                estudiante.setMatricula(rs.getString("matricula"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellidos"));
                estudiante.setCurp(rs.getString("curp"));
                estudiante.setFecha_nacimiento(rs.getDate("fecha de nacimiento"));
                estudiante.setCalificaciones(rs.getInt("calificaciones"));
                materias.setId(rs.getLong("ma.id"));
                materias.setNombre(rs.getString("ma.nombre"));
                materias.setCalificaciones(rs.getInt("ma.calificaciones"));
                materias.setProm(rs.getInt("ma.promedio"));
                estudiante.setMaterias(materias);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE,"Error -> findbymatricula"+ e.getMessage());
        }finally{
            client.close(connection,pstm,rs);
        }
        return estudiante;
    }
    @Override
    public Response save(BeanEstudiante estudiante) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("INSERT INTO estudiante (matricula, nombre, apellido, fecha_nacimiento, curp, calificaciones) " +
                    "VALUES (?,?,?,?,?,?,?,?,?);");
            pstm.setString(1,estudiante.getNombre());
            pstm.setString(2,estudiante.getApellido());
            pstm.setDate(3, (Date) estudiante.getFecha_nacimiento());
            pstm.setString(4,estudiante.getCurp());
            pstm.setString(5,estudiante.getMatricula());
            pstm.setInt(6,estudiante.getMaterias().getCalificaciones());
            if(pstm.executeUpdate() == 1){
                return new Response<BeanEstudiante>(200,"Registro exitoso",estudiante,false);
            }else{
                return new Response<BeanEstudiante>(200,"Error de registro. Intente nuevamente",estudiante,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE,"Error -> save"+e.getMessage());
            return new Response<>(400,"Error con el servidor",null,true);

        }finally {
            client.close(connection,pstm,rs);
        }
    }

    @Override
    public Response update(BeanEstudiante estudiante) {

        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("UPDATE estudiante SET nombre = ?, apellido=?, curp=?, fecha_nacimiento=?, calificaciones=? where matricula = ?;");
            pstm.setString(1,estudiante.getNombre());
            pstm.setString(2,estudiante.getApellido());
            pstm.setString(3,estudiante.getCurp());
            pstm.setDate(4,(Date)estudiante.getFecha_nacimiento());
            pstm.setInt(5,estudiante.getMaterias().getCalificaciones());
            pstm.setString(6,estudiante.getMatricula());
            if (pstm.executeUpdate() == 1) {
                return new Response<BeanEstudiante>(200, "Actualizado exitoso", estudiante, false);
            } else {
                return new Response<BeanEstudiante>(200, "Error de actualizado. Intente nuevamente", estudiante, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE,"Error -> update"+ e.getMessage());
            return new Response<BeanEstudiante>(200,"Error con el servidor",estudiante,true);
        }
    }

    @Override
    public Response delete(String matricula) {
        return null;
    }




}



