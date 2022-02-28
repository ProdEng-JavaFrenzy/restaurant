FROM openjdk:11

COPY ./build/libs/restaurant-0.0.1-SNAPSHOT.jar /restaurant/libs/restaurant.jar

WORKDIR /restaurant/libs/

CMD ["java", "-jar", "/restaurant/libs/restaurant.jar"]
