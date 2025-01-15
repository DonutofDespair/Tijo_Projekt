# 🍽️ **Restauracyjna Aplikacja Webowa**

## **Opis projektu**

Aplikacja restauracyjna umożliwia klientom przeglądanie menu, zarządzanie koszykiem i składanie zamówień. Menedżerowie mogą dodawać, edytować oraz usuwać produkty, a także zarządzać zamówieniami. System oferuje rejestrację i logowanie użytkowników.

---

## **Technologie użyte w projekcie**

- **Backend**: Spring Boot (Java)  
- **Frontend**: HTML, CSS, JavaScript (lub framework jak React / Angular)  
- **Baza danych**: MySQL / PostgreSQL  
- **Komunikacja**: RESTful API  

---

## **Funkcjonalności**

### **Dla klienta:**
1. Rejestracja i logowanie do systemu.  
2. Przeglądanie menu z podziałem na kategorie.  
3. Dodawanie produktów do koszyka.  
4. Zarządzanie ilością produktów w koszyku.  
5. Składanie zamówień.  

### **Dla menedżera:**
1. Dodawanie, edytowanie i usuwanie produktów w menu.  
2. Zarządzanie zamówieniami: zmiana statusu, usuwanie, filtrowanie.   

---

## **Testy manualne**

### **1. Rejestracja i Logowanie**

| **ID**  | **Tytuł**                             | **Warunki początkowe**                  | **Kroki testowe**                                                                 | **Oczekiwany rezultat**                         |
|---------|---------------------------------------|----------------------------------------|----------------------------------------------------------------------------------|------------------------------------------------|
| TC001   | Rejestracja z poprawnymi danymi       | Strona rejestracji otwarta             | 1. Wprowadź poprawny email. <br>2. Wprowadź hasło.<br>3. Kliknij „Zarejestruj”.   | Użytkownik zostaje zarejestrowany.             |
| TC002   | Rejestracja z brakującymi danymi      | Strona rejestracji otwarta             | 1. Zostaw pole „email” puste.<br>2. Kliknij „Zarejestruj”.                        | Komunikat: „Pole email jest wymagane”.         |
| TC003   | Logowanie z poprawnymi danymi         | Strona logowania otwarta               | 1. Wprowadź poprawny email.<br>2. Wprowadź hasło.<br>3. Kliknij „Zaloguj”.        | Użytkownik zostaje zalogowany.                 |
| TC004   | Logowanie z błędnymi danymi           | Strona logowania otwarta               | 1. Wprowadź nieprawidłowe hasło.<br>2. Kliknij „Zaloguj”.                         | Komunikat: „Nieprawidłowe dane logowania”.     |
| TC005   | Logowanie bez podania danych          | Strona logowania otwarta               | 1. Zostaw puste pola email i hasło.<br>2. Kliknij „Zaloguj”.                      | Komunikat: „Wszystkie pola są wymagane”.       |
| TC006   | Rejestracja z nieprawidłowym formatem email | Strona rejestracji otwarta             | 1. Wprowadź „test” jako email.<br>2. Wprowadź hasło.<br>3. Kliknij „Zarejestruj”. | Komunikat: „Nieprawidłowy format email”.       |

---

### **2. Menu i produkty**

| **ID**  | **Tytuł**                             | **Warunki początkowe**                  | **Kroki testowe**                                                                 | **Oczekiwany rezultat**                         |
|---------|---------------------------------------|----------------------------------------|----------------------------------------------------------------------------------|------------------------------------------------|
| TC007   | Wyświetlanie listy menu               | Klient zalogowany                      | 1. Przejdź do sekcji „Menu”.                                                     | Lista produktów wyświetla się poprawnie.       |
| TC008   | Dodanie nowego produktu (manager)     | Menedżer zalogowany                    | 1. Kliknij „Dodaj produkt”. <br>2. Uzupełnij pola: nazwa, cena, kategoria. <br>3. Zapisz. | Produkt pojawia się w menu.                    |
| TC009   | Usuwanie produktu z menu              | Menedżer zalogowany, produkt istnieje  | 1. Kliknij „Usuń” przy produkcie. <br>2. Potwierdź akcję.                         | Produkt znika z listy menu.                    |
| TC010   | Edycja istniejącego produktu          | Menedżer zalogowany, produkt istnieje  | 1. Kliknij „Edytuj”. <br>2. Zmień nazwę produktu.<br>3. Zapisz zmiany.            | Zmiany w produkcie są widoczne w menu.         |
| TC011   | Dodanie produktu bez nazwy            | Menedżer zalogowany                    | 1. Kliknij „Dodaj produkt”. <br>2. Zostaw pole nazwa puste.<br>3. Zapisz.         | Komunikat: „Pole nazwa jest wymagane”.         |
| TC012   | Przeglądanie menu z podziałem na kategorie | Klient zalogowany                      | 1. Otwórz menu.<br>2. Wybierz kategorię „Desery”.                                 | Wyświetlają się produkty tylko z tej kategorii. |

