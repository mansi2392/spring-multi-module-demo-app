# spring-multi-module-demo-app

This is a demo project with a simple Rest API that calls the beans from another sub modules (jar) of the project

#### Steps to build war file for "test" module:
 - `./gradlew clean`
 - `./gradlew :project-a:install :project-b:install`
 - `./gradlew build`

After executing these commands the war file can be found in *test/build/libs/*

#### Command to deploy the war:
`java -jar test-0.0.1-SNAPSHOT.war`

In order to test method call on beans of project-a and project-b respectively, try the following in browser:
http://localhost:8080/get-message-a
http://localhost:8080/get-message-b
