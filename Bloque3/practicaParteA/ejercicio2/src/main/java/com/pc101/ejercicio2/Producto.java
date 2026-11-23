package com.pc101.ejercicio2;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

    //clave privada
    @Id
    //autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //por defecto hace columnas. Si se quiere especificar algo (obligatorio)
    @Column(nullable = false)
    private String nombre;

    private double precio;

    private int stock;

    @ManyToOne 
    @JoinColumn(name="id_categoria")
    private Categoria categoria; //clave foranea



    public Producto(){}

    public Producto(String nombre, double precio, int stock, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}
