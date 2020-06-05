

import com.yrrhelp.grpc.UserGrpc;
import com.yrrhelp.grpc.UserGrpc.UserBlockingStub;
import com.yrrhelp.grpc.UserOuterClass.APIResponse;
import com.yrrhelp.grpc.UserOuterClass.LoginRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9092).usePlaintext().build();
		UserBlockingStub userSub = UserGrpc.newBlockingStub(channel);
		
		LoginRequest request = LoginRequest.newBuilder().setUsername("a").setPassword("a").build();
		APIResponse response = userSub.login(request);
		
		System.out.println(response.getResponsemessage());
	}
}
