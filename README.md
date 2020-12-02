# JAVA EE / JAX-RS - Laboration

An application in Java EE with CRUD functionality.

## Usage
Start the program and make sure you have configured Payara correctly.

### Endpoints
#### POST (JSON body)
``` md
se.iths/api/v1/student/add
```
Example: ```{
	"firstName": "Anders",
	"lastname": "Andersson",
	"email": "anders.andersson@email.com",
	"phoneNumber": "123123123"
}```

Description: Creates a new user and stores it in the database. The phone number is **optional** but every other field is required.
#### GET (User by ID)
``` md
localhost:8080/se.iths/api/v1/student/1
```
Example: ```{
  "email": "anders.andersson@email.com",
  "firstName": "Anders",
  "id": 1,
  "lastname": "Andersson",
  "phoneNumber": "123123123"
}```

#### GET (User by last name)
``` md
localhost:8080/se.iths/api/v1/student/name/Andersson
```
Example: ```{
  "email": "anders.andersson@email.com",
  "firstName": "Anders",
  "id": 1,
  "lastname": "Andersson",
  "phoneNumber": "123123123"
}```

Description: Returns a list of users found specified by the input parameter

#### PUT (JSON body)
``` md
localhost:8080/se.iths/api/v1/student/update/
```
Example: ```{
  "email": "abc@email.com",
"lastname": "Svensson",
"firstName": "Sven",
"id": 1
}```

Description: Replace the fields of the user found by the input parameters.

#### DELETE (User by ID)
``` md
localhost:8080/se.iths/api/v1/student/1
```
Example: ```Student with ID 1 was deleted```

Description: Deletes an user found by the input parameter.


