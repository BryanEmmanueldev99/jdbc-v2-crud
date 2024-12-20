package com.example.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.crud.models.dao.ClienteDAOImpl;
import com.example.crud.models.entity.Cliente;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ClienteController {

     @Autowired
     private ClienteDAOImpl dao;

     @GetMapping("/")
     public String index(Model model)
     {
            List<Cliente> clientes = dao.all();
            model.addAttribute("clientes", clientes);

            return "index";
     }

     @GetMapping("/cliente")
     public String create(Model model) {
         String titulo = "¡Registrar un nuevo cliente!";
         model.addAttribute("cliente", new Cliente());
         model.addAttribute("h2", titulo);
         return "clientes/create";
     }

     @PostMapping("/cliente")
     public String store(@ModelAttribute Cliente cliente) {
         dao.save(cliente);
         return "redirect:/";
     }

     @GetMapping("/cliente/{id}")
     public String edit(@PathVariable int id ,Model model) {
         Cliente cliente = dao.find(id);
         model.addAttribute("c", cliente);
         return "clientes/edit";
     }

     @PostMapping("/actualizar-cliente")
     public String updateEntity(@ModelAttribute Cliente cliente) {
         dao.update(cliente);
         return "redirect:/";
     }

     @GetMapping("/eliminar-cliente/{id}")
     public String destroy(@PathVariable int id) {
         dao.delete(id);
         return "redirect:/";
     }

}
