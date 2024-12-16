package book.ecommerce.library.repository;


import book.ecommerce.library.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}