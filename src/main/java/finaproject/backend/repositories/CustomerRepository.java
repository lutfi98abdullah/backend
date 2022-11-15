package finaproject.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import finaproject.backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
