package edu.unisabana.dyas.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.unisabana.dyas.samples.entities.ItemRentado;

public interface ItemRentadoMapper {
    
    public List<ItemRentado> consultarItemRentado();
    
    public ItemRentado consultarItemRentado(@Param("id") int id);
    
    public void insertarItemRentado(@Param("itemRentado") ItemRentado itemRentado);
}
