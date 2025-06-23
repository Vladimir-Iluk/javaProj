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
    public String listClients(
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String search,
            Model model) {

        Iterable<Client> clients;
        String sortDirection = (sort != null && sort.equals("asc")) ? "asc" : "desc";

        if (search != null && !search.isEmpty()) {
            clients = clientRepository.searchAcrossAllFields(search);
        } else if ("asc".equals(sort)) {
            clients = clientRepository.findAllByOrderByClientIdAsc();
        } else if ("desc".equals(sort)) {
            clients = clientRepository.findAllByOrderByClientIdDesc();
        } else {
            clients = clientRepository.findAll();
            sortDirection = "asc";
        }

        model.addAttribute("clients", clients);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("searchTerm", search);
        return "page/clients";
    }

    @GetMapping("/clients/add")
    public String showAddClient(Model model) {
        return "page/client_add";
    }

    @PostMapping("/clients/add")
    public String addClient(@RequestParam String lastName,
                            @RequestParam String firstName,
                            @RequestParam String patronymic,
                            @RequestParam String passportNumber,
                            @RequestParam String passportSeries,
                            @RequestParam String passportIssuedDate) {
        try {
            Client client = new Client();
            client.setLastName(lastName);
            client.setFirstName(firstName);
            client.setPatronymic(patronymic);
            client.setPassportNumber(passportNumber);
            client.setPassportSeries(passportSeries);
            client.setPassportIssuedDate(java.time.LocalDate.parse(passportIssuedDate));
            clientRepository.save(client);
            return "redirect:/clients";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/clients";
        }
    }

    @GetMapping("/clients/edit")
    public String showEditClient(@RequestParam Long clientId, Model model) {
        var client = clientRepository.findById(clientId).orElseThrow();
        model.addAttribute("client", client);
        return "page/client_edit";
    }

    @PostMapping("/clients/edit")
    public String editClient(@RequestParam Long clientId,
                             @RequestParam String lastName,
                             @RequestParam String firstName,
                             @RequestParam String patronymic,
                             @RequestParam String passportNumber,
                             @RequestParam String passportSeries,
                             @RequestParam String passportIssuedDate) {
        try {
            Client client = new Client();
            client.setLastName(lastName);
            client.setFirstName(firstName);
            client.setPatronymic(patronymic);
            client.setPassportNumber(passportNumber);
            client.setPassportSeries(passportSeries);
            client.setPassportIssuedDate(java.time.LocalDate.parse(passportIssuedDate));
            clientRepository.save(client);
            return "redirect:/clients";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/clients";
        }
    }

    @GetMapping("/clients/delete")
    public String deleteClient(@RequestParam Long clientId) {
        try {
            clientRepository.deleteById(clientId);
            return "redirect:/clients";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/clients";
        }
    }
}
