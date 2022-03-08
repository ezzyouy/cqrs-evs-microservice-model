package coreapi.sid.queryside.services;

import coreapi.sid.queryside.entities.Customer;
import coreapi.sid.queryside.repositories.CustomerRespository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.coreapi.events.CreateCustomerEvent;
import org.sid.coreapi.queries.GetAllCustomerQuery;
import org.sid.coreapi.queries.GetCustomerQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerQueryHandler {
    private CustomerRespository customerRespository;
    @QueryHandler
    public List<Customer> customerList(GetAllCustomerQuery query){
        return  customerRespository.findAll();
    }
    @QueryHandler
    public Customer customer(GetCustomerQuery query){
        return  customerRespository.findById(query.getId()).get();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity=new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