---

### **3. Koszyk**

| **ID**  | **Tytuł**                             | **Warunki początkowe**                  | **Kroki testowe**                                                                 | **Oczekiwany rezultat**                         |
|---------|---------------------------------------|----------------------------------------|----------------------------------------------------------------------------------|------------------------------------------------|
| TC013   | Dodanie produktu do koszyka           | Klient zalogowany, menu otwarte         | 1. Wybierz produkt.<br>2. Kliknij „Dodaj do koszyka”.                             | Produkt pojawia się w koszyku.                  |
| TC014   | Zmiana ilości produktu w koszyku      | Produkt w koszyku                       | 1. Zmień ilość produktu na 2.<br>2. Zapisz zmiany.                                | Ilość produktu zmienia się poprawnie.           |
| TC015   | Usunięcie produktu z koszyka          | Produkt w koszyku                       | 1. Kliknij „Usuń” przy produkcie.                                                | Produkt znika z koszyka.                        |
| TC016   | Przeglądanie podsumowania koszyka     | Produkt w koszyku                       | 1. Przejdź do sekcji „Koszyk”.                                                   | Wyświetla się lista produktów oraz łączna cena. |

---

### **4. Zamówienia**

| ID      | Tytuł                                    | Warunki początkowe                       | Kroki testowe                                                                | Oczekiwany rezultat                         |
|---------|------------------------------------------|------------------------------------------|------------------------------------------------------------------------------|------------------------------------------------|
| TC017   | Składanie zamówienia z koszyka           | Produkty w koszyku                       | 1. Kliknij „Zamów”.<br>2. Potwierdź dane.                                    | Zamówienie zostaje złożone.                    |
| TC018   | Przeglądanie statusu zamówienia          | Klient ma aktywne zamówienie             | 1. Przejdź do sekcji „Moje zamówienia”.                                      | Status zamówienia wyświetla się poprawnie.     |
| TC019   | Zmiana statusu zamówienia przez managera | Menedżer zalogowany, zamówienie istnieje | 1. Zmień status na „W trakcie realizacji”.                                   | Status zamówienia zmienia się poprawnie.       |
| TC020   | Usunięcie zamówienia (manager)           | Menedżer zalogowany, zamówienie istnieje | 1. Kliknij „Usuń zamówienie”.<br>2. Potwierdź akcję.                         | Zamówienie zostaje usunięte.                   |

---

## Testy jednostkowe

Projekt zawiera testy jednostkowe dla kluczowych kontrolerów. Poniżej opisano pokrycie funkcjonalne oraz główne przypadki testowe.

### 1. **CategoriesControllerTest**
Testy dla kontrolera obsługującego kategorie.

#### Przypadki testowe:
1. **Kiedy kategorie istnieją**:
   - Zwrot listy kategorii.
   - Status odpowiedzi: `200 OK`.
   - Sprawdzenie poprawności danych w odpowiedzi.
2. **Kiedy kategorie nie istnieją**:
   - Zwrot pustej listy.
   - Status odpowiedzi: `200 OK`.
3. **Logowanie**:
   - Sprawdzenie wywołania logów w metodzie `getAllDishes`.

---

### 2. **MainControllerTest**
Testy dla kontrolera obsługującego paginację dań.

#### Przypadki testowe:
1. **Poprawne dane wejściowe**:
   - Zwrot danych paginowanych.
   - Status odpowiedzi: `200 OK`.
2. **Błąd wewnętrzny (np. problem z bazą danych)**:
   - Rzucenie wyjątku `ResponseStatusException`.
   - Status odpowiedzi: `400 BAD REQUEST`.
3. **Logowanie**:
   - Sprawdzenie wywołania logów w metodzie `findPaginated`.

---

### 3. **OrdersControllerTest**
Testy dla kontrolera obsługującego zamówienia.

