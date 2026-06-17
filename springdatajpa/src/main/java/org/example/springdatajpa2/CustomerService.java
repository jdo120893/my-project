package org.example.springdatajpa2;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.Lint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> findCustomer() {
       return repository.findAll();
    }

    public Customer findByCustomer(Customer customer) {
       return repository.findById(customer.getId()).orElseThrow(()-> new IllegalArgumentException("사용자를 찾을 수 없습니다. ::"+customer.getId()));
    }

    public Customer updateCustomer(Customer customer) {
        Customer found = repository.findById(customer.getId()).orElseThrow(()-> new IllegalArgumentException("사용자를 찾을 수 없습니다. ::"+customer.getId()));
        found.setName(customer.getName());
        found.setAge(customer.getAge());

        return found;
    }

    public Customer deleteCustomer(Customer customer) {
        repository.findById(customer.getId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ::" + customer.getId()));
        repository.delete(customer);
        return customer;
    }





}
