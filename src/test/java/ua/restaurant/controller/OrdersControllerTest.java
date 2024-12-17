package ua.restaurant.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import ua.restaurant.dto.ItemDTO;
import ua.restaurant.entity.Orders;
import ua.restaurant.entity.Status;
import ua.restaurant.service.OrdersService;
import ua.restaurant.config.Bundler;
import ua.restaurant.utils.Constants;
import ua.restaurant.utils.ContextHelpers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import ua.restaurant.security.UserDetailsImpl;
import ua.restaurant.entity.Logins;


@ExtendWith(MockitoExtension.class)
class OrdersControllerTest {

    @Mock
    private OrdersService ordersService;

    @Mock
    private Bundler bundler;

    @InjectMocks
    private OrdersController ordersController;

    private List<Orders> mockOrdersList;
    private Orders mockOrder;


    @BeforeEach
    void setUp() {
        // Tworzymy mock Login
        Logins mockLogin = new Logins();
        mockLogin.setLogin("mockUser");  // Ustawienie loginu

        UserDetailsImpl mockUserDetails = mock(UserDetailsImpl.class);
        when(mockUserDetails.getLogin()).thenReturn(mockLogin);

        Authentication mockAuth = mock(Authentication.class);
        when(mockAuth.getPrincipal()).thenReturn(mockUserDetails);

        SecurityContext mockSecurityContext = mock(SecurityContext.class);
        when(mockSecurityContext.getAuthentication()).thenReturn(mockAuth);
        SecurityContextHolder.setContext(mockSecurityContext);

        mockOrder = Orders.builder()
                .id(1L)
                .totalPrice(BigDecimal.valueOf(100.00))
                .status(Status.NEW)
                .time(LocalDateTime.now())
                .build();

        mockOrdersList = Arrays.asList(mockOrder);

        lenient().when(ordersService.findAllUserOrders()).thenReturn(mockOrdersList);
        lenient().when(bundler.getLogMsg(Constants.ORDERS_ALL)).thenReturn("Fetching user orders: ");
    }


    @AfterEach
    void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void givenOrdersExist_whenGetOrders_thenReturnOrders() {
        // Given
        when(ordersService.findAllUserOrders()).thenReturn(mockOrdersList);
        when(bundler.getLogMsg(Constants.ORDERS_ALL)).thenReturn("Fetching user orders: ");

        // When
        ResponseEntity<List<Orders>> response = ordersController.getOrders();

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockOrdersList.size(), response.getBody().size());
        assertEquals(mockOrder.getId(), response.getBody().get(0).getId());
        verify(bundler, times(1)).getLogMsg(Constants.ORDERS_ALL);
    }

    @Test
    void givenNoOrders_whenGetOrders_thenReturnEmptyList() {
        // Given
        when(ordersService.findAllUserOrders()).thenReturn(Collections.emptyList());

        // When
        ResponseEntity<List<Orders>> response = ordersController.getOrders();

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    void givenOrdersExist_whenGetAllOrders_thenReturnOrders() {
        // Given
        when(ordersService.findAllOrders()).thenReturn(mockOrdersList);
        when(bundler.getLogMsg(Constants.ORDERS_ALL_MANAGER)).thenReturn("Fetching all orders: ");

        // When
        ResponseEntity<List<Orders>> response = ordersController.getAllOrders();

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockOrdersList.size(), response.getBody().size());
        verify(bundler, times(1)).getLogMsg(Constants.ORDERS_ALL_MANAGER);
    }

    @Test
    void whenCreateOrder_thenReturnSavedOrder() {
        // Given
        when(ordersService.saveNewItem()).thenReturn(mockOrder);
        when(bundler.getLogMsg(Constants.ORDERS_CREATE)).thenReturn("Creating new order: ");

        // When
        ResponseEntity<Orders> response = ordersController.create();

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockOrder.getId(), response.getBody().getId());
        verify(ordersService, times(1)).saveNewItem();
    }
    @Test
    void whenCreateOrderFails_thenThrowResponseStatusException() {
        // Given
        when(ordersService.saveNewItem()).thenThrow(new NoSuchElementException("Basket is empty"));

        // When / Then
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> ordersController.create());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertEquals("Basket is empty", exception.getReason());
    }

}