/*
 * package co.itrip.prj.auth.service;
 * 
 * import java.util.UUID;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import co.itrip.prj.auth.userInfo.KakaoUserInfo; import
 * co.itrip.prj.auth.userInfo.OAuth2UserInfo;
 * 
 * @Service public class PrincipalOAuth2UserService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
 * 
 * public OAuth2User loadUser(OAuth2UserRequest userRequest) throws
 * OAuth2AuthenticationException {
 * 
 * OAuth2User oAuth2User = super.loadUser(userRequest);
 * 
 * OAuth2UserInfo oAuth2UserInfo = null; String provider =
 * userRequest.getClientRegistration().getRegistrationId();
 * 
 * if(provider.equals("kakao")){ //추가 oAuth2UserInfo = new
 * KakaoUserInfo(oAuth2User.getAttributes()); }
 * 
 * String providerId = oAuth2UserInfo.getProviderId(); String username =
 * provider+"_"+providerId;
 * 
 * String uuid = UUID.randomUUID().toString().substring(0, 6); String password =
 * bCryptPasswordEncoder.encode("패스워드"+uuid);
 * 
 * String email = oAuth2UserInfo.getEmail(); Role role = Role.ROLE_USER;
 * 
 * User byUsername = userRepository.findByUsername(username);
 * 
 * //DB에 없는 사용자라면 회원가입처리 if(byUsername == null){ byUsername =
 * User.oauth2Register()
 * .username(username).password(password).email(email).role(role)
 * .provider(provider).providerId(providerId) .build();
 * userRepository.save(byUsername); }
 * 
 * return new PrincipalDetails(byUsername, oAuth2UserInfo); } }
 */