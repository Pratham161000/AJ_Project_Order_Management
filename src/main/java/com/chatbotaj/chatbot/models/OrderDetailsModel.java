package com.chatbotaj.chatbot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetailsModel {

    @Id
    private Integer cid;
    private Integer oid;
    private Integer itemId;
    private Integer qty;
    private Double total;
    private Integer pymtsts;
    private Integer canceled;

    public Integer getCanceled() {
        return canceled;
    }

    public void setCanceled(Integer canceled) {
        this.canceled = canceled;
    }

    public OrderDetailsModel() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }



    public Integer getPymtsts() {
        return pymtsts;
    }

    public void setPymtsts(Integer pymtsts) {
        this.pymtsts = pymtsts;
    }

}
