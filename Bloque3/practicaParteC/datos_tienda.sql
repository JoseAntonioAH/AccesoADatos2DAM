SELECT USER(), @@hostname, NOW();
use hibernate_db;

-- 3 categorías nuevas
INSERT INTO categoria (nombre) VALUES 
('Audio y Sonido'),
('Almacenamiento'),
('Redes y Conectividad');

-- 8 productos nuevos repartidos entre las categorías
INSERT INTO producto (nombre, precio, stock, id_categoria) VALUES 
('Auriculares Gaming Alcalá', 49.90, 25, 3),
('Altavoces Bluetooth 2.0', 34.50, 18, 3),
('Micrófono Condensador USB', 59.00, 12, 3),
('SSD NVMe 1TB', 79.95, 30, 4),
('Disco Duro Externo 2TB', 65.00, 20, 4),
('Memoria USB 128GB', 14.90, 80, 4),
('Router WiFi 6', 89.00, 10, 5),
('Cable Ethernet Cat6 10m', 9.50, 50, 5);

-- 3 clientes nuevos
INSERT INTO cliente (nombre) VALUES 
('Jose Antonio'),
('Alejandro'),
('Juan Antonio');

-- Más compras: los clientes nuevos compran varios productos
INSERT INTO compra (id_cliente, id_producto) VALUES 
(3, 5),
(3, 8),
(4, 6),
(4, 11),
(5, 7),
(5, 9),
(5, 12);
