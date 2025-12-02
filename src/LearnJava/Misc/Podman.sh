# Use a lightweight JRE base image (e.g., Eclipse Temurin JRE)
FROM eclipse-temurin:21-jre-alpine

# Define a label for metadata
LABEL maintainer="Your Name <your.email@example.com>"

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled fat JAR into the container's /app directory
# Replace 'my-app-0.0.1-SNAPSHOT.jar' with your actual JAR name
COPY my-app-0.0.1-SNAPSHOT.jar my-app.jar

# Expose the application port (e.g., 8080 for Spring Boot)
EXPOSE 8080

# The command to run the application when the container starts
# Use the unprivileged 'java' user if available, or 'root' if necessary
CMD ["java", "-jar", "my-app.jar"]

# Use the podman build command on your Linux server. Make sure the Containerfile and the my-app-0.0.1-SNAPSHOT.jar file are in the same directory.
# -t tags the image (e.g., my-app:latest)
# . specifies the current directory as the build context
$ podman build -t my-app:latest .

# --rm automatically cleans up the container filesystem when it exits
# -d runs in detached mode (background)
# -p 8080:8080 maps host port 8080 to container port 8080
# --name assigns a memorable name
$ podman run -d --rm -p 8080:8080 --name my-app-container my-app:latest

# You can check the status of your running container. 
# Notice that the user running the container is your current unprivileged user.
$ podman ps

# CONTAINER ID  IMAGE               COMMAND             CREATED      STATUS          PORTS                 NAMES
# a1b2c3d4e5f0  localhost/my-app:latest java -jar my-app.jar  5 seconds ago  Up 4 seconds ago  0.0.0.0:8080->8080/tcp  my-app-container

# To stop and remove the container (which is automatically done due to the --rm flag, 
# but you must explicitly stop it first):
$ podman stop my-app-container