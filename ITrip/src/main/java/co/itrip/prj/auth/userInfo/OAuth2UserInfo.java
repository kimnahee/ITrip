package co.itrip.prj.auth.userInfo;

import java.util.Map;

/**
 * 카카오 로그인 처리를 위한 인터페이스
 * @author 김하은
 * @Date 2022.09.29
 * @Version 1.0
 */
public interface OAuth2UserInfo {
	
	//플랫폼 마다 로그인시 필요하는 providerId값이 다르니 확인 필요
	//카카오 provider id
	// Stirng providerId = oAuth2User.getAttributes().get("response").get("id").toString();
	//{ "resultCode":~, "message":~, "response": { "id":~, "email":~, "name":~, ... } }
	
	Map<String, Object> getAttributes();
    String getProviderId();
    String getProvider();
    String getEmail();
    String getName();

}
