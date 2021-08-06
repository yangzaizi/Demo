To run the web service. go to the demo folder

mvn clean install
mvn clean spring-boot:run  .


I haven't quite finish swagger part of the project. (In my previous experience, haven't used MapStruct mapping much. So got a bit boggled down figuring out how to do it.)
Spring is also relatively new to me.

I achieved 92% test coverages.

I tested out the api through command line.


I modeled the customer with long id, string name, and address. The id are like 1,2,3,4 ....

/customers/?id=1  (with id)

/customers         (no id) Return the first 10 objects in the json file. There is no sorting.

/customers/?id=1.2  (400 bad)

/customers/?id=1,2 (trying to do multiple, get 400)

To test out in command line do curl -v locallhost:8080/customers  or with the id