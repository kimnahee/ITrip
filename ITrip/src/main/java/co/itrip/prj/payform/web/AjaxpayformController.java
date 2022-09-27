package co.itrip.prj.payform.web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* ajax를 통해 결제 처리
* @author 김하은
* @date 2022.09.27
* @version 1.1
*/
@RestController
public class AjaxpayformController {
	
	@RequestMapping("/ajaxpayform.do")
	public String payform() {
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready"); //카카오 페이의 HOST와 POST 주소 가져오기
			try {
				HttpURLConnection conn = (HttpURLConnection)address.openConnection(); //요청을 하는 클라이언트(개발자)와 카카오페이 서버 연결
				conn.setRequestMethod("POST"); //post 방식
				conn.setRequestProperty("Authorization", "KakaoAK efe29476aeff1cbf82afcc88188522ce"); //인증정보(어드민 키)
				conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
				conn.setDoOutput(true); //서버에게 받고, 전해주고 하면 true(기본값 false)
				String param ="cid=TC0ONETIME"
						+ "&partner_order_id=partner_order_id"
						+ "&partner_user_id=partner_user_id"
						+ "&item_name=초코파이"
						+ "&quantity=1=2200"
						+ "&total_amount=200"
						+ "&tax_free_amount=0"
						+ "&approval_url=https://developers.kakao.com/success"
						+ "&cancel_url=https://developers.kakao.com/fail"
						+ "&fail_url=https://developers.kakao.com/cancel";
				// 값을 보냄
				OutputStream req = conn.getOutputStream() ; // 파라미터를 서버에 전달(요청)
				DataOutputStream reqData = new DataOutputStream(req); // 넘길 데이터
				reqData.writeBytes(param); //바이트 형식으로 변환하여 넘김
				  //reqData.flush(); // 가지고 있는 데이터를 서버로 넘김으로써 가지고 있는 데이터를 비움(데이터 이동)
				reqData.close(); // 끝 (close를 실행하면 flush가 자동으로 같이 실행됨)
								
				//값을 받음
				int result = conn.getResponseCode(); // 결과: 실제로 통신을 함, 통신결과를 코드로 받음
				InputStream res;
				if(result == 200) { // 정상적인 코드 200
					res = conn.getInputStream();
				}else {
					res = conn.getErrorStream();
				}
				
				//값을 읽음
				InputStreamReader reader = new InputStreamReader(res); //받은 결과를 읽은 역할을 함
				BufferedReader breader = new BufferedReader(reader); //형 변환 : 바이트 코드를 문자열코드로 변환을 도와줌
				return breader.readLine(); //문자열로 변환
			
			} catch (IOException e) {
				e.printStackTrace();
			} 
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return "payform/payformTest";
	}

}
