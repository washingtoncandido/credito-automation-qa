package org.example.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private String titular;
    private String tipo;
    private Integer id;
    private String numeroCartao;
    private double limiteDisponivel;
    private String status;
    private String criadoEm;
}
