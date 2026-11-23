package com.pc101.ejercicio2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Ejercicio2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Ejercicio2Application.class, args);

        // Pedimos a Spring los repositorios
        CategoriaRepository categorias = ctx.getBean(CategoriaRepository.class);
        ProductoRepository productos = ctx.getBean(ProductoRepository.class);
        ClienteRepository clientes = ctx.getBean(ClienteRepository.class);

        // ===== C - CREATE (insertar) =====
        Categoria perifericos = categorias.save(new Categoria("Periféricos"));
        Categoria monitores = categorias.save(new Categoria("Monitores"));

        Producto teclado = productos.save(new Producto("Teclado Alcalá", 25.90, 40, perifericos));
        Producto raton = productos.save(new Producto("Ratón", 12.50, 60, perifericos));
        Producto monitor = productos.save(new Producto("Monitor 24 pulgadas", 129.00, 15, monitores));
        Producto alfombrilla = productos.save(new Producto("Alfombrilla", 5.00, 100, perifericos));

        Cliente c1 = new Cliente("Jose Antonio");
        Cliente c2 = new Cliente("Luis");

        // Hacemos que el cliente compre dos productos (se guarda en la tabla COMPRA)
        c1.getProductos().add(teclado);
        c1.getProductos().add(monitor);

        clientes.save(c1);
        clientes.save(c2);

        // ===== R - READ (consultar) =====
        System.out.println("--- PRODUCTOS ---");
        for (Producto p : productos.findAll()) {
            System.out.println(p.getNombre() + " | " + p.getPrecio() + " | " + p.getCategoria().getNombre());
        }

        System.out.println("--- CLIENTES ---");
        for (Cliente c : clientes.findAll()) {
            System.out.println(c.getNombre());
        }

        // ===== U - UPDATE (modificar) =====
        raton.setPrecio(14.90);
        productos.save(raton); // como ya tiene id, hace UPDATE

        // ===== D - DELETE (borrar) =====
        productos.deleteById(alfombrilla.getId());

        // ===== Comprobamos el resultado =====
        System.out.println("--- PRODUCTOS DESPUÉS DE MODIFICAR Y BORRAR ---");
        for (Producto p : productos.findAll()) {
            System.out.println(p.getNombre() + " | " + p.getPrecio());
        }
    }
}
