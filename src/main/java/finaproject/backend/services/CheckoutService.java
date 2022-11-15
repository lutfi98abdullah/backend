package finaproject.backend.services;

import finaproject.backend.dto.PurchaseResponse;
import finaproject.backend.dto.Purchases;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchases purchase);
}
