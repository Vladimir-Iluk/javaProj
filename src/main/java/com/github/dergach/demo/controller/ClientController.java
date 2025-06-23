package com.github.dergach.demo.controller;

import com.github.dergach.demo.data.entitys.Client;
import com.github.dergach.demo.data.entitys.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "page/clients";
    }

    @GetMapping("/clients/add")
    public String showAddClient(Model model) {
        return "page/client_add";
    }

    @PostMapping("/clients/add")
    public String addClient(@RequestParam String last_name,
                            @RequestParam String first_name,
                            @RequestParam String patronymic,
                            @RequestParam String passport_number,
                            @RequestParam String passport_series,
                            @RequestParam String passport_issued_date) {
        try {
            Client client = new Client();
            client.setLast_name(last_name);
            client.setFirst_name(first_name);
            client.setPatronymic(patronymic);
            client.setPassport_number(passport_number);
            client.setPassport_series(passport_series);
            client.setPassport_issued_date(java.time.LocalDate.parse(passport_issued_date));
            clientRepository.save(client);
            return "redirect:/clients";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/clients";
        }
    }

    @GetMapping("/clients/edit")
    public String showEditClient(@RequestParam Long client_id, Model model) {
        var client = clientRepository.findById(client_id).orElseThrow();
        model.addAttribute("client", client);
        return "page/client_edit";
    }

    @PostMapping("/clients/edit")
    public String editClient(@RequestParam Long client_id,
                             @RequestParam String last_name,
                             @RequestParam String first_name,
                             @RequestParam String patronymic,
                             @RequestParam String passport_number,
                             @RequestParam String passport_series,
                             @RequestParam String passport_issued_date) {
        try {
            Client client = clientRepository.findById(client_id).orElseThrow();
            client.setLast_name(last_name);
            client.setFirst_name(first_name);
            client.setPatronymic(patronymic);
            client.setPassport_number(passport_number);
            client.setPassport_series(passport_series);
            client.setPassport_issued_date(java.time.LocalDate.parse(passport_issued_date));
            clientRepository.save(client);
            return "redirect:/clients";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/clients";
        }
    }

    @GetMapping("/clients/delete")
    public String deleteClient(@RequestParam Long client_id) {
        try {
            clientRepository.deleteById(client_id);
            return "redirect:/clients";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/clients";
        }
    }
}
