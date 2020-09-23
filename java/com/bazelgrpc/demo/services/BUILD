load("@rules_java//java:defs.bzl","java_binary")
load("@io_bazel_rules_docker//container:container.bzl", "container_image","container_push")
load("@io_bazel_rules_docker//java:image.bzl", "java_image")

package(default_visibility = ["//visibility:public"])


java_binary(
    name = "PollService",
     srcs = ["PollService.java"],
     deps = [
            "//java/com/bazelgrpc/demo/poll:poll-service-impl",
            "@io_grpc_grpc_java//api"
         ],
)

java_image(
    name = "java_pollservice_image",
     srcs = ["PollService.java"],
     deps = [
        "//java/com/bazelgrpc/demo/poll:poll-service-impl",
        "@io_grpc_grpc_java//api"
     ],
    main_class = "com.bazelgrpc.demo.services.PollService",
)

# create container image
container_image(
    name = "pollservice_image",
    base = "java_pollservice_image",
    creation_time = "{BUILD_TIMESTAMP}",
    stamp = True,
)


container_push(
   name = "push_pollservice_image",
   image = ":pollservice_image",
   format = "Docker",
   registry = "534378753229.dkr.ecr.us-east-2.amazonaws.com",
   repository = "bazeldemo",
   tag = "dev"
)