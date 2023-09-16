package com.gapsi.gapsiecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;
    private String nombre;
    private String razonSocial;
    private String direccion;

    public Long getIdProveedor() {
        return this.idProveedor;
    }

    public void setId(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
