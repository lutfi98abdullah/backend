package finaproject.backend.services;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import finaproject.backend.dto.PurchaseResponse;
import finaproject.backend.dto.Purchases;
import finaproject.backend.entity.Customer;
import finaproject.backend.entity.Order;
import finaproject.backend.entity.OrderItem;
import finaproject.backend.repositories.CustomerRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchases purchase) {

        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        
        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());
        Customer customer = purchase.getCustomer();
        customer.add(order);


        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTackingNumber() {

        return UUID.randomUUID().toString();
    }

}
