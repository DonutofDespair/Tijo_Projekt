package ua.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ua.restaurant.entity.Categories;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Rollback
public class CategoriesRepositoryIntegrationTest {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void givenCategoryId_whenFoundById_thenReturnCategory() {
        // Given
        Categories category = Categories.builder()
                .categoryEn("Appetizers")
                .build();
        categoriesRepository.save(category);
        entityManager.flush();

        // When
        Categories foundCategory = categoriesRepository.findById(category.getId()).orElse(null);

        // Then
        assertThat(foundCategory).isNotNull();
        assertThat(foundCategory.getCategoryEn()).isEqualTo("Appetizers");
    }

    @Test
    void givenCategoriesInRepository_whenFindAll_thenReturnAllCategories() {
        // Given
        Categories category1 = Categories.builder()
                .categoryEn("Salads")
                .build();
        categoriesRepository.save(category1);

        Categories category2 = Categories.builder()
                .categoryEn("Main Courses")
                .build();
        categoriesRepository.save(category2);

        entityManager.flush();

        // When
        Iterable<Categories> categories = categoriesRepository.findAll();

        // Then
        assertThat(categories).hasSize(9);
    }
}
