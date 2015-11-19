#SkillCATch

Gamification WORK IN PROGRESS ....

SPRING SECURITY LOGIN 

Instructions:

Use POSTMAN and create a POST request on http://localhost:port/test/login/
with the next body 
{
  "username":"Andrei"
  , "password":"abcdef"
}   
 Don't forget to set it to JSON(application/json).[The password from DB is encoded so inside it you will find $2a$04$.v8YDmOWVrcaUGIPyQ.hz.6V6NudPTr1OhuQ0VMEIN.L4NovBhlOi encryption for "abcdef"]

After this a token will be generated, and it will look something like this:

{
  
	"token": "Andrei:1447955417257:f95110a654dd0a79b871f98eb2f0d05d"

}

Insert into your browser the link http://localhost:port/api/projectGroup/?token=Andrei:1447955417257:f95110a654dd0a79b871f98eb2f0d05d   and there you are.

/api/user/ still has some dificulties.Please use only /api/projectGroup for testing