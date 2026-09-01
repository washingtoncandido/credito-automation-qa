package org.example.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimulationDTO {
    private double valorSolicitado;
    private int parcelas;
    private Long idSimulacao;
    private double valorParcela;
    private double valorTotalAPagar;
    private String taxaJurosMensal;
}