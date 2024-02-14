## **Book Store**

- You can clone the project using

  ```git clone https://github.com/supunUOM/BookStore.git ```.


- The book store application run on port 8080 and can view and test all the endpoint
  via Swagger UI.
  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Assumptions

1. One book associated with one author
2. One author has one contact number

### Functional Requirement


1. User can search book using ISBN number.
2. User can like for a book.
3. After deleting the author all associated books will be deleted.
4. Scheduler is logging the result in every 5 minutes for notify the  information of like
   count for each author.

### Non Functional Recuirement

1. Exceptions are handled by Globaly using `@RestControllerAdvice`
   and `@ExceptionHandler` annotations.
2. Reduce the **`NullPointerException`** using **`Optional`**.
3. For performance improvement I used the **`Stream API`** .
4. Have added **`Indexes`** for search fields to improve the database performance.