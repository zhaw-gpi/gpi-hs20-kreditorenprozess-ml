package ch.zhaw.gpi.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.gpi.erp.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}
