load("@rules_java//java:defs.bzl","java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "action-service-impl",
    srcs = ["ActionManagementImpl.java"],
    deps = [
        '//java/com/bazelgrpc/demo/poll:poll-handler',
        "//proto/action:action_service_java_proto",
        "@maven//:com_google_inject_guice",
    ],
)

java_library(
    name = "poll-client",
    srcs = ["PollClient.java"],
    deps = [
       "//proto/poll:poll_service_java_proto",
        "//java/com/bazelgrpc/demo/util:setup-util"
    ],
)


java_binary(
    name = "ActionClient",
    srcs = ["ActionClient.java"],
    deps = [
        "//proto/action:action_service_java_proto",
        "//java/com/bazelgrpc/demo/util:setup-util"
    ],
)