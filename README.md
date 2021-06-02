# restapi-naming-convention

1-) Http method ları amaca uygun kullanımı çok önemlidir.

GET -> Resource dan bir data almak için kullanılır.

POST -> Resource a yeni bir data eklemek için kullanılır

PUT -> Resource da update işlemi gerçekleştirilecekse kullanılmalıdır.

DELETE -> Data silinmesi işleminde kullanılır.



2-)Rest api de kullanılan path parameter birden fazla kelime içerdiğinde camel case yerine dash(-) kullanımı best practice dir .
Bu kullanım okunabilirliği arttırır.

https://www.example.com/v1/employees/start-year/2011



3-) Rest api de query parameter birden fazla kelime içerdiğinde underscore ile ayrılmalı (_)- (snake_case)

https://www.example.com/v1/employees/1?last_name=Citizen&date_of_birth=1999-12-31



4-)Resource adı coğul ve isim olmalı. Fiil kullanılmamalı.

https://www.example.com/v1/photos

https://www.example.com/v1/users

https://www.example.com/v1/computers



3-)Tek bir resource ile ilgili işlem yapılmak istenildiğinde, parametre olarak verilmeli

https://www.example.com/v1/photos/1 -> 1 no lu fotograf ile ilgili işlem yap

https://www.example.com/v1/users/2536 -> 2536 id li user ı ile ilgili işlem yap

https://www.example.com/v1/computers/hp -> hp markalı bilgisayar ile ilgili işlem yap



4-) Api versionlama ve Rest api dökümatasyonu mutlaka yapılmalı.

5-) Resource isimlendirilirken küçük harflerden oluşmalı camel case kullanılmamalı.

https://www.example.com/v1/usersPhotos -> yanlış kullanım

https://www.example.com/v1/users-photos -> doğru kullanım


6-) Boolean tip değişken için resource isimlendirilirken is-, has- ile başlamamalı.

7-) Pagination ve Shorting rest apiye nasıl uygulanmalı

örnek

?filters=creation_date =\> 2001-09-20T13:00:00 and creation_date \<= 2001-09-21T13:00:00 and first_name like 'fred' and post_code=3000

Filtreleme ifadeleri;

>= Greater than or equalled to

=> Equalled to or greater than

> Greater than

< Less than

<= Less than or equalled to

=< Equalled to or less than

= Equalled

!= Not equalled


Not : The AND, OR conditions are supported.

Filtreleme örneği

?filters=creation_date =\> 2001-09-20T13:00:00 and creation_date \<= 2001-09-21T13:00:00 and first_name like 'fred' and post_code=3000

Paging örneği;

?filters=start_page =\> 0 and end_page \<= 10



8-) Path Param ve Query Param Seçimi nasıl yapılmalı

     İdentifier ile bir resource gidilmek istendiğinde kullanılmalıdır.  →  /v1/employees/{employee-id}

     Tek bir filtre uygulanarak resource a gidilmek istenildiğinde kullanılmalıdır. →  /v1/employees/department/{department-id}

     Birden fazla filtreyi bir resource a uygulamak istediğimizde kullanılır. → /v1/employees?department-id=100&year-of-birth=1987.

     Filtre sayısı 3 den fazla olduğunda json payload olarak POST method kullanarak gönderilmelidir.
     
         POST /v1/employees/search
         {
           "firstName" : "Arun",
           "lastName" : "Chandru",
           "email" : "myid@email.com",
           "phone" : "1231231234",
           "zipcode" : "33333"
           "type" : "Permanent"
         }

CRUD Ornekleri


Tüm calısanların listesini çekme → GET -> https://www.example.com/v1/employees

Tüm employee lerin filtrelenerek çekilmesi;

GET -> https://www.example.com/v1/employees?year=2011&sort=desc

GET -> https://www.example.com/v1/employees?section=economy&year=2011

Id ile tek bir employee çekme → GET https://www.example.com/v1/employees/1234

Id li employee nin bulunduğu tüm lokasyonları almak istediğimizde → GET https://www.example.com/v1/employees/1234/locations

Birden fazla data yı GET method da birden fazla alanı filtre olarak uygulamak istediğimizde → GET -> https://www.example.com/v1/employees/1234/job-title,start-date


Detaylı açıklamalar için aşağıdaki linkleri i öneririm.

https://api.gov.au/standards/national_api_standards/naming-conventions.html

https://medium.com/@bcarunmail/rest-api-best-practices-volume-1-83c6ecaddd8c
