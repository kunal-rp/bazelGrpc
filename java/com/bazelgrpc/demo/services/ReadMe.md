#Services

All microservice server clases should reside here. Bazel run command on the 'java_image' build target should create the docker image of that microservice.

1) bazel run //java/com/bazelgrpc/demo/services:....
    - docker image should be created 'docker images' 
2) docker run -p 127.0.0.1:LOCAL_PORT:EXTERNAL_PORT (both ports are usually the same) CONTAINER_ID