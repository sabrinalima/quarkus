package org.br.mineradora.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
@Data
@Builder
@AllArgsConstructor
public class OpportunityDTO {

    private Long proposalId;

    private String customer;

    private BigDecimal priceTonne;

    private BigDecimal lastDollarQuotation;

}
