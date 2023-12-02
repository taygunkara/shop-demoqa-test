# Shop Demoqa Testing With Selenium & JUnit

- https://shop.demoqa.com/

## Tests

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
- Verify Search Failure With Empty Value.
- Verify Successful Search With Exact Product Name.
```
</details>


<details>
  <summary>Product Tests</summary>

```
- Verify Correct Display of Product Name on Product Page.
- Add Product to Cart Successfully.
```
</details>

---

### Maven Libraries
- [JUnit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [Selenium Chrome Driver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver)
- [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- [WebDriverManager](https://bonigarcia.dev/webdrivermanager/)


