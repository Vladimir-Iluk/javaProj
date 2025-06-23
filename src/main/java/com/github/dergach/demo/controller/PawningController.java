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

    @GetMapping("/pawnning")
    public String listPawning(@RequestParam(required = false) String sort,
                              @RequestParam(required = false) String search,
                              Model model) {
        Iterable<Pawning> pawnings;
        String sortDirection = (sort != null && sort.equals("asc")) ? "asc" : "desc";

        if (search != null && !search.isEmpty()) {
            pawnings = pawningRepository.searchAcrossAllFields(search);
        } else if ("asc".equals(sort)) {
            pawnings = pawningRepository.findAllByOrderByPawningIdAsc();
        } else if ("desc".equals(sort)) {
            pawnings = pawningRepository.findAllByOrderByPawningIdDesc();
        } else {
            pawnings = pawningRepository.findAll();
            sortDirection = "asc";
        }

        model.addAttribute("pawnings", pawnings);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("searchTerm", search);
        return "page/pawnning";
    }

    @GetMapping("/pawnning/add")
    public String showAddPawning(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "page/pawning_add";
    }

    @PostMapping("/pawnning/add")
    public String addPawning(@RequestParam Long clientId,
                             @RequestParam Long categoryId,
                             @RequestParam String productDescription,
                             @RequestParam String dateReceived,
                             @RequestParam String returnDeadline,
                             @RequestParam String amount,
                             @RequestParam String commission) {
        try {
            Pawning p = new Pawning();
            p.setClient(clientRepository.findById(clientId).orElseThrow());
            p.setCategory(categoryRepository.findById(categoryId).orElseThrow());
            p.setProductDescription(productDescription);
            p.setDateReceived(LocalDate.parse(dateReceived));
            p.setReturnDeadline(LocalDate.parse(returnDeadline));
            p.setAmount(new BigDecimal(amount));
            p.setCommission(new BigDecimal(commission));
            pawningRepository.save(p);
            return "redirect:/pawnning";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/pawnning";
        }
    }

    @GetMapping("/pawnning/edit")
    public String showEditPawning(@RequestParam Long pawningId, Model model) {
        var p = pawningRepository.findById(pawningId).orElseThrow();
        model.addAttribute("pawning", p);
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "page/pawning_edit";
    }

    @PostMapping("/pawnning/edit")
    public String editPawning(@RequestParam Long pawningId,
                              @RequestParam Long clientId,
                              @RequestParam Long categoryId,
                              @RequestParam String productDescription,
                              @RequestParam String dateReceived,
                              @RequestParam String returnDeadline,
                              @RequestParam String amount,
                              @RequestParam String commission) {
        try {
            Pawning p = pawningRepository.findById(pawningId).orElseThrow();
            p.setClient(clientRepository.findById(clientId).orElseThrow());
            p.setCategory(categoryRepository.findById(categoryId).orElseThrow());
            p.setProductDescription(productDescription);
            p.setDateReceived(LocalDate.parse(dateReceived));
            p.setReturnDeadline(LocalDate.parse(returnDeadline));
            p.setAmount(new BigDecimal(amount));
            p.setCommission(new BigDecimal(commission));
            pawningRepository.save(p);
            return "redirect:/pawnning";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/pawnning";
        }
    }

    @GetMapping("/pawnning/delete")
    public String deletePawning(@RequestParam Long pawningId) {
        try {
            pawningRepository.deleteById(pawningId);
            return "redirect:/pawnning";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/pawnning";
        }
    }
}