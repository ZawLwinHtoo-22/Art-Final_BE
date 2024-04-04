package com.art.artproject.dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private Double amount;
    private Boolean disabled;
}
