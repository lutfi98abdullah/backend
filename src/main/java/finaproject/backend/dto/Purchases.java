package finaproject.backend.dto;

import java.util.Set;

import finaproject.backend.entity.Address;
import finaproject.backend.entity.Customer;
import finaproject.backend.entity.Order;
import finaproject.backend.entity.OrderItem;
import lombok.Data;

@Data
public class Purchases {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;
}
