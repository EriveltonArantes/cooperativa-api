package com.cooperativaapi.controller;

import com.cooperativaapi.model.Cooperado;
import com.cooperativaapi.model.Produto;
import com.cooperativaapi.model.EntregaProduto;
import com.cooperativaapi.model.Dividendo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.cooperativaapi.repository.CooperadoRepository cooperadoRepository;

    @Autowired
    private com.cooperativaapi.repository.ProdutoRepository produtoRepository;

    @Autowired
    private com.cooperativaapi.repository.EntregaProdutoRepository entregaProdutoRepository;

    @Autowired
    private com.cooperativaapi.repository.DividendoRepository dividendoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalCooperado", cooperadoRepository.count());
        resumo.put("somaQuotaCooperado", cooperadoRepository.findAll().stream().filter(e -> e.getQuota() != null).mapToDouble(e -> e.getQuota()).sum());
        resumo.put("totalProduto", produtoRepository.count());
        resumo.put("somaPrecoBrutoProduto", produtoRepository.findAll().stream().filter(e -> e.getPrecoBruto() != null).mapToDouble(e -> e.getPrecoBruto()).sum());
        resumo.put("totalEntregaProduto", entregaProdutoRepository.count());
        resumo.put("somaQuantidadeEntregaProduto", entregaProdutoRepository.findAll().stream().filter(e -> e.getQuantidade() != null).mapToInt(e -> e.getQuantidade()).sum());
        resumo.put("graficoEntregaProduto", entregaProdutoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalDividendo", dividendoRepository.count());
        resumo.put("somaPercentualDistribuicaoDividendo", dividendoRepository.findAll().stream().filter(e -> e.getPercentualDistribuicao() != null).mapToDouble(e -> e.getPercentualDistribuicao()).sum());
        resumo.put("graficoDividendo", dividendoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
