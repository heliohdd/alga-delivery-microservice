package com.algaworks.algadelivery.courier.Management.domain.model;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AssignedDelivery {

    @EqualsAndHashCode.Include
    private UUID id;

    private OffsetDateTime assignedAt;

    static AssignedDelivery pending(UUID deliveryId){
        AssignedDelivery delivery = new AssignedDelivery();
        delivery.setId(deliveryId);
        delivery.setAssignedAt(OffsetDateTime.now());
        return delivery;
    }
}
