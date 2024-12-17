package ua.restaurant.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoriesTest {

    // Test 1: Testowanie tworzenia obiektu Categories
    @Test
    public void givenCategoryData_whenCategoryIsCreated_thenCategoryHasCorrectValues() {
        // Given
        Long expectedId = 1L;
        String expectedCategory = "Food";
        // When
        Categories category = Categories.builder()
                .id(expectedId)
                .categoryEn(expectedCategory)
                .build();
        // Then
        assertNotNull(category);
        assertEquals(expectedId, category.getId());
        assertEquals(expectedCategory, category.getCategoryEn());
    }

    // Test 2: Testowanie metody toString()
    @Test
    public void givenCategory_whenToStringIsCalled_thenCorrectStringIsReturned() {
        // Given
        Categories category = Categories.builder()
                .id(1L)
                .categoryEn("Food")
                .build();
        // When
        String result = category.toString();
        // Then
        String expectedToString = "Categories(id=1, categoryEn=Food)";
        assertEquals(expectedToString, result);
    }

}
