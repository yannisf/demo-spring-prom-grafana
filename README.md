# Spring Boot, Prometheus, Micrometer metrics and Grafana

This small demo project serves as a playground for evaluating metrics. 
It is based on a Spring Boot standalone web application, with Prometheus enabled.
Business code is annotated with Micrometer annotations to fast capture metrics.
Prometheus scrapes the metrics and Grafana displays them.

To facilitate testing, a complete environment with the Spring Boot web application, 
Prometheus and Grafana is provided using docker compose. 
The Grafana dashboard will be already provisioned.


## Requirements

To run the project you will need Java17 to compile the Spring Boot application 
and docker compose to run a complete environment.

## Run

After checking out the project it should be sufficient to just execute from the project root:

    $ ./run.sh

To stop docker compose, just Ctrl+C, and to remove the containers `docker compose -f docker/docker-compose.yml down`.

A utility script to produce simulated traffic can be used:

    $ ./invoke.sh


## URLs

* Submit a message to succeed: http://localhost:8080/message/{token}
* Submit a message to fail: http://localhost:8080/message/error
* Prometheus scrape page: http://localhost:8080/actuator/prometheus
* Open Grafana: http://localhost:3000


## Project notable points

### Dependencies

* `org.springframework.boot:spring-boot-starter-actuator`
* `org.springframework.boot:spring-boot-starter-aop`
* `io.micrometer:micrometer-registry-prometheus`

### Code points

* Define the aspects as beans in Spring configuration
* Configure prometheus in `application.properties`
* Apply the metric annotations `@Counted`, `@Timed` where needed.

## Resources

### Spring Boot, Prometheus and Micrometer
* https://www.tutorialworks.com/spring-boot-prometheus-micrometer/
* https://medium.com/thg-tech-blog/removing-cross-cutting-concerns-with-micrometer-and-spring-aop-916a5602770f
* https://betterprogramming.pub/how-to-monitor-a-spring-boot-app-with-prometheus-and-grafana-22e2338f97fc
* https://refactorfirst.com/spring-boot-prometheus-grafana
* https://mehmetozkaya.medium.com/monitor-spring-boot-custom-metrics-with-micrometer-and-prometheus-using-docker-62798123c714
* https://medium.com/@luanrubensf/monitoring-spring-applications-with-prometheus-and-grafana-ae50bbdd1920

### Spring Boot and Docker
* https://spring.io/guides/topicals/spring-boot-docker/
* https://www.baeldung.com/spring-boot-docker-images

### Micrometer
* https://www.baeldung.com/micrometer

### Prometheus
* https://prometheus.io/docs/prometheus/latest/querying/functions/

### Grafana
* https://grafana.com/docs/grafana/latest/datasources/prometheus/
