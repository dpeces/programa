DROP DATABASE IF EXISTS ibm;
CREATE DATABASE ibm;


CREATE TABLE ibm.proveedores (
  id_proveedor int NOT NULL AUTO_INCREMENT,
  nombre tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  fecha_de_alta date NOT NULL,
  id_cliente int NOT NULL,
  PRIMARY KEY (id_proveedor)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



insert into ibm.proveedores (id_proveedor, nombre, fecha_de_alta, id_cliente)
values (1, "Coca-Cola", '2000-01-01', 5);
insert into ibm.proveedores (id_proveedor, nombre, fecha_de_alta, id_cliente)
values (2, "Pepsi", '2000-02-01', 5);
insert into ibm.proveedores (id_proveedor, nombre, fecha_de_alta, id_cliente)
values (3, "RedBull", '2000-01-15', 6);