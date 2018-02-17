#MarsRovers

This is a API to control and move the mars rovers around Mars. 
To do it, we will follow some instructions. 
But for security, we will guarantee the security.



Create the token to access into the REST API Service:

Use the following generic command to generate an access token: 
```Bash
$ curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=pwd
```

Example:
```Bash
$curl testjwtclientid:XY7kmzoNzl100@localhost:8080/oauth/token -d grant_type=password -d username=user2 -d password=pwd2
```

With the access-token you can access into every apropiate call.

This is a list of actions Mars rover could perform, you are free to use one action, all of them or invent new
ones:

##Find one Mars Rovers
Everyone can get the current position and the status of the mars rovers. 
```java
GET localhost:8080/api/v1/marsrover/{Mars Rover Id}
```

##To move in any direction
To move the position you have to do a PUT with some parameters in the body. Only Admins!
The call
```java
PUT /marsrover/navigate
```
The parameters:
```
{
    "latitude": 1234.57,
    "longitude": 987.64
}
```

##To stand still charging its batteries
The mars rover can stand by charging its battery until completed. Only Admins!
```java
PUT localhost:8080/api/v1/charge/3
```


##To transmit texts in English
A Standard (and authenticated) User can get the current position and the status of the mars rovers. Standard or Admins!

```java
PUT localhost:8080/api/v1/message/3
```
The parameters:
```
{
    "message": "this is the message"
}
```
