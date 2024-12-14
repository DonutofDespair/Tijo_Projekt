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

## **Autorzy**

- **Imię Nazwisko** - Magdalen Kłósek, Wszołek Konrad


