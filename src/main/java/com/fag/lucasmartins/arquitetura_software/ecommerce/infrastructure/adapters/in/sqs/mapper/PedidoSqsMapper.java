package com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.sqs.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.sqs.dto.PedidoEvent;
import com.fag.lucasmartins.arquitetura_software.ecommerce.infrastructure.adapters.in.sqs.dto.PedidoItemEvent;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PedidoSqsMapper {

    public PedidoBO toBo(PedidoEvent event) {
        PedidoBO bo = new PedidoBO();
        
        bo.setCep(event.getZipCode());

        PessoaBO pessoa = new PessoaBO();
        if (event.getCustomerId() != null) {
            pessoa.setId(event.getCustomerId().intValue());
        }
        bo.setPessoa(pessoa);

        if (event.getOrderItems() != null) {
            bo.setItens(event.getOrderItems().stream()
                    .map(this::toItemBo)
                    .collect(Collectors.toList()));
        }

        return bo;
    }

    private PedidoProdutoBO toItemBo(PedidoItemEvent itemEvent) {
        PedidoProdutoBO itemBo = new PedidoProdutoBO();
        
        ProdutoBO produto = new ProdutoBO();
        if (itemEvent.getSku() != null) {
            produto.setId(itemEvent.getSku().intValue());
        }
        
        itemBo.setProduto(produto);
        itemBo.setQuantidade(itemEvent.getAmount());
        
        return itemBo;
    }
}