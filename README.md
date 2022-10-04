## Clone Project
### FOR BackEnd
Open STS Eclipse Application           
Import "Employee Management System" as a Maven Project      

Go to "application.properties" file which is located in src/main/resources           
and change following parameters according to your requirements.             
~~~
spring.datasource.username=<your mysql username>       
spring.datasource.password=<your mysql password>      
~~~
In MySQL, Create a database => ems            
  
In STS, right click on Project "Employee Management System" => Run As => Spring Boot App       
Your backend is now running      
### FOR FrontEnd
~~~
cd Full-Stack-EMS
cd FrontEnd
npm install   
# Above command will download all dependencies for react application.
npm start    
# After few seconds, default browser will open with running your FrontEnd.    
~~~
