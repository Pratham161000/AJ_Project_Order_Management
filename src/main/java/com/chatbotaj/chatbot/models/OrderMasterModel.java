package com.chatbotaj.chatbot.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_master")
public class OrderMasterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

//    @Column(nullable = false)
    private Integer cid;

//    @Column(nullable = false)
    private LocalDateTime datetime;

//    @Column(nullable = false)
    private String shpadd;

    private String tmode;

//    @Column(nullable = false)
    private String transaction;

//    @Column(nullable = false)
    private String transactionId;

    private Integer delivered;

    // Add getters and setters


    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getShpadd() {
        return shpadd;
    }

    public void setShpadd(String shpadd) {
        this.shpadd = shpadd;
    }

    public String getTmode() {
        return tmode;
    }

    public void setTmode(String tmode) {
        this.tmode = tmode;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }
}
