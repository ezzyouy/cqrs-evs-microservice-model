package coreapi.sid.queryside.repositories;

import coreapi.sid.queryside.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<Customer, String> {
}
