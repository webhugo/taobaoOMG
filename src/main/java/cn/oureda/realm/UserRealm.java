package cn.oureda.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by webhugo on 3/11/17.
 */
public class UserRealm extends AuthorizingRealm {

//    @Autowired
//    private UserService userService;
//    @Autowired
//    private BookStoreService bookStoreService;


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        CustomizedToken customizedToken = (CustomizedToken) token;
//        String phone = (String) customizedToken.getPrincipal();  //得到用户名
//        String password = new String((char[]) customizedToken.getCredentials()); //得到密码
//        LoginType loginType = customizedToken.getLoginType();
//        HelperUser helperUser = null;
//        switch (loginType) {
//            case USER:
//                User user = userService.selectByPhoneAndPassword(phone, password);
//                if (user == null) {
//                    throw new UnauthenticatedException("phone or password error");//如果用户名错误
//                }
//                //如果身份认证验证成功，返回一个AuthenticationInfo实现；
//                helperUser = new HelperUser(phone, user.getUser_id(), LoginType.USER);
//                break;
//            case BOOKSTORE:
//                BookStore bookStore = bookStoreService.selectByPhoneAndPassword(phone, password);
//                if (bookStore == null) {
//                    throw new UnauthenticatedException("phone or password error");//如果用户名错误
//                }
//                helperUser = new HelperUser(phone, bookStore.getBookstore_id(), LoginType.BOOKSTORE);
//                break;
//            default:
//                throw new UnauthenticatedException("login type error");
//        }
//        return new SimpleAuthenticationInfo(helperUser, password, getName());
        return null;
    }
}
