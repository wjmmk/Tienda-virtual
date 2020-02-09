
package controllers;

/**
 * Version: 1.0
 * Fecha: 09/02/2020
 * @author: Wiliam Mosquera 
 */

import classes.Producto;
import models.ModeloProducto;

/**
 *
 * @author William Mosquera 
 */
public class ControladorProducto {
    public String getProductos(){
        ModeloProducto mp = new ModeloProducto();
        StringBuilder htmlcode = new StringBuilder();
        for(Producto producto : mp.getAllProductos()){
        	htmlcode.append("<div class=\"col-sm-4\">\n" +
"							<div class=\"product-image-wrapper\">\n" +
"								<div class=\"single-products\">\n" +
"									<div class=\"productinfo text-center\">\n" +
"										<img src=\""+producto.getImg()+"\" alt=\"\" />\n" +
"										<h2>$"+producto.getPrecio()+"</h2>\n" +
"										<p>"+producto.getNombre()+"</p>\n" +
"										<a href=\"product-details.jsp?id="+producto.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver detalles</a>\n" +
"									</div>\n" +                                                            
"								</div>\n" +
"								<div class=\"choose\">\n" +
"									<ul class=\"nav nav-pills nav-justified\">\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to wishlist</a></li>\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to compare</a></li>\n" +
"									</ul>\n" +
"								</div>\n" +
"							</div>\n" +
"						</div>");
        
       }
        
      return htmlcode.toString();  
    }
    
    public Producto getProducto(int id){
        return new ModeloProducto().getProducto(id);
    }
}
