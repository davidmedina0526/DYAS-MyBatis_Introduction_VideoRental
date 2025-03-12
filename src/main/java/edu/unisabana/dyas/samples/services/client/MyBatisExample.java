/*
 * Copyright (C) 2015 cesarvefe
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.unisabana.dyas.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.unisabana.dyas.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.unisabana.dyas.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.unisabana.dyas.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.unisabana.dyas.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.unisabana.dyas.samples.entities.Item;
import edu.unisabana.dyas.samples.entities.TipoItem;

/**
 *
 * @author cesarvefe
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        //Crear el mapper y usarlo:
        try (SqlSession sqlss = sessionfact.openSession()) {

            ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
            ItemMapper im=sqlss.getMapper(ItemMapper.class);
            ItemRentadoMapper irm=sqlss.getMapper(ItemRentadoMapper.class);
            TipoItemMapper tim=sqlss.getMapper(TipoItemMapper.class);
           
            //Consultar todos los clientes
            System.out.println("Consultando todos los clientes");
            System.out.println(cm.consultarClientes());

            //Consultar cliente por id
            System.out.println("Consultando cliente con id: 123456789");
            System.out.println(cm.consultarCliente(123456789));

            //Agregar item rentado a un cliente
            System.out.println("Consultando cliente con id: 555555555");
            System.out.println(cm.consultarCliente(555555555));

            System.out.println("Insertando item rentado");
            irm.agregarItemRentadoACliente(555555555, 3, "2025-03-11", "2025-03-12");

            System.out.println("Cliente con id: 555555555 actualizado");
            System.out.println(cm.consultarCliente(555555555));

            //Agregar un item
            TipoItem tipo = new TipoItem(1, "Película"); 
            Item newItem = new Item(
                tipo,                  // TipoItem
                999,                   // id
                "Mi Nueva Película",   // nombre
                "Descripción breve",   // descripción
                "2025-03-10",          // fechaLanzamiento (String)
                5000,                  // tarifaxDia
                "Blu-Ray",             // formatoRenta
                "Acción"               // género
            );

            System.out.println("Insertando item con id: 999");
            im.insertarItem(newItem);
            System.out.println("Item con id: 999 insertado");
            System.out.println(im.consultarItem(999));
            System.out.println("Consultando todos los items");
            System.out.println(im.consultarItems());

            //Consultar item por id e items
            System.out.println("Consultando items");
            System.out.println(im.consultarItems());
            System.out.println("Consultando item con id: 1");
            System.out.println(im.consultarItem(1));
            
            sqlss.commit();
        }

        
    }


}
