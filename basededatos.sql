create database carritojsp;

use carritojsp;

create table productos(
	id_producto int primary key auto_increment,
	nombre varchar(255) not null,
	img_producto varchar(255) not null,
	id_categoria int not null,
	precio float not null,
	stock int not null
);

DELIMITER //
	CREATE PROCEDURE selectProductos()
	BEGIN
		SELECT * FROM productos;
	END	
//

DELIMITER //
	CREATE PROCEDURE selectProducto(
		IN _id_producto int
	)
	BEGIN
		SELECT * FROM productos WHERE id_producto = _id_producto;
	END	
//

insert into productos(nombre, img_producto, id_categoria, precio, stock) values('Camisa Manga Larga', 'images/home/gallery2.jpg', 2, 39.99, 10); 
insert into productos(nombre, img_producto, id_categoria, precio, stock) values('Vestido negro', 'images/home/product3.jpg', 2, 19.99, 20);
insert into productos(nombre, img_producto, id_categoria, precio, stock) values('Sueter azul', 'images/home/product5.jpg', 2, 29.99, 20);
insert into productos(nombre, img_producto, id_categoria, precio, stock) values('Camiseta blanca', 'images/home/product6.jpg', 2, 13.99, 15);
