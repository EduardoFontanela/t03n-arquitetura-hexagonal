package com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.sqs;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.sqs.dto.PedidoEvent;
import com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.sqs.mapper.PedidoSqsMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsPedidoAdapter {

    private final PedidoServicePort pedidoServicePort;
    private final PedidoSqsMapper mapper;

    public SqsPedidoAdapter(PedidoServicePort pedidoServicePort, PedidoSqsMapper mapper) {
        this.pedidoServicePort = pedidoServicePort;
        this.mapper = mapper;
    }

    @SqsListener("${queue.order-events}")
    public void receberMensagem(PedidoEvent evento) {
        PedidoBO bo = mapper.toBo(evento);
        pedidoServicePort.criarPedido(bo);
    }
}