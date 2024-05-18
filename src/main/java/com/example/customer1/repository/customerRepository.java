/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.customer1.repository;

import com.example.customer1.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Lmanh
 */
public class customerRepository {

    private List<Customer> lstarr = new ArrayList<>();

    public List<Customer> filldata() {
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            int status = random.nextInt(2);
            lstarr.add(new Customer(i, "name" + i, status));
        }
        return lstarr;
    }

    public void addCustomer(Customer ct) {
        this.lstarr.add(ct);
    }
   public Customer byidCustomer(int id){
       Customer a = null; 
       for (int i = 0; i < lstarr.size(); i++) {
           Customer get = lstarr.get(i);
           if(get.getId() == id){
               a = get;
           }
       }
        return a;
   }
   public void updateCustomer(Customer ct){
       for (int i = 0; i < lstarr.size(); i++) {
           Customer get = lstarr.get(i);
           if(get.getId() == ct.getId()){
               lstarr.set(i, ct);
           }
       }
   }
public void changeStatusById(int id) {
    for (int i = 0; i < lstarr.size(); i++) {
        Customer customer = lstarr.get(i);
        if (customer.getId() == id) {
            int currentStatus = customer.getStatus();
            int newStatus = (currentStatus == 0) ? 1 : 0;
            customer.setStatus(newStatus);
            lstarr.set(i, customer);
            break;
        }
    }
}
}
