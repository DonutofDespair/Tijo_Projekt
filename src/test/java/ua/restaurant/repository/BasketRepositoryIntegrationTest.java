package ua.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ua.restaurant.entity.Baskets;
import ua.restaurant.entity.Dishes;
import ua.restaurant.entity.Logins;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Rollback
class BasketRepositoryIntegrationTest {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void givenBasketsByLoginId_whenFindAllByLoginId_thenReturnBasketsList() {
        // Given
        Logins login = Logins.builder()
                .login("testUser")
                .password("password123")
                .email("test@example.com")
                .role(null)
                .time(LocalDateTime.now())
                .build();
        entityManager.persist(login);

        Dishes dish = Dishes.builder()
                .nameEn("Test Dish")
                .price(BigDecimal.valueOf(12.99))
                .time(LocalDateTime.now())
                .build();
        entityManager.persist(dish);

        Baskets basket = Baskets.builder()
                .login(login)
                .dishes(dish)
                .build();
        entityManager.persist(basket);

        // When
        List<Baskets> basketsList = basketRepository.findAllByLogin_Id(login.getId());

        // Then
        assertThat(basketsList).hasSize(1);
        assertThat(basketsList.get(0).getLogin().getLogin()).isEqualTo("testUser");
    }

    @Test
    void givenBasketByDishId_whenFindBasketsByDishesId_thenReturnBasket() {
        // Given
        Logins login = Logins.builder()
                .login("testUser")
                .password("password123")
                .email("test@example.com")
                .time(LocalDateTime.now())
                .build();
        entityManager.persist(login);

        Dishes dish = Dishes.builder()
                .nameEn("Test Dish")
                .price(BigDecimal.valueOf(10.99))
                .time(LocalDateTime.now())
                .build();
        entityManager.persist(dish);

        Baskets basket = Baskets.builder()
                .login(login)
                .dishes(dish)
                .build();
        entityManager.persist(basket);

        // When
        List<Baskets> result = basketRepository.findBasketsByDishes_Id(dish.getId());

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getDishes().getNameEn()).isEqualTo("Test Dish");
    }

    @Test
    void givenBaskets_whenDeleteByLoginId_thenRemoveBaskets() {
        // Given
        Logins login = Logins.builder()
                .login("testDeleteUser")
                .password("password123")
                .email("delete@example.com")
                .time(LocalDateTime.now())
                .build();
        entityManager.persist(login);

        Dishes dish = Dishes.builder()
                .nameEn("Dish to Delete")
                .price(BigDecimal.valueOf(8.99))
                .time(LocalDateTime.now())
                .build();
        entityManager.persist(dish);

        Baskets basket = Baskets.builder()
                .login(login)
                .dishes(dish)
                .build();
        entityManager.persist(basket);

        // When
        basketRepository.deleteByLogin_Id(login.getId());
        List<Baskets> result = basketRepository.findAllByLogin_Id(login.getId());

        // Then
        assertThat(result).isEmpty();
    }
}
