#SkillCATch

Gamification WORK IN PROGRESS ....

SPRING SECURITY LOGIN 

Instructions:

Use POSTMAN and create a POST request on http://localhost:port/test/login/
with the next body 
{
  "username":"Ionut"
  , "password":"admin1"
}   
 Don't forget to set it to JSON(application/json).

After this a token will be generated, and it will look something like this:

{
  
"token": "Ionut:1447881363754:6ce3348268d8a5f2f4e0965452ef53bc"

}

Insert into your browser the link http://localhost:port/api/user_or_projectGroup/?token=Ionut:1447881363754:6ce3348268d8a5f2f4e0965452ef53bc   and there you are.