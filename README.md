# Shop Demoqa Testing With Selenium & JUnit

- https://shop.demoqa.com/

## Tests

[Test Cases (Not Completed)](https://docs.google.com/spreadsheets/d/e/2PACX-1vQkL2-Vv3Ig5PqJdj5lQgtmuiT84Lw8RtbhR28TZm7E0IsNfp8pQQrnvL8PbE7Bfv0ixxUS7aqrOfQt/pubhtml)

<details>
  <summary>Login Tests</summary>

```
- Verify Successful Login With A Valid Username And Password.
- Verify Login Failure With An Empty Username.
- Verify Login Failure With An Empty Password.
- Verify Login Failure With A Valid Username And An Invalid Password.
- Verify Login Failure With An Invalid Username And An Valid Password.
- Verify Login Failure With An Invalid Username And An Invalid Password.
```
</details>

<details>
  <summary>Register Tests</summary>

```
- Verify Successful Registration With Valid Information.
- Verify Registration Failure With Empty Username.
- Verify Registration Failure With Empty Email.
- Verify Registration Failure With Empty Password.
- Verify Registration Failure With Weak Password.
- Verify Registration Failure With Duplicated Email.
---------------------------------------------------------------------
- Should Be Able To Create An Account With Duplicated Username 
- Should Not Be Able To Create An Account With Unsported Characters
```
</details>

<details>
  <summary>Search Tests</summary>

```
- Verify Successful Search For A Valid Product.
- Verify Search Failure With Empty Value. [BUG]
- Verify Successful Search With Exact Product Name.
```
</details>


<details>
  <summary>Product Tests</summary>

```
- Verify Correct Display of Product Name on Product Page
- Add Product to Cart Successfully
- Verify Unable to Add Product to Cart Without Variants
- Verify Increasing Product Count
- Verify Decreasing Product Count
- Verify Adding Product to Favorites
- Verify Display of Related Products Section on Product Page
- Verify Presence of Additional Information Section on Product Page
- Should Clear All Variants With Clear Button
```
</details>

<details>
  <summary>Cart Tests</summary>

```
- Verify Current Page is Cart Page
- Clear Cart - Verify Empty Message
- Update Cart - Verify Success Message
- Continue Shopping - Verify Redirect
- Apply Invalid Coupon - Verify No Discount
- Proceed to Checkout - Verify Redirect
- Successfully Remove Product from Cart
```
</details>

<details>
  <summary>Wishlist Tests</summary>

```
- Should Be on Wishlist Page
- Successfully Clear All Products on Wishlist
- Successfully Add Product To Cart Page [BUG]
```
</details>

---

### Maven Libraries
- [JUnit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [Selenium Chrome Driver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver)
- [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- [WebDriverManager](https://bonigarcia.dev/webdrivermanager/)

---

<details>
  <summary>Project Structure</summary>

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
</details>


