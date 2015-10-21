# back-end-skillcatch
Online app for new employees

Instalarea dependintelor necesare se face cu:

```
#!java

> mvn install

Reimport Maven in proiect.
```
Din Maven, aflat pe repository-ul local, se extrag dependintele si se realizeaza automatizarea.

In root-ul aplicatiei

### Rularea serverului ###


```
#!java

CONFIGURARE Tomcat

Din meniul Run > Edit Configurations > Add new configuration > Tomcat Server > Local > 
	-Server > Configure Application server 
	-Server > alegerea portului (HTTP port)

Build Project
	
	-Deployment > Add > Artifact > selectare war > Introducere application context

Run Project	
```