# Shop Demoqa Testing With Selenium & JUnit

- https://shop.demoqa.com/

## Tests

<details>
  <summary>Login Tests</summary>

```
- Should Be Able To Login With Valid Username and Valid Password
- Should Not Be Able To Login With Empty Username
- Should Not Be Able To Login With Empty Password
- Should Not Be Able To Login With Valid Username and Invalid Password
- Should Not Be Able To Login With Invalid Username and Valid Password
- Should Not Be Able To Login With Invalid Username and Invalid Password
```
</details>

<details>
  <summary>Register Tests</summary>

```
- Should Be Able To Create An Account
- Should Not Be Able To Create An Account With Empty Username
- Should Not Be Able To Create An Account With Empty Email
- Should Not Be Able To Create An Account With Empty Password
- Should Not Be Able To Create An Account With Same Email
- Should Not Be Able To Create An Account With Weak Password
- Should Be Able To Create An Account With Duplicated Username
```
</details>

---

### Maven Libraries
- [JUnit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [Selenium Chrome Driver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver)
- [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- [WebDriverManager](https://bonigarcia.dev/webdrivermanager/)


