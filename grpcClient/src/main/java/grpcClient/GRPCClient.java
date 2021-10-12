package grpcClient;

import com.kerim.grpc.userGrpc;
import java.net.ResponseCache;

import com.kerim.grpc.User.APIResponse;
import com.kerim.grpc.User.LoginRequest;
import com.kerim.grpc.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		// stubs - generate from proto file
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		
		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Kerim").setPassword("Kerim").build();
		APIResponse response = userStub.login(loginRequest);
		
		System.out.println("Response message..:" + response.getResponsemessage() + " Response code..:" +response.getResponseCode());
	}

}
