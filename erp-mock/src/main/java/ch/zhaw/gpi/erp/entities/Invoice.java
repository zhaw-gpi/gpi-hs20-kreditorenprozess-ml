package ch.zhaw.gpi.erp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Invoice {
    @Id
    private Long invoiceId;
    private Long invoiceAmount;
    @Temporal(TemporalType.DATE)
    private Date dateOfInvoice;
    @Temporal(TemporalType.DATE)
    private Date dateDue;
    @OneToOne(mappedBy = "invoice")
    private Order order;
    @ManyToOne
    private Creditor creditor;

    public Long getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Long invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getDateOfInvoice() {
        return dateOfInvoice;
    }

    public void setDateOfInvoice(Date dateOfInvoice) {
        this.dateOfInvoice = dateOfInvoice;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    
}
