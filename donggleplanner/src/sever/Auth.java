package sever;

import sever.beans.MemberBean;

/* 로그인, 로그아웃, 접속로그기록 */
public class Auth {

	public Auth() {
		
	}
	
	/* job : 로그인 [2][6]
	 * 1. param : id, password
	 * 2. id가 DB에 존재여부 check
	 *    -->DAO가 MEMBERS 전체 레코드를 전달 --> 비교
	 *     2-1. true --> p3
	 *     2-2. false --> client
	 * 3. id와 passwerd를 DB외 비교
	 *     3.1 true --> p4
	 * 4.접속기록(로그기록) 생성
	 * 5. client 결과
	 * */
	void accessCtl(String clientData) {
		/* serviceCode=1&id=hoonzzang&[asswprd=1234 -->
		 * split("&") --> {"serviceCode=1","id=hoonzzang","password=1234"}
		 * [1].split("=") --> {"id","hoonzzang"}[1] --> MemberBean.setAccessCode
		 * [2].split("=") --> {"pw","1234"}[1] --> MemberBean.setSecretCode
		 * */
		MemberBean member = this.setMemberBean(clientData);
		System.out.println(member.getAccessCode());
		System.out.println(member.getSecretCode());
	}
	
	private MemberBean setMemberBean(String clientData) {     //변수지정
		MemberBean member = new MemberBean();
		
		String[] splitData = clientData.split("&");
		member.setAccessCode(splitData[1].split("=")[1]);
		member.setSecretCode(splitData[2].split("=")[1]);
		
		return member;
		
	}
	/* AccessCode 존재여부 판단 */
	private boolean compareAccessCode() {
		return false;
	}
	/* AccessCode와 SecretCode의 비교 */
	private boolean isAuth() {
		return false;
	}
}

