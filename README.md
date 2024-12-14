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

## **Autorzy**

- **Imię Nazwisko** - Magdalena Kłósek, Wszołek Konrad


