# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([UC2](#uc2),[BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([UC3](#uc3),[BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.([UC3](#uc3))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.([UC3](#uc3))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* ...

[Kupujący](#ac2)
* ...

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Zaoferowanie kwoty

**Aktorzy:**  [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) podaje cenę którą jest skłonny zapłacić za produkt.
2. System weryfikuje czy podana cena spełnia warunki.
3. [Kupujący](#ac2) staje się najwyżej licytującym.

**Scenariusze alternatywne:** 

2.A Podana kwota nie spełnia wymagań licytacji
* 2.A.1. System informuje o wprowadzeniu ceny nie spełniającej wymagań
* 2.A.2. przejdź do kroku 1


---

<a id="uc3"></a>
### UC3: Koniec Aukcji

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System sprawdza czy czas przeznaczony na daną aukcję upłynął.
2. System blokuje dodawanie nowych ofert.
3. [Kupujący](#ac2) przekazuje środki [Sprzedającemu](#ac1).
4. [Sprzedający](#ac1) wysyła paczkę.


**Scenariusze alternatywne:**

1.A Czas nie upłynął
* 1.A.1 przejdź do kroku 1.

3.A Kupujący nie posiada zadeklarowanych środków
* 3.A.1 System otwiera możliwość dodawania nowych ofert.
* 3.A.2 System dodaje czas do trwania aukcji.
* 3.A.3 System otwiera aukcje .

4.A Sprzedający nie posiada paczki.
* 4.A.1 System zamyka aukcję.
* 4.A.1 [Sprzedający](#ac1) oddaje środki [Kupującemu](#ac2).


---



---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO3: Najwyżej Licytujący

[Kupujący](#ac2) który w obrębie danej aukcji w danym czasie złożył najwyższą ofertę.

### BO4: Środki

Kwota zaproponowana przez [Kupującego](#ac2) w PLN, obsługiwana cyfrowo.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujących](#ac2), który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |

