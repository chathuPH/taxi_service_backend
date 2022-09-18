package com.example.gocheetanew.service;

import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.model.Admin;
import com.example.gocheetanew.model.Customer;
import com.example.gocheetanew.model.Driver;
import com.example.gocheetanew.repository.CustomerRepository;
import com.example.gocheetanew.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService  implements UserService{

    private CustomerRepository customerRepository;

    @Override
    public Customer login(String username, String password){

        Customer response = customerRepository.findByUsername(username);
        if(response == null){
            throw  new RuntimeException("customer not found");
        }else{
            if(response.getPassword().equals(password)){
                return response;
            }else{
                throw  new RuntimeException("wrong password");
            }
        }
    }

    @Override
    public Customer register(RegisterDto registerDto){

        if(registerDto == null){
            throw  new RuntimeException("null or field missing");
        }
        Customer customer = new Customer();
        customer.setUsername(registerDto.getUsername());
        customer.setPassword(registerDto.getPassword());
        customer.setCustomerName(registerDto.getCustomerName());
        customer.setContactNo(registerDto.getContactNo());

        return customerRepository.save(customer);

    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer findById(long id){
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("customer not found"));
    }

    public Customer update(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer delete(long id){
        Customer deleted = customerRepository.findById(id).orElseThrow(()->new RuntimeException("customer not found"));
        customerRepository.deleteById(id);
        return deleted;
    }
}
