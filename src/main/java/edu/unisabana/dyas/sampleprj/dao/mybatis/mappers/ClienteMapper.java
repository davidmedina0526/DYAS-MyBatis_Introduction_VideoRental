package edu.unisabana.dyas.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.unisabana.dyas.samples.entities.Cliente;

public interface ClienteMapper {
    
    // Consultar un cliente por id (usamos 'idcli' para referirnos al documento)
    public Cliente consultarCliente(@Param("idcli") int id);
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado con 'idcli'
     * y relacionado con el item identificado con 'idit'
     * @param idcli
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idcli") int id, 
                                           @Param("idit") int idit, 
                                           @Param("fechainicio") java.util.Date fechainicio,
                                           @Param("fechafin") java.util.Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
}