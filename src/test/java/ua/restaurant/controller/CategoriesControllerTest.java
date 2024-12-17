package ua.restaurant.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import ua.restaurant.dto.CategoryDTO;
import ua.restaurant.service.CategoriesService;
import ua.restaurant.config.Bundler;
import ua.restaurant.utils.Constants;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class) // Anotacja do uruchomienia mockowania w testach
class CategoriesControllerTest {

    @Mock
    private CategoriesService categoriesService;  // Mockowanie CategoriesService

    @Mock
    private Bundler bundler;  // Mockowanie Bundler

    @InjectMocks
    private CategoriesController categoriesController;  // mocki do kontrolera

    private List<CategoryDTO> mockCategoryList;

    @BeforeEach
    void setUp() {
        // dane do testów
        mockCategoryList = Arrays.asList(
                new CategoryDTO(1L, "Starters"),
                new CategoryDTO(2L, "Main Courses"),
                new CategoryDTO(3L, "Desserts")
        );
    }

    @Test
    void givenCategoriesExist_whenGetAllCategories_thenReturnCategories() {
        // Given
        when(categoriesService.findAllCategories()).thenReturn(mockCategoryList);
        when(bundler.getLogMsg(Constants.CATEGORIES_ALL)).thenReturn("Fetching all categories");

        // When
        ResponseEntity<List<CategoryDTO>> response = categoriesController.getAllDishes();

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockCategoryList.size(), response.getBody().size());
        assertEquals(mockCategoryList.get(0).getCategory(), response.getBody().get(0).getCategory());
    }

    @Test
    void givenNoCategories_whenGetAllCategories_thenReturnEmptyList() {
        // Given
        when(categoriesService.findAllCategories()).thenReturn(Arrays.asList());

        // When
        ResponseEntity<List<CategoryDTO>> response = categoriesController.getAllDishes();

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    void whenGetCategories_thenLogMessageIsCalled() {
        // Given
        when(categoriesService.findAllCategories()).thenReturn(mockCategoryList);
        when(bundler.getLogMsg(Constants.CATEGORIES_ALL)).thenReturn("Fetching all categories");

        // When
        categoriesController.getAllDishes();

        // Then
        verify(bundler, times(1)).getLogMsg(Constants.CATEGORIES_ALL);
    }
}
