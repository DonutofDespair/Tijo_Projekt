package ua.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import ua.restaurant.entity.Orders;
import ua.restaurant.entity.Status;
import ua.restaurant.entity.Logins;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
class OrdersRepositoryIntegrationTest {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private LoginsRepository loginsRepository;

    @Test
    void givenOrder_whenSave_thenShouldPersistInDatabase() {
        // Given
        Logins login = Logins.builder()
                .login("user1")
                .password("password123")
                .email("user1@example.com")
                .time(LocalDateTime.now())
                .build();
        loginsRepository.save(login);

        Orders order = Orders.builder()
                .login(login)
                .totalPrice(BigDecimal.valueOf(100.50))
                .status(Status.NEW)
                .time(LocalDateTime.now())
                .build();

        // When
        Orders savedOrder = ordersRepository.save(order);

        // Then
        assertThat(savedOrder.getId()).isNotNull();
        assertThat(savedOrder.getLogin()).isEqualTo(login);
        assertThat(savedOrder.getTotalPrice()).isEqualTo(BigDecimal.valueOf(100.50));
        assertThat(savedOrder.getStatus()).isEqualTo(Status.NEW);
    }

    @Test
    void givenOrder_whenFindByIdAndLoginIdAndStatus_thenReturnOrder() {
        // Given
        Logins login = Logins.builder()
                .login("user2")
                .password("password123")
                .email("user2@example.com")
                .time(LocalDateTime.now())
                .build();
        loginsRepository.save(login);

        Orders order = Orders.builder()
                .login(login)
                .totalPrice(BigDecimal.valueOf(150.00))
                .status(Status.PAYED)
                .time(LocalDateTime.now())
                .build();
        Orders savedOrder = ordersRepository.save(order);

        // When
        Optional<Orders> result = ordersRepository.findByIdAndLogin_IdAndStatus(savedOrder.getId(), login.getId(), Status.PAYED);

        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(savedOrder.getId());
        assertThat(result.get().getStatus()).isEqualTo(Status.PAYED);
    }

    @Test
    void givenOrder_whenFindOrdersByLoginId_thenReturnListOfOrders() {
        // Given
        Logins login = Logins.builder()
                .login("user3")
                .password("password123")
                .email("user3@example.com")
                .time(LocalDateTime.now())
                .build();
        loginsRepository.save(login);

        Orders order1 = Orders.builder()
                .login(login)
                .totalPrice(BigDecimal.valueOf(200.00))
                .status(Status.COOKING)
                .time(LocalDateTime.now())
                .build();

        Orders order2 = Orders.builder()
                .login(login)
                .totalPrice(BigDecimal.valueOf(120.00))
                .status(Status.NEW)
                .time(LocalDateTime.now())
                .build();

        ordersRepository.save(order1);
        ordersRepository.save(order2);

        // When
        List<Orders> orders = ordersRepository.findOrdersByLogin_Id(login.getId());

        // Then
        assertThat(orders).hasSize(2);
        assertThat(orders).extracting(Orders::getLogin).containsOnly(login);
    }

    @Test
    void givenOrder_whenUpdateStatus_thenShouldChangeStatus() {
        // Given
        Logins login = Logins.builder()
                .login("user4")
                .password("password123")
                .email("user4@example.com")
                .time(LocalDateTime.now())
                .build();
        loginsRepository.save(login);

        Orders order = Orders.builder()
                .login(login)
                .totalPrice(BigDecimal.valueOf(50.00))
                .status(Status.NEW)
                .time(LocalDateTime.now())
                .build();
        Orders savedOrder = ordersRepository.save(order);

        // When
        ordersRepository.updateStatus(savedOrder.getId(), Status.PAYMENT_CONFIRM);

        // Then
        Optional<Orders> updatedOrder = ordersRepository.findById(savedOrder.getId());
        assertThat(updatedOrder).isPresent();
        assertThat(updatedOrder.get().getStatus()).isEqualTo(Status.PAYMENT_CONFIRM);
    }

    @Test
    void givenOrder_whenSaveWithInvalidData_thenShouldThrowException() {
        // Given
        Logins login = Logins.builder()
                .login("user5")
                .password("password123")
                .email("user5@example.com")
                .time(LocalDateTime.now())
                .build();
        loginsRepository.save(login);

        Orders order = Orders.builder()
                .login(login)
                .totalPrice(BigDecimal.valueOf(-10.00))  // Invalid total price
                .status(Status.NEW)
                .time(LocalDateTime.now())
                .build();

        // When & Then
        assertThatThrownBy(() -> ordersRepository.save(order))
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("check constraint violation");
    }
}