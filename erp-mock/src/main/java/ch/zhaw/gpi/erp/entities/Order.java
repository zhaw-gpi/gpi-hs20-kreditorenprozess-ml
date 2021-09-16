package ch.zhaw.gpi.erp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "order_table")
public class Order {
    @Id
    private Long orderId;
    private Long amount;
    private String cstCtMgr;
    private Long referenceNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Invoice invoice;
    @ManyToOne
    private Creditor creditor;

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCstCtMgr() {
        return cstCtMgr;
    }

    public void setCstCtMgr(String cstCtMgr) {
        this.cstCtMgr = cstCtMgr;
    }

    public Long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    
}