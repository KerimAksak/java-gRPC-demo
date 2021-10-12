package com.kerim.service;

import com.kerim.grpc.User.APIResponse;
import com.kerim.grpc.User.Empty;
import com.kerim.grpc.User.LoginRequest;
import com.kerim.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Inside Login");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
			response.setResponseCode(200).setResponsemessage("SUCCESS");
		}else {
			response.setResponseCode(401).setResponsemessage("INVALID PASSWORD");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted(); //connection close
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {

	}
	
}
