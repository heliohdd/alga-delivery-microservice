package com.algaworks.algadelivery.courier.Management.domain.service;

import com.algaworks.algadelivery.courier.Management.api.model.CourierInput;
import com.algaworks.algadelivery.courier.Management.domain.model.Courier;
import com.algaworks.algadelivery.courier.Management.domain.repository.CourierRepository;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CourierRegistrationService {

    private final CourierRepository courierRepository;

    public Courier create(@Valid CourierInput input) {
        Courier courier = Courier.brandNew(input.getName(), input.getPhone());
        return courierRepository.saveAndFlush(courier);
    }

    public Courier update(UUID courierId, @Valid CourierInput input) {
        Courier courier = courierRepository.findById(courierId).orElseThrow();
        courier.setName(input.getName());
        courier.setPhone(input.getPhone());
        return courierRepository.saveAndFlush(courier);
    }
}
