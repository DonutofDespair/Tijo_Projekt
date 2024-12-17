package ua.restaurant.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrdersTest {

    @Mock
    private Logins mockLogin;

    @InjectMocks
    private Orders orders;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testSetStatus() {
        // Given
        Status expectedStatus = Status.NEW;

        // When
        orders.setStatus(expectedStatus);

        // Then
        assertEquals(expectedStatus, orders.getStatus());
    }

    @Test
    void testSetTotalPrice() {
        // Given
        BigDecimal expectedPrice = BigDecimal.valueOf(100.50);

        // When
        orders.setTotalPrice(expectedPrice);

        // Then
        assertEquals(expectedPrice, orders.getTotalPrice());
    }


    @Test
    void testSetLogin() {
        // Given
        when(mockLogin.getId()).thenReturn(1L);

        // When
        orders.setLogin(mockLogin);

        // Then
        assertNotNull(orders.getLogin());
        assertEquals(1L, orders.getLogin().getId());
    }

    @Test
    void testSetTime() {
        // Given
        LocalDateTime expectedTime = LocalDateTime.now();

        // When
        orders.setTime(expectedTime);

        // Then
        assertEquals(expectedTime, orders.getTime());
    }

    @Test
    void testFullOrderSetup() {
        // Given
        Status expectedStatus = Status.PAYED;
        BigDecimal expectedPrice = BigDecimal.valueOf(250.75);
        LocalDateTime expectedTime = LocalDateTime.now();
        when(mockLogin.getId()).thenReturn(2L);

        // When
        orders.setStatus(expectedStatus);
        orders.setTotalPrice(expectedPrice);
        orders.setTime(expectedTime);
        orders.setLogin(mockLogin);

        // Then
        assertEquals(expectedStatus, orders.getStatus());
        assertEquals(expectedPrice, orders.getTotalPrice());
        assertEquals(expectedTime, orders.getTime());
        assertNotNull(orders.getLogin());
        assertEquals(2L, orders.getLogin().getId());
    }
}