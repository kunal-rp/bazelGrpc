load("@rules_java//java:defs.bzl","java_library","java_binary")
load("@io_bazel_rules_docker//container:container.bzl", "container_image")

package(default_visibility = ["//visibility:public"])

# The java_binary rule, like many others, has multiple outputs. We'll
# see that in action shortly.

java_library(
    name = "poll-service",
    srcs = ["PollService.java"],
    deps = [
        "//java/com/bazelgrpc/demo/poll:poll-service-impl",
        "@io_grpc_grpc_java//api"
    ],
)

java_binary(
    name = "PollService",
     srcs = ["PollService.java"],
     deps = [
             "//java/com/bazelgrpc/demo/poll:poll-service-impl",
             "@io_grpc_grpc_java//api"
         ],
)

container_image(
    name = "pollserviceimage",
    base = "@alpine_linux_amd64//image",
    entrypoint = ["/PollService"],
    files = [":PollService"],
)