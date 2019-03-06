
# Introduction

A simple cloud stream example with rabbitmq (implementing codebase described in https://springbootdev.com/2018/07/29/message-driven-microservices-with-spring-cloud-stream-and-rabbitmq-publish-and-subscribe-messages-part-1/)


# Preconditions

Start your Rabbit server before running the code samples here
Rabbit admin console: http://localhost:15672/
Login with guest, guest credentials

# How to execute

Run subscriber project with:
mvn spring-boot:run

Run publisher project with:
mvn spring-boot:run


Use Postman to send the following order to publisher:
POST: http://localhost:8091/orders/publish
{
	"order_name": "order 1",
	"amount": 5000,
	"status": "new"
}

You should see order_published as response to POST request and the subscriber project should print order received in console