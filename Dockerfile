
From openjdk:8
EXPOSE 8088
ADD target/AadharApplication-0.0.1-SNAPSHOT.war  AadharApplication-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/AadharApplication-0.0.1-SNAPSHOT.war" ]
