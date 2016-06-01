#SkillCATch

Gamification WORK IN PROGRESS ....

SPRING SECURITY LOGIN 

Instructions:

Use POSTMAN and create a POST request on http://localhost:port/context/authenticate/
with the next body 
{
  "username":"Username_from_DB"
  , "password":"pass_from_pHone_section"//in password field you have the encrypted password
}   
 Don't forget to set it to JSON(application/json).[The password from DB is encoded so inside it you will find $2a$04$.v8YDmOWVrcaUGIPyQ.hz.6V6NudPTr1OhuQ0VMEIN.L4NovBhlOi encryption for "pass_from_pHone_section"]

After this a token will be generated, and it will look something like this:

{
  
	"token": "Andrei:1447955417257:f95110a654dd0a79b871f98eb2f0d05d"

}

Insert into your browser the link:  

http://localhost:port/api/projectGroup/?token=Andrei:1447955417257:f95110a654dd0a79b871f98eb2f0d05d   

and there you are.



 AND USE SkillCatchDB.sql in your MySQL Workbench/phpMyAdmin

 There is also a DEFAULTUSER named admin inside DB, so you can insert the hardcoded token for it ?token=admin:1455807188054:1a62a970b25e06e1fe606d5fb66e99ad

 Working exception part. :xD