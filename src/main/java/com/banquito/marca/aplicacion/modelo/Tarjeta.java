package com.banquito.marca.aplicacion.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Tarjeta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TIPO", length = 3, nullable = false)
    private String tipo;

    @Column(name = "NUMERO", length = 16, nullable = false)
    private String numero;

    @Column(name = "CVV", length = 3, nullable = false)
    private String cvv;

    @Column(name = "FECHA_CADUCIDAD", nullable = false)
    private LocalDate fechaCaducidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "tarjeta", fetch = FetchType.LAZY)
    private List<Transaccion> transacciones;
}
