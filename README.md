# kagazi-services
web services for kagazi app using spring boot

#Stack used
Spring Boot, Spring Data, Hibernate, Maven, Swagger For Rest API documentation. 

#Installation steps

-Two maven profiles are configured in the code - 'dev' and 'prod'

 
#For Dev Build
-Run "mvn clean install -Pdev"

-Run "mvn spring-boot:run -Pdev" to start the spring boot app

-Access the API's using the url http://localhost:8080/swagger-ui.html


#For Prod Build
-The production app is deployed on heroku.

-Run the command "git push heroku master" for deploying it on heroku.

-Access the web services using the url https://kagazi-services.herokuapp.com/swagger-ui.html
