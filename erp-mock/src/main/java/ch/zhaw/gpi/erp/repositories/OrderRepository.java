package ch.zhaw.gpi.erp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.gpi.erp.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
    public Optional<Order> findByReferenceNumber(Long referenceNumber);
}
