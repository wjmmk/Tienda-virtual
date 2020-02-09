package carritojsp;

/**
 * Version: 1.0
 * Fecha: 09/02/2020
 * @author: Wiliam Mosquera 
 */

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Producto;
import junit.framework.Assert;

import models.ModeloProducto;

public class ModeloProductoTest {

	@Test
	public void getAllProductosTest() {

		//Arrange
        ModeloProducto mp = new ModeloProducto();
        boolean exito = true;
        //Act
        try {
        	mp.getAllProductos();        	
        }catch(Exception e) {
        	exito = false;
        }
        //Assert
		Assert.assertTrue(exito);
	}

	@Test
	public void getProductoCasoExitoTest() {

		//Arrange
        ModeloProducto mp = new ModeloProducto();
        boolean exito = true;
        int id = 4;
        //Act
        try {
        	mp.getProducto(id);      	
        }catch(Exception e) {
        	exito = false;
        }
        //Assert
		Assert.assertTrue(exito);
	}	

	@Test
	public void getProductoCasoCeroTest() {

		//Arrange
        ModeloProducto mp = new ModeloProducto();
        boolean exito = true;
        int id = 0;
        //Act
        try {
        	mp.getProducto(id);      	
        }catch(Exception e) {
        	exito = false;
        }
        //Assert
		Assert.assertTrue(exito);
	}	
	
}
