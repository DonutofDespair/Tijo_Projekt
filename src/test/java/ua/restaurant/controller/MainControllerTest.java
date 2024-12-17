package ua.restaurant.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import ua.restaurant.dto.PageableDishesDTO;
import ua.restaurant.service.DishesService;
import ua.restaurant.config.Bundler;
import ua.restaurant.utils.Constants;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @Mock
    private DishesService dishesService;

    @Mock
    private Bundler bundler;

    @InjectMocks
    private MainController mainController;

    private PageableDishesDTO pageableDishesDTO;

    @BeforeEach
    void setUp() {
        pageableDishesDTO = new PageableDishesDTO();
        pageableDishesDTO.setDishes(Collections.emptyList());
    }

    @Test
    void givenValidPage_whenGetDishes_thenReturnPageableDishes() {
        // Given
        int pageNo = 1;
        String sortField = "name";
        String sortDirection = "asc";
        Long categoryId = 2L;

        when(dishesService.findAllDishesPaginated(pageNo, sortField, sortDirection, categoryId))
                .thenReturn(pageableDishesDTO);

        when(bundler.getLogMsg(Constants.DISHES_ALL_PAGE)).thenReturn("Fetching page of dishes: ");
        // When
        ResponseEntity<PageableDishesDTO> response = mainController.findPaginated(pageNo, sortField, sortDirection, categoryId);

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(pageableDishesDTO, response.getBody());
        assertEquals("Fetching page of dishes: 1", bundler.getLogMsg(Constants.DISHES_ALL_PAGE) + pageNo);
    }

    @Test
    void givenExceptionThrown_whenGetDishes_thenThrowResponseStatusException() {
        // Given
        int pageNo = 1;
        String sortField = "name";
        String sortDirection = "asc";
        Long categoryId = 2L;

        when(dishesService.findAllDishesPaginated(pageNo, sortField, sortDirection, categoryId))
                .thenThrow(new RuntimeException("Database error"));

        // When
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            mainController.findPaginated(pageNo, sortField, sortDirection, categoryId);
        });

        // Then
        assertEquals(HttpStatus.BAD_REQUEST, ((ResponseStatusException) exception).getStatus());
        assertEquals("Database error", ((ResponseStatusException) exception).getReason());
    }

    @Test
    void whenGetDishes_thenLogMessageIsCalled() {
        // Given
        int pageNo = 1;
        String sortField = "name";
        String sortDirection = "asc";
        Long categoryId = 2L;

        when(dishesService.findAllDishesPaginated(pageNo, sortField, sortDirection, categoryId))
                .thenReturn(pageableDishesDTO);
        when(bundler.getLogMsg(Constants.DISHES_ALL_PAGE)).thenReturn("Fetching page of dishes: ");

        // When
        mainController.findPaginated(pageNo, sortField, sortDirection, categoryId);

        // Then
        verify(bundler, times(1)).getLogMsg(Constants.DISHES_ALL_PAGE);
    }
}
