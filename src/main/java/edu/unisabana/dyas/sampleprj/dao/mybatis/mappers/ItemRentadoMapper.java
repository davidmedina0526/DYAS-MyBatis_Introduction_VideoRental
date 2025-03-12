package edu.unisabana.dyas.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.unisabana.dyas.samples.entities.ItemRentado;

public interface ItemRentadoMapper {
    
    public List<ItemRentado> consultarItemRentado();
    
    public void agregarItemRentadoACliente(@Param("idcli")int id, 
    @Param("idit")int idit, 
    @Param("fechainicio")String fechainicio,
    @Param("fechafin")String fechafin);
    
    public void insertarItemRentado(@Param("itemRentado") ItemRentado itemRentado);
}