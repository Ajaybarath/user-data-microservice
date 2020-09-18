# User-data-microservice
This is a microservice to store and retrieve users data

## Learning outcomes
* Spring boot 
* Spring Hibernate
  * One to One  mapping
  * Manny to One mapping
  * One to many mapping
* MySql database

## User related endpoints

#### Create user : `POST user/create`

#### Get user detail : `GET user/get/{id}` 

#### Update user detail : `PUT user/update/{id}`

#### Delete user detail : `GET user/delete/{id}`

#### Check for username availaibality : `POST user/checkusername/{name}`

#### Get all users : `GET user/get/all`


## Address related endpoints
Add address to a specific user and to select the address of the user

#### Get all address of a user : `GET user/{id}/address/get`

#### Add address to a user : `POST user/{id}/address/add`

#### Get a specific address : `GET user/{id}/address/get/{addressid}'

#### Update a address : `PUT user/{id}/address/update/{addressid}`

#### Delete a address : `user/{id}/address/delete/{addressid}`
