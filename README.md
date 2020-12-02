# restapi-naming-convention

1-) Use HTTP methods correctly

Find -> Get

Save -> Post

Update -> Put

Delete -> Delete


2-)  use plural resource name, dont use Verb and you should use noun instead.

  GET /authors
  
  
3-) Correct use of status codes

  200 (OK): The request has been successfully handled and completed.
  
  201 (Created): Indicates the successful creation of a resource.
  
  400 (Bad Request): Represents a client-side error. That is, the request has been malformed or missing request parameters.
  
  401 (Unauthorized): You tried accessing a resource for which you don’t have permission.
  
  404 (Not Found): The requested resource doesn’t exist.
  
  500 (Internal Server Error): Whenever the server raises an exception during the request execution.
  
4-) API versioning

  It’s an effective way of communicating breaking changes to your users.

  /v1/authors/3/books

5-)Document your API

   swaggwer library used for documentation.
  
 6-) Avoid of using camelCase, you can use lower case for long naming resources.
 
  /book-management/3/services
  
 7-)you can use dashes(-) instead of using underscrore(_) while concating resource name.
 
 
 
 
 Postman request
 
 GET All -> http://localhost:8080/v1/customers
 
 POST -> http://localhost:8080/v1/customers
 
 {
    "id" : 1,
    "name" : "Didem",
    "surname" : "Demir"
}

GET Single -> http://localhost:8080/v1/customers/1

PUT -> http://localhost:8080/v1/customers/1

{
    "id" : 2,
    "name" : "Didem",
    "surname" : "Demir"
}

DELETE -> http://localhost:8080/v1/customers/1
 
 
 https://www.sitepoint.com/build-restful-apis-best-practices/
  
