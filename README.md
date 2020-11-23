# JAVA EE / JAX-RS - Laboration

An application in Java EE with CRUD functionality.

## Usage
Start the program and make sure you have configured Payara correctly.

### Endpoints
#### GET all subjects
``` md
localhost:8080/studentmanagement/api/v1/subject/all
```
Example: 
``` 
[
  {
    "id": 1,
    "name": "C++",
    "students": [
      {
        "email": "peter.persson@mail.com",
        "firstName": "Peter",
        "id": 3,
        "lastname": "Persson",
        "phoneNumber": "031-010101"
      },
      {
        "email": "anton.andersson@mail.com",
        "firstName": "Anton",
        "id": 2,
        "lastname": "Andersson",
        "phoneNumber": "031-223311"
      }
    ],
    "teacher": {
      "id": 1,
      "name": "Albert"
    }
  },
  {
    "id": 2,
    "name": "Java",
    "students": [
      {
        "email": "peter.persson@mail.com",
        "firstName": "Peter",
        "id": 3,
        "lastname": "Persson",
        "phoneNumber": "031-010101"
      },
      {
        "email": "ludvig.larsson@mail.com",
        "firstName": "Ludvig",
        "id": 1,
        "lastname": "Larsson",
        "phoneNumber": "0708-222333"
      }
    ],
    "teacher": {
      "id": 1,
      "name": "Albert"
    }
  },
  {
    "id": 3,
    "name": "C#",
    "students": [
      {
        "email": "peter.persson@mail.com",
        "firstName": "Peter",
        "id": 3,
        "lastname": "Persson",
        "phoneNumber": "031-010101"
      },
      {
        "email": "ludvig.larsson@mail.com",
        "firstName": "Ludvig",
        "id": 1,
        "lastname": "Larsson",
        "phoneNumber": "0708-222333"
      }
    ],
    "teacher": {
      "id": 2,
      "name": "Sven"
    }
  }
]
```

Description: Returns every single subject with students enrolled and teacher.

#### GET teacher and his students for specific subject 
``` md
localhost:8080/studentmanagement/api/v1/teacher/getstudents/Albert/Java
```
Example: 
``` m
[
  {
    "email": "peter.persson@mail.com",
    "firstName": "Peter",
    "id": 3,
    "lastname": "Persson",
    "phoneNumber": "031-010101"
  },
  {
    "email": "ludvig.larsson@mail.com",
    "firstName": "Ludvig",
    "id": 1,
    "lastname": "Larsson",
    "phoneNumber": "0708-222333"
  }
]
```

Description: Returns a list students enrolled in the subject lead by the teacher specified

