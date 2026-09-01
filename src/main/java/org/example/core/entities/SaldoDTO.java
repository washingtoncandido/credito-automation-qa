package org.example.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaldoDTO {
    private double saldoAtual;
    private String moeda;
    private boolean sucesso;
}
