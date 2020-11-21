package(default_visibility = ["//visibility:public"])

load("@rules_proto_grpc//nodejs:defs.bzl", "nodejs_grpc_library")
load("@build_bazel_rules_nodejs//:index.bzl", "nodejs_binary")
load("@io_bazel_rules_docker//nodejs:image.bzl", "nodejs_image")

nodejs_grpc_library(
    name = "action_service_nodejs_proto",
    deps = ["//proto/action:action_service_proto"]
)

nodejs_binary(
    name = "gateway_server",
    entry_point = "gateway.js",
     data = [
      "@nodejs_modules//express",
      "@nodejs_modules//@grpc/grpc-js",
      ":action_service_nodejs_proto"
    ]
)

nodejs_image(
    name = "gateway_image",
     entry_point = "gateway.js",
     data = [
      "@nodejs_modules//express",
      "@nodejs_modules//@grpc/grpc-js",
      ":action_service_nodejs_proto"
    ]
)