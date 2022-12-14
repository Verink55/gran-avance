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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="empleados")
public class Empleado {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;
    
    @NotEmpty
    @Column(nullable=false)
    private String foto;

    @NotEmpty
    @Size(min=10,max=25)
    @Column(length = 25,nullable=false)
    private String nombre;

    @NotEmpty
    @Size(min=10,max=25)
    @Column(length = 25,nullable=false)
    private String apellido;

    @NotEmpty
    @Column(length = 25,nullable=false)
    public String tipodoc;

    @NotEmpty
    @Size(min=8, max=15)
    @Column(length = 15, nullable=false, unique = true)
    private Integer noDocumento;

    @NotEmpty
    @Email
    @Column(length=40, nullable=false, unique = true)
    private String email;

    @NotEmpty
    @Size(min=10,max=10)
    @Column(length=10, nullable=false, unique = true)
    private Integer telefono;
    
    private Boolean estado;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Venta> venta;


    //Constructores


    public Empleado() {
        venta = new ArrayList<Venta>();
    }


    public Empleado(Integer idEmpleado, @NotEmpty String foto, @NotEmpty @Size(min = 10, max = 25) String nombre,
            @NotEmpty @Size(min = 10, max = 25) String apellido, @NotEmpty String tipodoc,
            @NotEmpty @Size(min = 8, max = 15) Integer noDocumento, @NotEmpty @Email String email,
            @NotEmpty @Size(min = 10, max = 10) Integer telefono, Boolean estado, List<Venta> venta) {
        this.idEmpleado = idEmpleado;
        this.foto = foto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipodoc = tipodoc;
        this.noDocumento = noDocumento;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.venta = venta;
    }


    public Integer getIdEmpleado() {
        return idEmpleado;
    }


    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getTipodoc() {
        return tipodoc;
    }


    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }


    public Integer getNoDocumento() {
        return noDocumento;
    }


    public void setNoDocumento(Integer noDocumento) {
        this.noDocumento = noDocumento;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getTelefono() {
        return telefono;
    }


    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }


    public Boolean getEstado() {
        return estado;
    }


    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public List<Venta> getVenta() {
        return venta;
    }


    public void setVenta(List<Venta> venta) {
        this.venta = venta;
    }

}

    