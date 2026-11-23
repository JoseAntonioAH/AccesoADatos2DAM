package com.pc101.ejercicio2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByPrecioGreaterThan(double precio);     // WHERE precio > ?

    List<Producto> findByNombreContaining(String texto);       // WHERE nombre LIKE %texto%

    List<Producto> findByCategoriaId(int idCategoria);         // WHERE id_categoria = ?
}