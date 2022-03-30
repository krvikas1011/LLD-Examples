FROM adoptopenjdk/openjdk11
COPY ./target/simple-scheduled-task-1.0-SNAPSHOT.jar /
ENTRYPOINT [ "java", "-jar", "/simple-scheduled-task-1.0-SNAPSHOT.jar" ]
CMD ["hello", "2"]