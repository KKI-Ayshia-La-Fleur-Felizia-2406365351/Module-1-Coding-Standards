# Module-1-Coding-Standards

## Reflection 1
There were some risky code on the source code regarding the productId, i have changed it to use UUID to maintain security.
I also reused the CreateProduct form for the edit page since they're not
different and I only need to display the current data of the product to maintain
simplicity. I've also maintained the same coding style as much as possible from the
source code. After Exercise 2, even though it is not stated anywhere, i decided to add a HomePage(albeit simple) just so i don't
need to change much of the source code tests. I also added element names since the source code doesn't have any.

## Reflection 2
1. I feel exhausted. It depends on the behavior of our method. For example, the method update()
   has two different behaviors. One where the id of the updated product exists (successful update)
   and one where the id of the updated product does not exist which should return null. To make sure our unit
   tests are enough to cover our program we have to determine the behavior of each method and create test accordingly. Even if we have 100% code coverage that does not mean our code has bugs/errors.
   It only means that every executable line of code was run during tests, not that the logic is correct, all edge cases are handled, or that the code behaves as expected under all scenarios.
2. If we create another functional test class that copies the same setup procedures and instance variables from CreateProductFunctionalTest.java, then the code quality becomes worse.
   because it creates several clean codes problem, such as code duplication. Since around 60%-80% of
   the code is the same as CreateProductFunctionalTest.java. Other than that, it is also
   harder to maintain since whenever if we change the name of a button, we have to change every single file that has the same
   code structure. To make the code cleaner, we can make a base test class, where it will handle all shared setup
   such as the start WebDriver, open browser, etc. We can also make a Page Object Model to represent
   webpage as an object.

# Module-2-CI/CD-&-DevOps

## Reflection
1. My previous code coverage is 34%, i have improved it to 96% by adding unit tests
for ProductController and some missed codes on ProductRepository. I also just realized that my templates
file names were wrong, so i've fixed it too.
2. Yes. Because for every push on every branch, it will trigger the GitHub action that will run
automatic tests that i've configured. Since it's deployed on Heroku, it will also automatically build
the app for every push on main. From the definition of CI/CD, i've implemented both continuos integration on every push
   (runs the tests) and it will automatically deploy on Heroku.
   [App Link](https://eshop-ayshialafleur-75c4bb44f15a.herokuapp.com/) 

# Module-3-Maintainability-&-OO-Principles

## Reflection
1. Explain what principles you apply to your project!
The overall code has followed the SOLID principle, with some included changes: 
SRP on ProductController, i separated the CarController and ProductController. 
DIP issues on CarController, where the controller accessed CarServiceImpl directly, when it should access CarService.
Other than that, i've implemented SRP by separating concerns by layer (controllers, services, repositories), OCP by making the
app extendable by domain/service separation, LSP by making my service implementations substitutable for their interfaces, 
ISP by focusing interface per domain, and DIP by making each controller depend on an abstraction.

2. Explain the advantages of applying SOLID principles to your project with examples.
Easier maintenance: ProductController, ProductServiceImpl, and ProductRepository are separated, so changing UI flow usually won’t break storage logic.
Safer feature extension: adding Car features with separate CarController/CarService/CarRepository avoids touching product code too much.
Better testability: interfaces like ProductService make mocking and unit testing controllers/services easier.
Lower coupling: ProductController depends on ProductService (abstraction), so implementation can change with less impact.

3. Explain the disadvantages of not applying SOLID principles to your project with examples.
Harder to test: when depending on concrete classes (like CarController -> CarServiceImpl), mocking is harder and tests become brittle.
Reduced flexibility: if service depends directly on concrete repository, swapping in-memory storage to database storage needs broader rewrites.
Higher bug risk: one class handling multiple domains (e.g., product + car in one controller) increases accidental regressions.
Code becomes harder to read over time: responsibilities blur, so new contributors need more time to understand where to implement changes.
Change ripple effects: if controller and business logic are mixed, a small request change can force edits across many methods