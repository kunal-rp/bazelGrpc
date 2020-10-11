package com.bazelgrpc.demo.util;

import java.util.Optional;
import com.google.common.collect.ImmutableMap;
import com.bazelgrpc.demo.util.ServiceUriProto.ServiceUri;

/**
 * 
 * Util to handle configuration and fetching of setup information for microservices. Servers: Call
 * to get port number for server instantiation Client: Call to get target address for said server
 */

public class SetupUtil {

    private static String ECR_REG_KEY = "ECR_REG_URI";

    // Assumes that all services will be setup here
    private static ImmutableMap<String, ServiceUri> SERVICE_TO_URI =
            new ImmutableMap.Builder<String, ServiceUri>().put("poll",
                    ServiceUri.newBuilder().setServiceDnsUri("poll-service").setPort(8081).build())
                    .build();


    // assumes that only k8s cluster would have ECR REG env variable set up, locally no
    public static boolean isProdEnv() {
        return System.getenv().containsKey(ECR_REG_KEY);
    }

    public static String getTarget(String service) {
        ServiceUri serviceUri = SERVICE_TO_URI.get(service);
        return (isProdEnv() ? serviceUri.getServiceDnsUri() : "localhost:" + serviceUri.getPort());
    }

    public static int getPort(String service) {
        return SERVICE_TO_URI.get(service).getPort();
    }
}
