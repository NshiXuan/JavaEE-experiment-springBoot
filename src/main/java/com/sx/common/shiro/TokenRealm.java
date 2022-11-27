package com.sx.common.shiro;

import com.sx.common.cache.Caches;
import com.sx.pojo.po.Permission;
import com.sx.pojo.po.Users;
import com.sx.service.PermissionService;
import com.sx.service.impl.PermissionServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TokenRealm extends AuthorizingRealm {
  @Autowired
  private PermissionService permissionService;

  public TokenRealm(CredentialsMatcher matcher) {
    super(matcher);
  }

  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof Token;
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    // 拿到当前用户的token
    String token = (String) principalCollection.getPrimaryPrincipal();

    // 根据token查到用户的角色、权限，在缓存中我们存的key为token，value为user
    Users user = Caches.getToken(token);

    // System.out.println("user" + user.getId());

    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

    // List<Permission> permissions = permissionService.listByUserId(user.getId());
    List<Permission> permissions = permissionService.listPermission(user.getId());
    for (Permission permission : permissions) {
      System.out.println(permission.getName() + " - " + permission.getPermission());
      info.addStringPermission(permission.getPermission());
    }

    return info;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    String token = ((Token) authenticationToken).getToken();

    // SimpleAuthenticationInfo认证信息对象 返回也就是数据查到的info，这里第二个token应该为密码，这里设置为token只是为了跳转到上面的授权函数doGetAuthorizationInfo（没有别的用处）
    return new SimpleAuthenticationInfo(token, token, getName());
  }
}
