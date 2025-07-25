package com.askarakhmetov;

import com.askarakhmetov.grpc.HelloRequest;
import com.askarakhmetov.grpc.HelloResponse;
import com.askarakhmetov.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Askar")
                .setLastName("Akhmetov")
                .build());

        System.out.println("Response from server: " + helloResponse);

        channel.shutdown();
    }
}
