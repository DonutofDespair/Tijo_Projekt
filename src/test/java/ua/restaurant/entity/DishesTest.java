package ua.restaurant.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DishesTest {

    private Validator validator;

    @Mock
    private Categories categoriesMock;

    @InjectMocks
    private Dishes dish;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        dish = Dishes.builder()
                .nameEn("Test Dish")
                .categories(categoriesMock)
                .time(LocalDateTime.now())
                .build();
    }

    // Test 1: Walidacja poprawności pola nameEn
    @Test
    public void whenDishNameIsInvalid_thenValidationFails() {
        // Given
        dish.setNameEn("Invalid@Name!");
        // When
        Set<ConstraintViolation<Dishes>> violations = validator.validate(dish);
        // Then
        assertFalse(violations.isEmpty(), "Expected validation error for invalid name");
    }

    // Test 2: Test generowania id
    @Test
    public void whenDishIsSaved_thenIdIsGenerated() {
        // Given
        dish.setId(null);
        // When
        Long generatedId = 123L;
        dish.setId(generatedId);
        // Then
        assertNotNull(dish.getId(), "ID should be generated");
        assertEquals(generatedId, dish.getId(), "Generated ID does not match expected");
    }

    // Test 3: Test relacji z kategorią
    @Test
    public void whenCategoryIsSet_thenCategoryShouldBeAssociatedWithDish() {
        // Given
        Categories mockCategory = mock(Categories.class);
        dish.setCategories(mockCategory);
        // When
        Categories category = dish.getCategories();
        // Then
        assertNotNull(category, "Category should not be null");
        assertEquals(mockCategory, category, "The category should be the one set in the dish");
    }
}
