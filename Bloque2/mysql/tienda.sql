drop database tienda;
create database if not exists tienda;
use tienda;

create table cliente(
	id_cliente int auto_increment primary key,
    nombre varchar(30) not null,
    direccion varchar(50) not null,
    ciudad varchar(30) not null,
    email varchar(30)
);

create table producto(
	id_producto int auto_increment primary key,
    nombre varchar(60) not null,
    categoria varchar(30),
    marca varchar(30) not null,
    precio decimal(8,2) not null,
    stock int default 0
);

create table proveedor(
	id_proveedor int auto_increment primary key,
    nombre varchar(50) not null,
    ciudad varchar(50) not null,
    telefono varchar(15)
);

create table compra(
	id_compra int auto_increment primary key,
    id_proveedor int not null,
    id_producto int not null,
    fecha date not null,
    cantidad int not null,
    coste decimal(8,2) not null,
    foreign key (id_proveedor) references proveedor(id_proveedor),
    foreign key (id_producto) references producto(id_producto)
);

create table venta(
	id_venta int auto_increment primary key,
    id_producto int not null,
    id_cliente int not null,
    fecha date not null,
    cantidad int not null,
    foreign key (id_producto) references producto(id_producto),
    foreign key (id_cliente) references cliente(id_cliente)
);

/*comprobacion de que se han creado*/
show tables;
describe cliente;
describe proveedor;
describe producto;

/*modificar la tabla*/
alter table cliente add column telefono varchar(9);
alter table cliente rename column telefono to movil;
alter table cliente modify column movil varchar(15);
alter table cliente drop column movil;

/*insertar datos*/
insert into cliente(nombre, direccion, ciudad, email) values
	('Juan Lopez', 'C/Andalucia nº2', 'Badajoz', 'juan.lopez@davante.org');
    
insert into proveedor(nombre, ciudad, telefono) values
	('HP', 'Madrid', '951000001'),
    ('Lenovo', 'Barcelona', '934000002'),
    ('Logitech','Valencia','963000003'),
    ('TechMayorista', 'Malaga', '952000004');
    
insert into producto(nombre, categoria, marca, precio, stock) values
	('Portatil HP 15', 'Portatiles', 'HP', 549.00, 15),
    ('Portatil Lenovo Ideapad', 'Portatiles', 'Lenovo', 479.00, 20);
    
insert into venta(id_producto, id_cliente, fecha, cantidad) values
	(1, 1, '2026-09-01', 1),
    (2, 1, '2026-09-01', 1);



















