http://localhost:8080/store/books/ISBN1

localhost:8080/swagger-ui.html

#acuator
http://localhost:8080/actuator
http://localhost:8080/actuator/heapdump 
http://localhost:8080/actuator/metrics/process.cpu.usage 


#jolokia -> run as spring-boot-application, ansonsten keine springboot details verfügbar (mvn spring-boot:run)
https://java.integrata-cegos.de/jolokia-simples-management-von-java-anwendungen/

-> mbean":"java.lang:type=Memory"
http://localhost:8080/actuator/jolokia/read/java.lang:type=Memory


#hawtio (sämtliche jmx beans) -> run as spring-boot-application, ansonsten keine springboot details verfügbar (mvn spring-boot:run)
http://localhost:8080/actuator/hawtio/jmx/attributes 
 
