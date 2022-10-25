package sever;

/* 클라이언트 요청에 따른 서비스 분기 [1][7]*/
public class ServerController {

	public ServerController() {}
	
	public boolean controller(String clientData) {
		boolean accessResult = false;
		String serviceCode = (clientData.split("&")[0]).split("=")[1];
		/* serviceCode=1&id=hoonzzang&password=1234 --> 
		 * split("&") --> {"serviceCode=1", "id=hoonzzang", "password=1234"}
		 * split("=") --> {"serviceCode", "1"}
		 * */	
		
		if(serviceCode.equals("1")) {
			Auth auth = new Auth();
			auth.accessCtl(clientData);
			
		}
		return accessResult;
	}
}
