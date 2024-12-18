package ua.restaurant.repository;

import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ua.restaurant.entity.Categories;
import ua.restaurant.entity.Dishes;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // Zapewnia użycie rzeczywistej bazy danych, nie w pamięci
@Rollback  // Automatycznie rollback po każdym teście
public class DishesRepositoryIntegrationTest {

    @Autowired
    private DishesRepository dishesRepository;

    @Autowired
    private EntityManager entityManager;

    // Test dodania nowego dania
    @Test
    void givenNewDish_whenSaved_thenDishShouldBePersisted() {
        // Given
        Categories category = new Categories();
        category.setCategoryEn("Desserts");
        entityManager.persist(category);

        Dishes dish = Dishes.builder()
                .nameEn("Chocolate Cake")
                .price(BigDecimal.valueOf(6.99))
                .categories(category)
                .time(LocalDateTime.now())
                .build();

        // When
        dishesRepository.save(dish);

        // Then
        assertThat(dish.getId()).isNotNull();  // Id musi zostać ustawione
        assertThat(dishesRepository.findById(dish.getId())).isPresent();  // Danie musi być zapisane w bazie
    }

    // Test aktualizacji istniejącego dania
    @Test
    void givenExistingDish_whenUpdated_thenDishShouldBeUpdated() {
        // Given
        Categories category = new Categories();
        category.setCategoryEn("Appetizers");
        entityManager.persist(category);

        Dishes dish = Dishes.builder()
                .nameEn("Caesar Salad")
                .price(BigDecimal.valueOf(4.99))
                .categories(category)
                .time(LocalDateTime.now())
                .build();
        dishesRepository.save(dish);

        // When
        dish.setNameEn("Updated Caesar Salad");
        dish.setPrice(BigDecimal.valueOf(5.49));
        dishesRepository.save(dish);

        // Then
        Optional<Dishes> updatedDish = dishesRepository.findById(dish.getId());
        assertThat(updatedDish).isPresent();
        assertThat(updatedDish.get().getNameEn()).isEqualTo("Updated Caesar Salad");
        assertThat(updatedDish.get().getPrice()).isEqualTo(BigDecimal.valueOf(5.49));
    }

    // Test usuwania dania
    @Test
    void givenDish_whenDeleted_thenDishShouldBeRemoved() {
        // Given
        Categories category = new Categories();
        category.setCategoryEn("Soups");
        entityManager.persist(category);

        Dishes dish = Dishes.builder()
                .nameEn("Tomato Soup")
                .price(BigDecimal.valueOf(4.49))
                .categories(category)
                .time(LocalDateTime.now())
                .build();
        dishesRepository.save(dish);

        // When
        dishesRepository.deleteById(dish.getId());

        // Then
        Optional<Dishes> deletedDish = dishesRepository.findById(dish.getId());
        assertThat(deletedDish).isNotPresent();  // Sprawdzamy, czy danie zostało usunięte
    }

    // Test dla zapytania findByNameEn z brakiem pasującego wyniku
    @Test
    void givenNonExistentDish_whenFindByNameEn_thenShouldReturnEmpty() {
        // Given
        Categories category = new Categories();
        category.setCategoryEn("Drinks");
        entityManager.persist(category);

        Dishes dish = Dishes.builder()
                .nameEn("Fizzy drink")
                .price(BigDecimal.valueOf(2.99))
                .categories(category)
                .time(LocalDateTime.now())
                .build();
        dishesRepository.save(dish);

        // When
        Optional<Dishes> foundDish = dishesRepository.findByNameEn("Pepsi");

        // Then
        assertThat(foundDish).isNotPresent();  // Sprawdzamy, że nie ma dania o nazwie "Pepsi"
    }

    @Test
    void givenCategoryId_whenFindByCategoriesId_thenReturnPageOfDishes() {
        // Given
        Categories category = new Categories();
        category.setCategoryEn("Main Courses");
        entityManager.persist(category);

        Dishes dish1 = Dishes.builder()
                .nameEn("Pasta")
                .price(BigDecimal.valueOf(8.99))
                .categories(category)
                .time(LocalDateTime.now())
                .build();
        Dishes dish2 = Dishes.builder()
                .nameEn("Pizza")
                .price(BigDecimal.valueOf(7.99))
                .categories(category)
                .time(LocalDateTime.now())
                .build();
        dishesRepository.save(dish1);
        dishesRepository.save(dish2);

        entityManager.flush();  // Wymusza zapis do bazy

        // When
        var page = dishesRepository.findByCategories_Id(category.getId(), Pageable.unpaged());

        // Then
        assertThat(page).hasSize(2);  // Powinno zwrócić 2 dania
    }
}