package com.pc101.ejercicio2;

import java.util.*;

import jakarta.persistence.*;

@Entity 
@Table(name="CLIENTE")

public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    public Cliente(){}
    
    public Cliente(String nombre){
        this.nombre = nombre;
    }

    @ManyToMany //relacion de muchos a muchos
    @JoinTable (
        name = "COMPRA",                                            // nombre de la nueva tabla que se crea
        joinColumns = @JoinColumn(name="id_cliente"),               // relaciona la clave primaria de esta tabla
        inverseJoinColumns = @JoinColumn (name="id_producto")       // relaciona la clave primaria de la otra tabla
        ) 
    private Set<Producto> productos = new HashSet<>();

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    
}
