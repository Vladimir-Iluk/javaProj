package com.github.dergach.demo.controller;

import com.github.dergach.demo.data.entitys.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class PawningController {
    private final PawningRepository pawningRepository;
    private final ClientRepository clientRepository;
    private final ProductCategoryRepository categoryRepository;

    public PawningController(PawningRepository pawningRepository,
                             ClientRepository clientRepository,
                             ProductCategoryRepository categoryRepository) {
        this.pawningRepository = pawningRepository;
        this.clientRepository = clientRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/pawning")
    public String listPawning(Model model) {
        model.addAttribute("pawnings", pawningRepository.findAll());
        return "page/pawning";
    }

    @GetMapping("/pawning/add")
    public String showAddPawning(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "page/pawning_add";
    }

    @PostMapping("/pawning/add")
    public String addPawning(@RequestParam Long client_id,
                             @RequestParam Long category_id,
                             @RequestParam String product_description,
                             @RequestParam String date_received,
                             @RequestParam String return_deadline,
                             @RequestParam String amount,
                             @RequestParam String commission) {
        try {
            Pawning p = new Pawning();
            p.setClient(clientRepository.findById(client_id).orElseThrow());
            p.setCategory(categoryRepository.findById(category_id).orElseThrow());
            p.setProduct_description(product_description);
            p.setDate_received(LocalDate.parse(date_received));
            p.setReturn_deadline(LocalDate.parse(return_deadline));
            p.setAmount(new BigDecimal(amount));
            p.setCommission(new BigDecimal(commission));
            pawningRepository.save(p);
            return "redirect:/pawning";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/pawning";
        }
    }

    @GetMapping("/pawning/edit")
    public String showEditPawning(@RequestParam Long pawning_id, Model model) {
        var p = pawningRepository.findById(pawning_id).orElseThrow();
        model.addAttribute("pawning", p);
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "page/pawning_edit";
    }

    @PostMapping("/pawning/edit")
    public String editPawning(@RequestParam Long pawning_id,
                              @RequestParam Long client_id,
                              @RequestParam Long category_id,
                              @RequestParam String product_description,
                              @RequestParam String date_received,
                              @RequestParam String return_deadline,
                              @RequestParam String amount,
                              @RequestParam String commission) {
        try {
            Pawning p = pawningRepository.findById(pawning_id).orElseThrow();
            p.setClient(clientRepository.findById(client_id).orElseThrow());
            p.setCategory(categoryRepository.findById(category_id).orElseThrow());
            p.setProduct_description(product_description);
            p.setDate_received(LocalDate.parse(date_received));
            p.setReturn_deadline(LocalDate.parse(return_deadline));
            p.setAmount(new BigDecimal(amount));
            p.setCommission(new BigDecimal(commission));
            pawningRepository.save(p);
            return "redirect:/pawning";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/pawning";
        }
    }

    @GetMapping("/pawning/delete")
    public String deletePawning(@RequestParam Long pawning_id) {
        try {
            pawningRepository.deleteById(pawning_id);
            return "redirect:/pawning";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/pawning";
        }
    }
}