#### Przypadki testowe:
1. **Pobieranie zamówień użytkownika**:
   - Zwrot listy zamówień.
   - Status odpowiedzi: `200 OK`.
   - Obsługa pustej listy zamówień.
2. **Pobieranie wszystkich zamówień (dla menedżera)**:
   - Zwrot listy zamówień.
   - Status odpowiedzi: `200 OK`.
3. **Tworzenie zamówienia**:
   - Zwrot utworzonego zamówienia.
   - Obsługa błędów (np. brak elementów w koszyku) – rzucenie `ResponseStatusException`.
   - Status odpowiedzi: `400 BAD REQUEST` w przypadku błędów.
4. **Logowanie**:
   - Sprawdzenie wywołania logów w metodach.

---

## Testy dla `Categories`

### Lista testów:

1. **Test tworzenia obiektu Categories**  
   Sprawdza, czy obiekt `Categories` jest tworzony poprawnie na podstawie danych wejściowych.

   - **Testowana metoda:** `builder()`
   - **Przykład danych wejściowych:**  
     ```java
     Long expectedId = 1L;
     String expectedCategory = "Food";
     ```
   - **Oczekiwany wynik:**  
     Obiekt `Categories` ma przypisane poprawne wartości pól `id` i `categoryEn`.

2. **Test metody `toString()`**  
   Sprawdza, czy metoda `toString()` zwraca poprawny ciąg znaków opisujący obiekt.

   - **Przykład danych wyjściowych:**  
     `"Categories(id=1, categoryEn=Food)"`

---

## Testy dla `Dishes`

### Lista testów:

1. **Walidacja poprawności pola `nameEn`**  
   Sprawdza, czy pole `nameEn` przechodzi walidację dla niepoprawnych wartości, takich jak zawierające znaki specjalne.

   - **Przykład danych wejściowych:**  
     `"Invalid@Name!"`
   - **Oczekiwany wynik:**  
     Walidacja powinna zakończyć się niepowodzeniem.

2. **Test generowania ID**  
   Weryfikuje, czy ID dla obiektu `Dishes` jest generowane poprawnie.

   - **Oczekiwany wynik:**  
     Pole `id` nie jest `null` i zgadza się z podaną wartością.

3. **Test relacji z kategorią**  
   Sprawdza, czy kategoria jest poprawnie przypisywana do dania.

   - **Oczekiwany wynik:**  
     Obiekt `Categories` jest powiązany z daniem i nie jest `null`.

---

## Testy dla `Orders`

### Lista testów:

1. **Test ustawiania statusu zamówienia**  
   Sprawdza, czy pole `status` jest poprawnie ustawiane.

   - **Przykład danych wejściowych:**  
     `Status.NEW`
   - **Oczekiwany wynik:**  
     Wartość pola `status` zgadza się z oczekiwaną.

2. **Test ustawiania całkowitej ceny**  
   Sprawdza, czy pole `totalPrice` jest poprawnie ustawiane.

   - **Przykład danych wejściowych:**  
     `BigDecimal.valueOf(100.50)`
   - **Oczekiwany wynik:**  
     Wartość pola `totalPrice` zgadza się z oczekiwaną.

3. **Test przypisywania logowania użytkownika**  
   Sprawdza, czy obiekt `Logins` jest poprawnie przypisywany do zamówienia.

   - **Przykład danych wejściowych:**  
     Obiekt `Logins` z `id = 1L`.
   - **Oczekiwany wynik:**  
     Obiekt `Logins` jest poprawnie przypisany do zamówienia.

4. **Test ustawiania czasu zamówienia**  
   Weryfikuje, czy pole `time` jest poprawnie ustawiane.

   - **Przykład danych wejściowych:**  
     `LocalDateTime.now()`
   - **Oczekiwany wynik:**  
     Wartość pola `time` zgadza się z oczekiwaną.

5. **Kompletny test konfiguracji zamówienia**  
   Testuje pełną konfigurację zamówienia, w tym pola `status`, `totalPrice`, `time` oraz relację z użytkownikiem.

   - **Przykład danych wejściowych:**  
     - `Status.PAYED`
     - `BigDecimal.valueOf(250.75)`
     - `LocalDateTime.now()`
     - Obiekt `Logins` z `id = 2L`.
   - **Oczekiwany wynik:**  
     Wszystkie pola są poprawnie ustawione, a relacje są prawidłowe.

---

## **Autorzy**

- **Imię Nazwisko** - Magdalena Kłósek, Wszołek Konrad


