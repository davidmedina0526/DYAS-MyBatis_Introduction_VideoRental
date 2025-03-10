select
      c.nombre as c_nombre,
      c.documento as c_documento,
      c.telefono as c_telefono,
      c.direccion as c_direccion,
      c.email as c_email,
      c.vetado as c_vetado,
      ir.CLIENTES_documento as ir_clientes_documento,
      ir.ITEMS_id as ir_items_id,
      ir.fechainiciorenta as ir_fechainiciorenta,
      ir.fechafinrenta as ir_fechafinrenta,
      i.id as i_id,
      i.nombre as i_nombre,
      i.descripcion as i_descripcion,
      i.fechalanzamiento as i_fechalanzamiento,
      i.tarifaxdia as i_tarifaxdia,
      i.formatorenta as i_formatorenta,
      i.genero as i_genero,
      i.TIPOITEM_id as i_tipoitem_id,
      ti.id as ti_id,
      ti.descripcion as ti_descripcion
      FROM VI_CLIENTES as c 
      left join VI_ITEMRENTADO as ir on c.documento=ir.CLIENTES_documento 
      left join VI_ITEMS as i on ir.ITEMS_id=i.id 
      left join VI_TIPOITEM as ti on i.TIPOITEM_id=ti.id;