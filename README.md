# Shop Demoqa Test Automation Project

<a href="https://selenium.dev"><img src="https://selenium.dev/images/selenium_logo_square_green.png" width="50" height="50" alt="Selenium"/></a>
<a href="https://junit.org/junit5/"><img src="https://junit.org/junit4/images/junit5-banner.png" width="150" height="50" alt="JUnit"/></a>


This project demonstrates automated testing of the [Shop Demoqa](https://shop.demoqa.com/) website using Selenium and JUnit. The goal is to ensure the reliability and robustness of various functionalities on the e-commerce platform.

## Table of Contents

- [Overview](#overview)
- [Test Cases](#test-cases)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Overview

This project contains a suite of automated tests for the Shop Demoqa website, covering key functionalities such as login, registration, product search, and cart management. The tests are designed to validate both positive and negative scenarios to ensure comprehensive coverage.

## Test Cases

The project includes various test cases to ensure the functionality and reliability of the Shop Demoqa website. Below is a summary of the test categories:

### Login Tests
- Verify Successful Login With A Valid Username And Password.
- Verify Login Failure With An Empty Username.
- Verify Login Failure With An Empty Password.
- Verify Login Failure With A Valid Username And An Invalid Password.
- Verify Login Failure With An Invalid Username And A Valid Password.
- Verify Login Failure With An Invalid Username And An Invalid Password.

### Register Tests
- Verify Successful Registration With Valid Information.
- Verify Registration Failure With Empty Username.
- Verify Registration Failure With Empty Email.
- Verify Registration Failure With Empty Password.
- Verify Registration Failure With Weak Password.
- Verify Registration Failure With Duplicated Email.
- Should Be Able To Create An Account With Duplicated Username.
- Should Not Be Able To Create An Account With Unsupported Characters.

### Search Tests
- Verify Successful Search For A Valid Product.
- Verify Search Failure With Empty Value. [BUG]
- Verify Successful Search With Exact Product Name.

### Product Tests
- Verify Correct Display of Product Name on Product Page.
- Add Product to Cart Successfully.
- Verify Unable to Add Product to Cart Without Variants.
- Verify Increasing Product Count.
- Verify Decreasing Product Count.
- Verify Adding Product to Favorites.
- Verify Display of Related Products Section on Product Page.
- Verify Presence of Additional Information Section on Product Page.
- Should Clear All Variants With Clear Button.

### Cart Tests
- Verify Current Page is Cart Page.
- Clear Cart - Verify Empty Message.
- Update Cart - Verify Success Message.
- Continue Shopping - Verify Redirect.
- Apply Invalid Coupon - Verify No Discount.
- Proceed to Checkout - Verify Redirect.
- Successfully Remove Product from Cart.

### Wishlist Tests
- Should Be on Wishlist Page.
- Successfully Clear All Products on Wishlist.
- Successfully Add Product To Cart Page. [BUG]

For more detailed test cases, please refer to the [Google Spreadsheet](https://docs.google.com/spreadsheets/d/e/2PACX-1vQkL2-Vv3Ig5PqJdj5lQgtmuiT84Lw8RtbhR28TZm7E0IsNfp8pQQrnvL8PbE7Bfv0ixxUS7aqrOfQt/pubhtml).

## Technologies Used

The following libraries and tools are used in this project:

- [JUnit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api) for writing and running tests.
- [Selenium Chrome Driver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver) for browser automation.
- [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java) for interacting with web elements.
- [WebDriverManager](https://bonigarcia.dev/webdrivermanager/) for managing browser drivers.

## Project Structure

```
├── pom.xml
├── README.md
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── shop
    │               └── demoqa
    │                   └── pages
    │                       ├── BasePage.java
    │                       ├── CartPage.java
    │                       ├── HomePage.java
    │                       ├── LoginPage.java
    │                       ├── ProductPage.java
    │                       ├── RegisterPage.java
    │                       ├── SearchPage.java
    │                       └── WishlistPage.java
    └── test
        └── java
            └── com
                └── shop
                    └── demoqa
                        └── tests
                            ├── BaseTest.java
                            ├── CartTest.java
                            ├── LoginTest.java
                            ├── ProductTest.java
                            ├── RegisterTest.java
                            ├── SearchTest.java
                            └── WishlistTest.java
```

## Setup Instructions

Follow these steps to set up and run the project:

1. **Clone the repository**:
```bash
git clone https://github.com/taygunkara/shop-demoqa-test.git
cd shop-demoqa-test
```

2. **Install dependencies**: 
	Ensure you have [Maven](https://maven.apache.org/install.html) installed. Then run:
```bash
mvn clean install
```

## Running Tests

You can run the tests using Maven. To execute all tests, use the following command:
```bash
mvn test
```

## Contributing
Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For any inquiries or further information, please contact me at:
- [Email](mailto:kara.taygun@gmail.com)
- [LinkedIn](https://www.linkedin.com/in/taygunkara/) 
