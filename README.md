# back-end-skillcatch

Online app for new employees

Installation instructions:

1. Git clone
2. mvn install (in cmd)
3. Deploy the generated war from service/target in a Tomcat or other container
4. Run the project.

##Api description:

**To create a new group
**POST to: localhost:8081/api/group/**

```

```

**To create a new user
**POST to: localhost:8081/api/group/:groupId/user/**

```

```

##Allowed methods:
**GET:**
```

**To get a list of all users for a group:**
**GET to: localhost:8081/api/group/:groupId/user/**


**To get one group:**
**GET to: localhost:8081/api/group/:groupId/**


**To get all groups:**
**GET to: localhost:8081/api/group/**

**To get all users:**
**GET to: localhost:8081/api/users/**

```

**PUT, DELETE:**

```
localhost:8081/api/group/:groupId/
localhost:8081/api/group/:groupId/user/:userId

```




