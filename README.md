# 🍽️ **Restauracyjna Aplikacja Webowa**

## **Opis projektu**

Aplikacja restauracyjna umożliwia klientom przeglądanie menu, zarządzanie koszykiem i składanie zamówień. Menedżerowie mogą dodawać, edytować oraz usuwać produkty, a także zarządzać zamówieniami. System oferuje rejestrację i logowanie użytkowników oraz walidację danych.

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

### **Obsługa błędów:**
- Walidacja danych podczas rejestracji, logowania oraz dodawania produktów.  
- Informowanie użytkownika o brakach lub błędach danych.  

---

## **Testy manualne**

### **1. Logowanie i Rejestracja**

| **ID**  | **Tytuł**                             | **Warunki początkowe**                  | **Kroki testowe**                                                                 | **Oczekiwany rezultat**                         |
|---------|---------------------------------------|----------------------------------------|----------------------------------------------------------------------------------|------------------------------------------------|
| TC001   | Rejestracja z poprawnymi danymi       | Strona rejestracji otwarta             | 1. Wprowadź poprawny email. <br>2. Wprowadź hasło.<br>3. Kliknij „Zarejestruj”.   | Użytkownik zostaje zarejestrowany.             |
| TC002   | Rejestracja z brakującymi danymi      | Strona rejestracji otwarta             | 1. Zostaw pole „email” puste.<br>2. Kliknij „Zarejestruj”.                        | Komunikat: „Pole email jest wymagane”.         |
| TC003   | Logowanie z poprawnymi danymi         | Strona logowania otwarta               | 1. Wprowadź poprawny email.<br>2. Wprowadź hasło.<br>3. Kliknij „Zaloguj”.        | Użytkownik zostaje zalogowany.                 |
| TC004   | Logowanie z błędnymi danymi           | Strona logowania otwarta               | 1. Wprowadź nieprawidłowe hasło.<br>2. Kliknij „Zaloguj”.                         | Komunikat: „Nieprawidłowe dane logowania”.     |
| TC005   | Logowanie bez podania danych          | Strona logowania otwarta               | 1. Zostaw puste pola email i hasło.<br>2. Kliknij „Zaloguj”.                      | Komunikat: „Wszystkie pola są wymagane”.       |

---

### **2. Menu i produkty**

| **ID**  | **Tytuł**                             | **Warunki początkowe**                  | **Kroki testowe**                                                                 | **Oczekiwany rezultat**                         |
|---------|---------------------------------------|----------------------------------------|----------------------------------------------------------------------------------|------------------------------------------------|
| TC006   | Wyświetlanie listy menu               | Klient zalogowany                      | 1. Przejdź do sekcji „Menu”.                                                     | Lista produktów wyświetla się poprawnie.       |
| TC007   | Dodanie nowego produktu (manager)     | Menedżer zalogowany                    | 1. Kliknij „Dodaj produkt”. <br>2. Uzupełnij pola: nazwa, cena, kategoria. <br>3. Zapisz. | Produkt pojawia się w menu.                    |
| TC008   | Usuwanie produktu z menu              | Menedżer zalogowany, produkt istnieje  | 1. Kliknij „Usuń” przy produkcie. <br>2. Potwierdź akcję.                         | Produkt znika z listy menu.                    |
| TC009   | Edycja produktu                       | Menedżer zalogowany, produkt istnieje  | 1. Kliknij „Edytuj”. <br>2. Zmień cenę na 25 zł.<br>3. Zapisz zmiany.             | Cena produktu zostaje zaktualizowana.          |

---

### **3. Koszyk**

| **ID**  | **Tytuł**                             | **Warunki początkowe**                  | **Kroki testowe**                                                                 | **Oczekiwany rezultat**                         |
|---------|---------------------------------------|----------------------------------------|----------------------------------------------------------------------------------|------------------------------------------------|
| TC011   | Dodanie produktu do koszyka           | Klient zalogowany, menu otwarte         | 1. Wybierz produkt.<br>2. Kliknij „Dodaj do koszyka”.                             | Produkt pojawia się w koszyku.                  |
| TC012   | Zmiana ilości produktu                | Produkt w koszyku                       | 1. Zmień ilość produktu na 2.<br>2. Zapisz zmiany.                                | Ilość produktu zmienia się poprawnie.           |
| TC013   | Usunięcie produktu z koszyka          | Produkt w koszyku                       | 1. Kliknij „Usuń” przy produkcie.                                                | Produkt znika z koszyka.                        |

---

### **4. Zamówienia (Menedżer)**

| **ID**  | **Tytuł**                             | **Warunki początkowe**                  | **Kroki testowe**                                                                 | **Oczekiwany rezultat**                         |
|---------|---------------------------------------|----------------------------------------|----------------------------------------------------------------------------------|------------------------------------------------|
| TC014   | Wyświetlanie zamówień                 | Menedżer zalogowany                     | 1. Przejdź do sekcji „Zamówienia”.                                               | Wyświetla się lista zamówień.                   |
| TC015   | Zmiana statusu zamówienia             | Menedżer zalogowany, zamówienie istnieje | 1. Zmień status na „Zrealizowane”.                                               | Status zostaje zaktualizowany.                 |

---

## **Autorzy**

- **Imię Nazwisko** - Główny twórca projektu  
- **Kontakt**: email@example.com  

