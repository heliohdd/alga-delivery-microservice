package com.algaworks.algadelivery.courier.Management.domain.repository;

import com.algaworks.algadelivery.courier.Management.domain.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourierRepository extends JpaRepository<Courier, UUID> {
}
