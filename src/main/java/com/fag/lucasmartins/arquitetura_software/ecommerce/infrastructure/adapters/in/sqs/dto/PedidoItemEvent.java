package com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.sqs.dto;

public class PedidoItemEvent {

    private Long sku;
    private Integer amount;

    public PedidoItemEvent() {}

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}