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