package com.br.SAarcodicionados.controller;

import com.br.SAarcodicionados.model.Pagamento;
import com.br.SAarcodicionados.model.Comissao;
import com.br.SAarcodicionados.service.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/financeiro")
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping("/pagamentos")
    public String listarPagamentos(Model model) {
        List<Pagamento> pagamentos = financeiroService.listarPagamentos();
        model.addAttribute("pagamentos", pagamentos);
        return "financeiro/pagamento";
    }

    @GetMapping("/comissoes")
    public String listarComissoes(Model model) {
        List<Comissao> comissoes = financeiroService.listarComissoes();
        model.addAttribute("comissoes", comissoes);
        return "financeiro/comissao";
    }

    @GetMapping("/pagamento/novo")
    public String novoPagamento(Model model) {
        model.addAttribute("pagamento", new Pagamento());
        return "financeiro/pagamento_form";
    }

    @PostMapping("/pagamento/salvar")
    public String salvarPagamento(@ModelAttribute Pagamento pagamento) {
        financeiroService.salvarPagamento(pagamento);
        return "redirect:/financeiro/pagamentos";
    }

    @GetMapping("/comissao/novo")
    public String novaComissao(Model model) {
        model.addAttribute("comissao", new Comissao());
        return "financeiro/comissao_form";
    }

    @PostMapping("/comissao/salvar")
    public String salvarComissao(@ModelAttribute Comissao comissao) {
        financeiroService.salvarComissao(comissao);
        return "redirect:/financeiro/comissoes";
    }
}