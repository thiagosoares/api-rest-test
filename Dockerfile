FROM registry.access.redhat.com/openjdk/openjdk-11-rhel7

#App
CMD mkdir /app
COPY build/libs/*.jar /app/app.jar


# Ports exposing
EXPOSE 9080

# Set entrypoit comand
ENTRYPOINT java -jar /app/app.jar