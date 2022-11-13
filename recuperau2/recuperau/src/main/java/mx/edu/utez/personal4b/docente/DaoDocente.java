package mx.edu.utez.personal4b.docente;


import mx.edu.utez.personal4b.estudiante.BeanEstudiante;
import mx.edu.utez.personal4b.estudiante.DaoEstudiante;
import mx.edu.utez.personal4b.model.Repository2;
import mx.edu.utez.personal4b.utils.MySQLConnection;
import mx.edu.utez.personal4b.utils.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoDocente  implements Repository2<BeanDocente> {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanDocente> findAll() {

        List<BeanDocente> docentes = new ArrayList<>();
        BeanDocente docente = null;
        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM docentes ");
            rs = pstm.executeQuery();
            while (rs.next()) {
                docente = new BeanDocente();
                docente.setId(rs.getLong("id"));
                docente.setNombre(rs.getString("nombre"));
                docente.setApellido(rs.getString("Apellido"));
                docente.setCurp(rs.getString("CURP"));
                docente.setFecha_nacimiento(rs.getDate("fecha de Nacimiento"));
                docentes.add(docente);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        } finally {
            client.close(connection, pstm, rs);
        }
        return docentes;
    }

    @Override
    public BeanDocente findByID(long id) {
        BeanDocente docente = new BeanDocente();
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM docentes  WHERE id = ?;");
            pstm.setLong(1,id);
            rs = pstm.executeQuery();
            while(rs.next()) {

                docente = new BeanDocente();
                docente.setId(rs.getLong("id"));
                docente.setNombre(rs.getString("nombre"));
                docente.setApellido(rs.getString("apellidos"));
                docente.setCurp(rs.getString("curp"));
                docente.setFecha_nacimiento(rs.getDate("fecha de nacimiento"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE,"Error -> findbyID"+ e.getMessage());
        }finally{
            client.close(connection,pstm,rs);
        }
        return docente;
    }

    @Override
    public Response saveDocente(BeanDocente docente) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("INSERT INTO docentes (id, nombre, apellido, fecha_nacimiento, curp) " +
                    "VALUES (?,?,?,?,?,?,?,?,?);");
            pstm.setString(1,docente.getNombre());
            pstm.setString(2,docente.getApellido());
            pstm.setDate(3, (Date) docente.getFecha_nacimiento());
            pstm.setString(4,docente.getCurp());
            if(pstm.executeUpdate() == 1){
                return new Response<BeanDocente>(200,"Registro exitoso",docente,false);
            }else{
                return new Response<BeanDocente>(200,"Error de registro. Intente nuevamente",docente,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> save"+e.getMessage());
            return new Response<>(400,"Error con el servidor",null,true);

        }finally {
            client.close(connection,pstm,rs);
        }
    }

    @Override
    public Response updateDocente(BeanDocente docente) {
        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("UPDATE docentes SET nombre = ?, apellido=?, curp=?, fecha_nacimiento=? where id = ?;");
            pstm.setString(1,docente.getNombre());
            pstm.setString(2,docente.getApellido());
            pstm.setString(3,docente.getCurp());
            pstm.setDate(4,(Date)docente.getFecha_nacimiento());
            pstm.setLong(5,docente.getId());
            if (pstm.executeUpdate() == 1) {
                return new Response<BeanDocente>(200, "Actualizado exitoso", docente, false);
            } else {
                return new Response<BeanDocente>(200, "Error de actualizado. Intente nuevamente",docente, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE,"Error -> update"+ e.getMessage());
            return new Response<BeanDocente>(200,"Error con el servidor",docente,true);
        }
    }

    @Override
    public Response deleteDocente(long id) {
        return null;
    }


}
