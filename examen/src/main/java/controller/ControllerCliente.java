package controller;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDaoImpI;
import idao.IClienteDao;
import model.Cliente;
import vista.ViewCliente;
public class ControllerCliente {

    private ViewCliente vista= new ViewCliente();

    public ControllerCliente() {
    }

    //llama al DAO para guardar un cliente
    public void registrar(Cliente cliente ) {
        IClienteDao dao= new  ClienteDaoImpI();
        dao.registrar(cliente);
    }

    //llama al DAO para actualizar un cliente
    public void actualizar(Cliente cliente) {
        IClienteDao dao= new  ClienteDaoImpI();
        dao.actualizar(cliente);
    }

    //llama al DAO para eliminar un cliente
    public void eliminar(Cliente cliente) {
        IClienteDao dao= new  ClienteDaoImpI();
        dao.eliminar(cliente);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        IClienteDao dao= new  ClienteDaoImpI();
        clientes=dao.obtener();
        vista.verClientes(clientes);
    }
}
