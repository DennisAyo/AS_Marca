package com.banquito.marca.aplicacion.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "IDENTIFICACION", length = 13, nullable = false)
    private String identificacion;
    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;
    @Column(name = "DIRECCION", length = 50, nullable = false)
    private String direccion;
    @Column(name = "TELEFONO", length = 50, nullable = true)
    private String telefono;
    @Column(name = "CORREO", length = 50, nullable = true)
    private String correo;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Tarjeta> tarjetas;
}
