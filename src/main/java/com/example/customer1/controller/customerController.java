/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.customer1.controller;

import com.example.customer1.model.Customer;
import com.example.customer1.repository.customerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lmanh
 */
@Controller
@RequestMapping(value = "/view")
public class customerController {

    customerRepository ctsrp;
    List<Customer> list;

    public customerController() {
        ctsrp = new customerRepository();
       list = ctsrp.filldata();
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("add",list);
        return "Views/viewlist";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
       ctsrp.changeStatusById(id);
        return "redirect:/view/list";
    }
    @PostMapping("/update/{id}")
    public String update(Customer id){
        ctsrp.updateCustomer(id);
        return "redirect:/view/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Customer teacher = ctsrp.byidCustomer(id);
        model.addAttribute("edit", teacher);
        return "Views/edit";

    }
}
