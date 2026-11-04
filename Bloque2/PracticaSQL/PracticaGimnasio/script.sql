-- Pulsa «Iniciar servidor», arriba, y después «Ejecutar» (Ctrl+Intro).
-- Si seleccionas un trozo, se ejecuta solo ese trozo.

-- Crear base de datos y usarla
DROP DATABASE IF EXISTS gimnasio;
CREATE DATABASE IF NOT EXISTS gimnasio;
USE gimnasio;

-- Crear tablas

CREATE TABLE monitor(
    id_monitor int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(20) not null,
    telefono varchar(15) not null
);

CREATE TABLE actividad(
    id_actividad int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(30) not null,
    precio DECIMAL(6, 2) not null,
    plazas int not null,
    id_monitor int not null,
    FOREIGN KEY(id_monitor) REFERENCES monitor(id_monitor)
);

CREATE TABLE socio(
    id_socio int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(15) not null,
    ciudad varchar(30) not null,
    email varchar(50)
);

CREATE TABLE inscripcion(
    id_inscripcion int AUTO_INCREMENT PRIMARY KEY,
    id_socio int,
    id_actividad int,
    fecha DATE,
    FOREIGN KEY(id_socio) REFERENCES socio(id_socio),
    FOREIGN KEY(id_actividad) REFERENCES actividad(id_actividad)
);

-- Modificar la estructura

ALTER TABLE socio ADD telefono varchar(9);
ALTER TABLE socio MODIFY telefono varchar(15);
ALTER TABLE socio drop telefono;


-- insertar datos
INSERT INTO socio (id_socio, nombre, ciudad, email) VALUES (1, 'Jose Antonio', 'Malaga', 'jalcalahinojosa@gmail.com');

INSERT INTO monitor (id_monitor, nombre, telefono) VALUES
 (1, 'Laura Vidal',  '611111111'),
 (2, 'Pablo Ortega', '622222222'),
 (3, 'Marta Rey',    '633333333');

INSERT INTO socio (id_socio, nombre, ciudad, email) VALUES
 (2, 'Berto Ruiz',   'Sevilla',  'berto@mail.com'),
 (3, 'Carla Gil',    'Malaga',   NULL),
 (4, 'David Sanz',   'Granada',  'david@mail.com'),
 (5, 'Elena Mora',   'Sevilla',  'elena@mail.com'),
 (6, 'Alberto Vega', 'Cordoba',  NULL);

INSERT INTO actividad (id_actividad, nombre, precio, plazas, id_monitor) VALUES
 (1, 'Yoga',     15.00, 12, 1),
 (2, 'Spinning', 20.00, 15, 2),
 (3, 'Pilates',  18.50, 10, 1),
 (4, 'Boxeo',    25.00,  8, 2);

INSERT INTO inscripcion (id_socio, id_actividad, fecha) VALUES
 (1, 1, '2026-09-01'),
 (1, 2, '2026-09-05'),
 (2, 2, '2026-09-02'),
 (3, 1, '2026-09-03'),
 (3, 3, '2026-09-10'),
 (4, 4, '2026-09-12'),
 (5, 2, '2026-09-15'),
 (1, 3, '2026-09-20');

 -- select simples

-- todos los datos de todos los socios
select * from socio;

-- nombre y email de los socios de malaga
select nombre, email from socio where ciudad = 'Malaga';

-- nombre de los socios que su nombre empieza por A
select nombre from socio where nombre like 'A%';

-- nombre de los socios que no tienen email
select nombre from socio where email is null;

-- ciudades de los socios sin repetir
select DISTINCT ciudad from socio;

-- actividades con precio entre 15 y 20
select nombre, precio from actividad where precio BETWEEN 15 and 20;

-- actividades que ceusten menos de 20 y tenga 10 plazas o mas
select nombre, precio, plazas from actividad where precio<20 and plazas >= 10;

-- modificar datos
-- carla gil s eha mudado a cordoba
UPDATE socio set ciudad = 'Cordoba' where nombre = 'Carla Gil';

-- sube un 10% el precio de yoga
update actividad set precio = precio*1.10 where nombre = 'yoga';

-- quita una plaza a boxeo
update actividad set plazas = plazas-1 where nombre = 'boxeo';

-- consultas con join
-- nombre del socio, de la actividad y la fecha de todas las inscripciones
select i.fecha, s.nombre, a.nombre from inscripcion i
join socio s on s.id_socio = i.id_socio
join actividad a on a.id_actividad = i.id_actividad;

-- actvidades a las que esta apuntado el socio 1
select a.nombre from actividad a
join inscripcion i on a.id_actividad = i.id_actividad
where i.id_socio = 1;

-- cuantos inscritos tiene cada actividad
select a.nombre, COUNT(*) from actividad a
join inscripcion i on a.id_actividad = i.id_actividad
group by a.id_actividad;

-- socios que no estan apuntados a ninguna actividad
select s.nombre from socio s 
left join inscripcion i on s.id_socio = i.id_socio
where i.id_inscripcion is null;

-- nombre de cada actividad con el nombre de su monitor
select a.nombre, m.nombre from actividad a  
join monitor m on m.id_monitor = a.id_monitor;

-- cuantas actividades imparten cada monitor incluidos los que no imparten ninguna
select m.nombre, COUNT(a.id_actividad) from monitor m  
left join actividad a on m.id_monitor = a.id_monitor
GROUP BY m.id_monitor;

-- BORRAR DATOS
DELETE FROM inscripcion where id_inscripcion = 8;

-- TRUNCATE TABLE inscripcion;
















