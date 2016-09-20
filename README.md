#SkillCATch-Gamification

 Before using this API please configure your Tomcat Server using the following settings:
 - set the ApacheTomcat at this location "C:/Work"
 - modify the file named "server.xml" located in "ApacheTomcatDirectory/conf" like this:
 
 Context docBase="Work/apache-tomcat-7.0.67/images" path="/images" />

<Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
	   prefix="localhost_access_log." suffix=".txt"
	   pattern="%h %l %u %t &quot;%r&quot; %s %b" />
- copy the folder images inside the ApacheTomcat main directory
- deploy API on port 8080
- set context "/skillcatch"
- create a database named "skillcatch" and import the tables from the sql file inside the Database folder

