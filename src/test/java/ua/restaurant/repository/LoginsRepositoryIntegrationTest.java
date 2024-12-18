package ua.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import ua.restaurant.entity.Logins;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Rollback
class LoginsRepositoryIntegrationTest {

    @Autowired
    private LoginsRepository loginsRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void givenLogin_whenFindByLogin_thenReturnLogin() {
        // Given
        Logins login = Logins.builder()
                .login("testUser")
                .password("password123")
                .email("test@example.com")
                .time(LocalDateTime.now())
                .build();
        entityManager.persist(login);

        // When
        Optional<Logins> result = loginsRepository.findByLogin("testUser");

        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getEmail()).isEqualTo("test@example.com");
    }

    @Test
    void givenLogin_whenFindById_thenReturnLogin() {
        // Given
        Logins login = Logins.builder()
                .login("anotherUser")
                .password("password123")
                .email("another@example.com")
                .time(LocalDateTime.now())
                .build();
        Logins savedLogin = loginsRepository.save(login);


        // When
        Optional<Logins> result = loginsRepository.findById(savedLogin.getId());

        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getLogin()).isEqualTo("anotherUser");
    }

    @Test
    void givenLogin_whenDelete_thenShouldRemoveLogin() {
        // Given
        Logins login = Logins.builder()
                .login("deleteUser")
                .password("passwordToDelete")
                .email("delete@example.com")
                .time(LocalDateTime.now())
                .build();
        Logins savedLogin = loginsRepository.save(login);


        // When
        loginsRepository.deleteById(savedLogin.getId());
        Optional<Logins> result = loginsRepository.findById(savedLogin.getId());

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    void givenLogin_whenSave_thenShouldPersistInDatabase() {
        // Given
        Logins login = Logins.builder()
                .login("newUser")
                .password("newPassword123")
                .email("newuser@example.com")
                .time(LocalDateTime.now())
                .build();

        // When
        Logins savedLogin = loginsRepository.save(login);

        // Then
        assertThat(savedLogin.getId()).isNotNull();
        Optional<Logins> result = loginsRepository.findById(savedLogin.getId());
        assertThat(result).isPresent();
        assertThat(result.get().getLogin()).isEqualTo("newUser");
    }

    @Test
    @Transactional
    void shouldThrowException_whenSavingDuplicateLogin() {
        // Given: Zapisanie pierwszego użytkownika z loginem
        Logins firstLogin = Logins.builder()
                .login("duplicateLogin") // Ten login będzie powtarzany
                .password("password123")
                .email("user1@example.com")
                .time(LocalDateTime.now())
                .build();

        loginsRepository.save(firstLogin); // Pierwszy użytkownik zapisany

        // When: Próba zapisania drugiego użytkownika z tym samym loginem
        Logins secondLogin = Logins.builder()
                .login("duplicateLogin") // Ten login jest już w bazie
                .password("password456")
                .email("user2@example.com")
                .time(LocalDateTime.now())
                .build();

        // Then: Oczekujemy, że zostanie rzucony wyjątek DataIntegrityViolationException
        try {
            loginsRepository.save(secondLogin);
            fail("Expected DataIntegrityViolationException to be thrown");
        } catch (DataIntegrityViolationException ex) {
            // Expected exception
        }
    }
}
