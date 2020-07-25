workspace(name = "demo_proto_and_java")

# functions to get external libs
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive","http_jar")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

# jdk  
http_archive(
    name = "jdk8_macos",
    build_file = "@local_jdk//:BUILD.bazel",
    sha256 = "64538f3eed34a298cc48168e89326fd323a55d801a3e6b2c3cc948effe124250",
    strip_prefix = "zulu8.38.0.13-ca-jdk8.0.212-macosx_x64",
    urls = [
        "https://cdn.azul.com/zulu/bin/zulu8.38.0.13-ca-jdk8.0.212-macosx_x64.tar.gz",
    ],
)

# "New" Java support - use to define proto_library -> java proto library 
http_archive(
    name = "rules_java",
    sha256 = "220b87d8cfabd22d1c6d8e3cdb4249abd4c93dcc152e0667db061fb1b957ee68",
    url = "https://github.com/bazelbuild/rules_java/releases/download/0.1.1/rules_java-0.1.1.tar.gz",
)

load("@rules_java//java:repositories.bzl", "rules_java_dependencies", "rules_java_toolchains")
rules_java_dependencies()
rules_java_toolchains()

# Protocol buffers compiler -> used to define proto_library

http_archive(
    name = "rules_proto",
    sha256 = "602e7161d9195e50246177e7c55b2f39950a9cf7366f74ed5f22fd45750cd208",
    strip_prefix = "rules_proto-97d8af4dc474595af3900dd85cb3a29ad28cc313",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
        "https://github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
    ],
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()
rules_proto_toolchains()

# Retrieve a dependency JAR in the simplest available way. We'll see
# more complex mechanisms later.

http_jar(
    name = "guava",
    sha256 = "30beb8b8527bd07c6e747e77f1a92122c2f29d57ce347461a4a55eb26e382da4",
    url = "https://repo1.maven.org/maven2/com/google/guava/guava/28.1-jre/guava-28.1-jre.jar",
)

git_repository(
    name = "com_google_protobuf",
    remote = "https://github.com/protocolbuffers/protobuf",
    tag = "v3.10.0",
)

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")
protobuf_deps()