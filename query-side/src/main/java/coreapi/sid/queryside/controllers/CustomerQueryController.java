package coreapi.sid.queryside.controllers;

import coreapi.sid.queryside.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.sid.coreapi.queries.GetAllCustomerQuery;
import org.sid.coreapi.queries.GetCustomerQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/customers/query")
public class CustomerQueryController {

    private QueryGateway queryGateway;
    @GetMapping("/all")
    public CompletableFuture<List<Customer>>  customers(){
        return  queryGateway.query(new GetAllCustomerQuery(),
                ResponseTypes.multipleInstancesOf(Customer.class)
        );
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Customer>  customer(@PathVariable String id){
        return  queryGateway.query(new GetCustomerQuery(id),
                ResponseTypes.instanceOf(Customer.class)
        );
    }
}
