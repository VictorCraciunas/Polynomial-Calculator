# Polynomial Calculator

## Overview
The **Polynomial Calculator** is a JavaFX application designed to perform various **polynomial operations** such as **addition, subtraction, multiplication, division, differentiation, and integration**. The calculator provides a **graphical user interface (GUI)** where users can input polynomials and select operations to perform on them. 

## Application Screenshot
Below is an image of the Polynomial Calculator in action:

![Polynomial Calculator](calculator.png)

## Features
- **GUI-based Polynomial Calculator** using JavaFX
- **Polynomial Operations:**
  - Addition
  - Subtraction
  - Multiplication
  - Division
  - Derivation
  - Integration
- **Error Handling:** Checks for valid polynomial inputs using **regular expressions (regex)**
- **Unit Testing:** Uses **JUnit** for verifying polynomial operations

## Technologies Used
- **Java (JavaFX)** for GUI
- **FXML** for interface design
- **CSS** for styling
- **JUnit** for testing

## File Structure
```
PolynomialCalculator/
│── src/
│   ├── com.jfxbase.oopjfxbase.AppLogic/  # Core logic for polynomial operations
│   │   ├── Polynomial.java   # Polynomial class with parsing & representation
│   │   ├── Operations.java   # Operations (add, subtract, multiply, divide, differentiate, integrate)
│   ├── com.jfxbase.oopjfxbase.controllers/  # JavaFX Controllers
│   │   ├── CalculatorController.java  # GUI interaction logic
│   ├── com.jfxbase.oopjfxbase.utils/  # Utilities & Testing
│   │   ├── PolynomialTest.java  # Unit test for polynomials
│   │   ├── OperationsTest.java  # Unit test for polynomial operations
│── resources/
│   ├── calculator-view.fxml  # JavaFX UI Layout
│   ├── style.css  # UI Styling
│── docs/
│   ├── Craciunas_Victor_Documentation.pdf  # Project documentation
```

## Installation & Running the Application
### 1. Clone the Repository
```
git clone https://github.com/VictorCraciunas/Polynomial-Calculator.git
cd PolynomialCalculator
```

### 2. Run the Application
- Open the project in **IntelliJ IDEA** (or another Java IDE)
- Ensure JavaFX is configured correctly
- Run the application using maven

## How It Works
### **Input Handling**
- Users enter polynomials in a valid format (e.g., `3x^2 + 2x - 5`)
- The input is validated using regex

### **Operations**
- **Addition/Subtraction:** Coefficients of like terms are added/subtracted.
- **Multiplication:** Each term is multiplied, and powers are summed.
- **Division:** Uses quotient and remainder calculation.
- **Derivative:** Multiplies each term’s coefficient by its power and reduces power by 1.
- **Integration:** Increases power by 1 and divides coefficient by the new power.

### **GUI Interface Usage**
1. Enter the first polynomial in the **top text field**.
2. Enter the second polynomial in the **middle text field**.
3. Select an operation from the **right-side buttons** (Addition, Subtraction, etc.).
4. The result is displayed in the **bottom text field** when an operation is selected.
5. Use the **Clear button** to reset the fields or **Switch button** to change input focus.

## Testing
- **PolynomialTest.java**: Tests if a given input is a valid polynomial
- **OperationsTest.java**: Tests all mathematical operations using **JUnit**

## Future Improvements
- Support for **fractional coefficients**
- More **interactive UI elements** (e.g., drag-and-drop equation builder)
- **Graphical representation** of polynomials

## Author
**Crăciunaș Victor** – Student at Technical University of Cluj-Napoca



