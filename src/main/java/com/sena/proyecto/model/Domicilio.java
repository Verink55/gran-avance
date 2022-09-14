package com.sena.proyecto.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "domicilios") 
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDomicilio;

    @NotEmpty
    @Size(min=10,max=25)
    @Column(length = 25,nullable=false)
    private String nombre;

    @NotEmpty
    @Size(min=60,max=80)
    @Column(length=80, nullable=false)
    private String direccion;

    @NotEmpty
    @Size(min=10,max=10)
    @Column(length=10, nullable=false, unique = true)            
    private Integer telefono;

    @NotEmpty
    @Email
    @Column(length=40, nullable=false, unique = true)
    private String email;

    @NotNull
    @Size(min=2,max=5)
    @Column(length = 5,nullable=false)
    private Integer trayecto;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="idVentaFK", referencedColumnName="id") 
    private Venta venta;
    
    @OneToOne
    private Domiciliario domiciliario;

    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio, @NotEmpty @Size(min = 10, max = 25) String nombre,
            @NotEmpty @Size(min = 60, max = 80) String direccion, @NotEmpty @Size(min = 10, max = 10) Integer telefono,
            @NotEmpty @Email String email, @NotNull @Size(min = 2, max = 5) Integer trayecto, Venta venta,
            Domiciliario domiciliario) {
        this.idDomicilio = idDomicilio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.trayecto = trayecto;
        this.venta = venta;
        this.domiciliario = domiciliario;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(Integer trayecto) {
        this.trayecto = trayecto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Domiciliario getDomiciliario() {
        return domiciliario;
    }

    public void setDomiciliario(Domiciliario domiciliario) {
        this.domiciliario = domiciliario;
    }
    
}
