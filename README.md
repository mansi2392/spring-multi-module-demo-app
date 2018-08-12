# spring-multi-module-demo-app

This is a demo project with a simple Rest API that calls the beans from another sub modules (jar) of the project

#### Steps to build war file for "test" module:
 - `./gradlew clean`
 - `./gradlew :project-a:install :project-b:install`
 - `./gradlew build`

After executing these commands the war file can be found in *test/build/libs/*
