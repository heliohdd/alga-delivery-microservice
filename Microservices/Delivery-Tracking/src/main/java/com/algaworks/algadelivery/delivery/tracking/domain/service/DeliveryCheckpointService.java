package com.algaworks.algadelivery.delivery.tracking.domain.service;

import com.algaworks.algadelivery.delivery.tracking.domain.exception.DomainException;
import com.algaworks.algadelivery.delivery.tracking.domain.model.Delivery;
import com.algaworks.algadelivery.delivery.tracking.domain.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeliveryCheckpointService {

    private final DeliveryRepository deliveryRepository;

    public void place(UUID deliveryId){
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new DomainException("Delivery id not found"));
        delivery.place();
        deliveryRepository.saveAndFlush(delivery);
    }

    public void pickup(UUID deliveryId, UUID courierId){
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new DomainException("Delivery id not found"));
        delivery.pickup(courierId);
    }

    public void complete(UUID deliveryId){
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(()-> new DomainException("Delivery id not found"));
        delivery.markAsDelivered();
    }
}