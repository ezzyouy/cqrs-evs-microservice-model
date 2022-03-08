package coreapi.sid.queryside.services;

import coreapi.sid.queryside.entities.Customer;
import coreapi.sid.queryside.repositories.CustomerRespository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.sid.coreapi.events.CreateCustomerEvent;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerEventHandle {
    private CustomerRespository customerRespository;
    @EventHandler
    public void on(CreateCustomerEvent event){
        log.info("**********************");
        log.info("CreateCustomerEvent recieved");
        Customer customer=new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());
        customerRespository.save(customer);
    }
}
