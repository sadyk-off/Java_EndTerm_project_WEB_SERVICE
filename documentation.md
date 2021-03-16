# Java_EndTerm_project_WEB_SERVICE
Purpose: To provide delivery services. 
Concept: It is a customer-centric company because the consumer decides how to deliver their package by choosing the type of delivery and managing. 
The client has functions like "get", "add", "change", "delete". This new type of service is very convenient for today. 
Yes, there are mail applications like post.kz now. 
But its disadvantage is that you cannot change the fields for sending. 
And in our service you can do anything, even sell or buy another client.
USE CASE 1 (first endpoint)
Client wants to see all the products
GET
api/parcels
Required arguments:
none
Response:
    {
       "id": 1,
        "from_address": "Kazakhstan",
        "to_address": "Russia",
        "type_delivery": "Air",
        "weight": "800g",
        "evaluate_cost": 80.42 
        "type_parcel": "documents",
        "delivery_deadline": "12.04.21",
        "size": "54x23x21"
    }







USE CASE 2
Client wants to see a specific product
GET
api/products/{id}
Required arguments:
product.id
Integer
The id of the needed product
api/products/1
Response:
    {
       "id": 1,
        "from_address": "Kazakhstan",
        "to_address": "Russia",
        "type_delivery": "Air",
        "weight": "800g",
        "evaluate_cost": 80.42 
        "type_parcel": "documents",
        "delivery_deadline": "12.04.21",
        "size": "54x23x21"
    }

USE CASE 3(second endpoint)
Administrator wants to create a new product type
POST
api/products
Required arguments:

parcel.id
Integer
The id of the needed parcel

parcel.name
String
Name of the parcel

parcel.description
String
Description of the parcel

Parcel.price
double
price of the parcel

parcel.category_id
integer
the id of the parcelt’s category

parcel.stockAmount
integer
amount of the parcel left for sale

Response:
Parcel created successfully!

USE CASE 4(third endpoint)
Administrator wants to delete an existing parceltype
DELETE 
api/parcels/{id}
Required arguments:
parcel.id
Integer
The id of the needed parcel
Response:
A parcel was removed successfully!









USE CASE 5
Administrator wants to see all customer’s info
GET
api/users

Required arguments:
none
Response:
[
    {
        "gender": true,
        "id": 1,
        "name": "Madikhan",
        "password": "admin123",
        "surname": "Sadykov",
        "username": "admin"
    },
    {
        "gender": false,
        "id": 2,
        "name": "Binah",
        "password": "123",
        "surname": "Smith",
        "username": "user1"
    },
    {
        "gender": false,
        "id": 4,
        "name": "Hello",
        "password": "World",
        "surname": "hello",
        "username": "world"
    },
    {
        "gender": false,
        "id": 5,
        "name": "Hell",
        "password": "Worl",
        "surname": "hell",
        "username": "worl"
    }
]




USE CASE 6
Administrator wants to see a specific customer’s info
GET
api/users/id/{id}
Required arguments:
user.id
Integer
The id of the needed customer
api/users/id/1
Response:
{
    "gender": true,
    "id": 1,
    "name": "Madikhan",
    "password": "admin",
    "surname": "Sadykov",
    "username": "admin"
}

USE CASE 6(third endpoint)
Administrator wants to see a specific customer’s info using their username
GET
api/users/username/{username}
Required arguments:

user.username
String
The username of the needed customer
api/users/username/worl
Response:

{
    "gender": false,
    "id": 5,
    "name": "Hell",
    "password": "Worl",
    "surname": "hell",
    "username": "worl"
}

USE CASE 7(fourth endpoint)
Administrator wants to see a specific customer’s info using their username and password
GET
api/users/login/{username}/{password}
Required arguments:

user.username
String
The username of the needed customer
user.password
String
The password of the needed customer


api/users/login/admin/admin123

{
    "gender": true,
    "id": 1,
    "name": "Madikhan",
    "password": "admin123",
    "surname": "Sadykov",
    "username": "admin"
}






USE CASE 8
Administrator wants to create new customer account
POST
api/users
Required arguments:

user.id
Integer
The id of the user

user.name
String
Name of the user

user.surname
String
Surname of the user

user.gender
boolean
gender of the user

user.username
String
User’s username

user.password
String
User’s password

Response:
User created successfully!


USE CASE 8
Administrator wants to delete an existing customer’s account
DELETE 
api/users/id/{id}
Required arguments:
User.id
Integer 
The id of the user

Response:
A user was removed successfully!

USE CASE 9
Administrator wants to delete an existing customer’s account
DELETE 
api/users/id/{id}
Required arguments:
User.id
Integer 
The id of the user

Response:
A user was removed successfully!
