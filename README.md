## Details

the application is an standalone Spring boot Rest server.

the EndPoint is http://localhot:8080/orders

There is an entire Test for the controllers  (Integration test)on 
com.dguerrar.integration

There is an entire Test for the Managers (Junit) on
com.dguerrar.test

##The application will response:

HTTP 200 - if everything is OK . Plus a confirm message in the body
HTTP 400 - if something is wrong with the petitions (incorrect json)
HTTP 422 - if something is wrong with the data. Plus a message in the body. This is the case of duplicate ordedrs or orders with wrong line number.
HTTP 500 - If an internal server error is found 


##Complie the application without tests
mvn -U clean install -DskipTests

##Compile the application with tests
mvn -U clean install

##Run the application as standaolne server with spring boot
mvn spring-boot:run

Also, a jacoco test for the test coverage is also created when compiling and executing the tests

##Emails.
No server have been configured. A 'fake' service have been developed. All the emails are queued and if the actualtime %2 ==0 (serves me as a fake 'down email service, the queue is processed and the emails served).
This queue is processed every 5 minutes.

_______________________________________________________________________________________________


# Engineer Coding Exercise

## Rules

You can select one of those languages to create the application: Java, Golang or PHP.
Once you completed the basics, please send it back to us with a link to any code repository online tool like Github, bitbucket, Gitlab.
If you have time enough, feel free to expand your skills demonstration making it perfect.

## Statement

The goal of this exercise is to implement an API endpoint (no UI required) that will process an order received in JSON format. It must validate and persist the order in memory.

Below you have an example of a received order:

```
{
  "order": {
    "id": 1,
    "store_id": 20,
    "lines": [
      {
        "line_number": 1,
        "sku": "blue_sock"
      },
      {
        "line_number": 2,
        "sku": "red_sock"
      }
    ]
  }
}
```

All the validations required before being able to persist the order are listed below:

1. The line numbers of the order items must be sequential (1,2,3...) starting at 1.
2. It's not possible to have two orders with the same id in the same store.

Finally, add the test coverage that you consider necessary to validate all the use cases of this application.

### Bonus:

Once the order has been persisted, you must sent an email with the order details. You can format the content of this email as you wish.

**Note:** take into account that the mail server could be down and we don't want the user to miss the email.

__________________________________________________________________________



