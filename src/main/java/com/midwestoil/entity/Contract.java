package com.midwestoil.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Contract extends BaseEntity {

    private Long contractId;
    private Company client;
    private Double percentage;

    public Contract(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, Long contractId, Company client, Double percentage) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.contractId = contractId;
        this.client = client;
        this.percentage = percentage;
    }
}
