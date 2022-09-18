package com.example.gocheetanew.controller;

import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.model.Customer;
import com.example.gocheetanew.model.Driver;
import com.example.gocheetanew.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    @PutMapping("/update")
    public ResponseEntity<Customer> create(@RequestBody RegisterDto registerDto){
        HttpStatus response  = HttpStatus.EXPECTATION_FAILED;

        if(registerDto==null){
            response = HttpStatus.BAD_REQUEST;
        }else{
            response = HttpStatus.CREATED;
        }

        Customer customer = new Customer();
        customer.setId(registerDto.getCustomerId());
        customer.setUsername(registerDto.getUsername());
        customer.setPassword(registerDto.getPassword());
        customer.setCustomerName(registerDto.getCustomerName());
        customer.setContactNo(registerDto.getContactNo());
        return new ResponseEntity<>(customerService.update(customer),response);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>>  findAll(){
        return new ResponseEntity<>( customerService.findAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Customer> delete(@RequestParam(name = "id") long id){
        return new ResponseEntity<>(customerService.delete(id),HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Customer> findById(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(customerService.findById(Long.parseLong(id)),HttpStatus.OK);
    }
}
