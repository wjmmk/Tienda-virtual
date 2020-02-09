
package models;

/**
 * Version: 1.0
 * Fecha: 09/02/2020
 * @author: Wiliam Mosquera 
 */

import classes.Producto;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author pc
 */
public class ModeloProducto extends Conexion{
    
	private static final Logger LOGGER = Logger.getLogger(ModeloProducto.class);
	private static final String MSG_ERROR = "Error de conexion"; 
	
    public List<Producto> getAllProductos(){
       
    	List<Producto> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
       
        try {
            pst = getSelectProductoSinParametro("call selectProductos()");
            rs = pst.executeQuery();
            while (rs.next()) {
                productos.add(new Producto(rs.getInt("id_producto"), rs.getString("nombre"), 
                        rs.getString("img_producto"), rs.getInt("id_categoria"), rs.getDouble("precio"), rs.getInt("stock")));
                
            }
        } catch (SQLException e) {
        	LOGGER.log(Level.ERROR, MSG_ERROR);
        } finally{
            
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (SQLException e) {
            	LOGGER.log(Level.ERROR, MSG_ERROR);
            }
        }
        return productos;
    }


    
    public Producto getProducto(int id) {
        
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getSelectProducto("call selectProducto(?)");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                producto = new Producto(rs.getInt("id_producto"), rs.getString("nombre"), 
                        rs.getString("img_producto"), rs.getInt("id_categoria"), rs.getDouble("precio"), rs.getInt("stock"));
                
            }
        } catch (Exception e) {
        	LOGGER.log(Level.ERROR, MSG_ERROR);
        } finally{
            
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (Exception e) {
            	LOGGER.log(Level.ERROR, MSG_ERROR);
            }
        }
        return producto; 
    }
    
    public static void main(String args[]){
        ModeloProducto mp = new ModeloProducto();
        for(Producto p : mp.getAllProductos()){
            System.out.println(p.getNombre());
        }
    }
    
	private PreparedStatement getSelectProductoSinParametro(String sql) throws SQLException {
		return getConnection().prepareCall(sql);
	}    
    
    private PreparedStatement getSelectProducto(String sql) throws SQLException {
    	return getSelectProductoSinParametro(sql);
    }
    
}
