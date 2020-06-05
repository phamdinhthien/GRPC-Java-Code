package user;

import com.yrrhelp.grpc.UserGrpc.UserImplBase;
import com.yrrhelp.grpc.UserOuterClass.APIResponse;
import com.yrrhelp.grpc.UserOuterClass.Empty;
import com.yrrhelp.grpc.UserOuterClass.LoginRequest;

import io.grpc.stub.StreamObserver;

public class UserService extends UserImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		String username = request.getUsername();
		String password = request.getPassword();
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
			response.setResponseCode(0).setResponsemessage("SUCCESS OK OK");
		} else {
			response.setResponseCode(100).setResponsemessage("ERROR");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		
	}
	
}
