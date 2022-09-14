package com.sena.proyecto.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="productos")
public class Producto {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @NotEmpty
    @Column(nullable=false)
    private String foto;
    
    @NotEmpty
    @Size(min=5,max=15)
    @Column(length = 15,nullable=false,unique=true)
    private String nombre;

    @NotEmpty
    @Size(min=28,max=55)
    @Column(length = 55, nullable=false)
    private String descripcion;

    @NotNull
    @Size(min=1000, max=50000)
    @Column(length = 50000, nullable=false)
    private double precio;

    @NotNull
    @Size(min=1, max=200)
    @Column(length = 200, nullable=false)
    private double cantidad;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idCategoriaFK", nullable = false) 
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Detalle> detalle;


    //Constructores

    public Producto() {
        detalle=new ArrayList<Detalle>();
    }


    public Producto(Integer idProducto, @NotEmpty String foto, @NotEmpty @Size(min = 5, max = 15) String nombre,
            @NotEmpty @Size(min = 28, max = 55) String descripcion,
            @NotNull @Size(min = 1000, max = 50000) double precio, @NotNull @Size(min = 1, max = 200) double cantidad,
            Categoria categoria, List<Detalle> detalle) {
        this.idProducto = idProducto;
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.detalle = detalle;
    }


    public Integer getIdProducto() {
        return idProducto;
    }


    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }


    public String getFoto() {
        return foto;
    }


    public void setFoto(String foto) {
        this.foto = foto;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public double getCantidad() {
        return cantidad;
    }


    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    public Categoria getCategoria() {
        return categoria;
    }


    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public List<Detalle> getDetalle() {
        return detalle;
    }


    public void setDetalle(List<Detalle> detalle) {
        this.detalle = detalle;
    }


    

}

    