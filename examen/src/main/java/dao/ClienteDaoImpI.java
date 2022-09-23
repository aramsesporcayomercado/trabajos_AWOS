package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.Conexion;
import idao.IClienteDao;
import model.Cliente;
public class ClienteDaoImpI implements IClienteDao {


    @Override
    public boolean registrar(Cliente cliente) {
        boolean registrar = false;
        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO cliente values (NULL,'"+cliente.getnombre()+"','"+cliente.getApaterno()+"','"
                +cliente.getAmaterno()+"','"+cliente.getCurp()+"','"+cliente.getFec_nac()+"')";

        try {
            con=Conexion.conectar();
            stm= con.createStatement();
            stm.execute(sql);
            registrar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Cliente> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM CLIENTE ORDER BY ID";

        List<Cliente> listaCliente= new ArrayList<Cliente>();

        try {
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Cliente c=new Cliente("1717213183", "Elivar", "Largo");
                c.setId(rs.getInt(1));
                c.setnombre(rs.getString(2));
                c.setApaterno(rs.getString(3));
                c.setAmaterno(rs.getString(4));
                c.setCurp(rs.getString(5));
                c.setFec_nac(rs.getString(6));
                listaCliente.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }

        return listaCliente;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE CLIENTE SET nombre='"+cliente.getnombre()+"', Apaterno='"+cliente.getApaterno()+"'," +
                " Amaterno='"+cliente.getAmaterno()+ " curp='"+cliente.getCurp()+ " fec_nac='"+cliente.getFec_nac()+"'" +" WHERE ID="+cliente.getid();
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }
    @Override
    public boolean eliminar(Cliente cliente) {
        return false;
    }
    Connection connect= null;
    Statement stm= null;

    boolean eliminar=false;

    String sql="DELETE FROM CLIENTE WHERE ID="+ Cliente.getid();




}
