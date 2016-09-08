#SkillCATch

For picture upload please use the following instructions:


1) Go to the apache-tomcat directory and create a folder called "images"
	-inside this folder create another folder called badges
	-also change the destinationFile variable inside UserResource and BadgeResource classes with "Disk:/apache-tomcat-directory/images/" and "Disk:/apache-tomcat-directory/images/badges/"

	2)Modify server.xml file inside "conf" folder in the following way:
	
	<Context docBase="/apache-tomcat-directory/images" path="/images" />
        <!-- Access log processes all example.
             Documentation at: /docs/config/valve.html
             Note: The pattern used is equivalent to using pattern="common" -->
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log." suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />