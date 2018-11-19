package com.aaa.realm;


import com.aaa.dao.UserDao;
import com.aaa.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * className:MyRealm
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-15 21:55
 */
public class MyRealm extends AuthorizingRealm {



	@Autowired
	private UserDao userDao;

	/**
	 * 登录认证
	 * 1、thenticationInfo：获取认证消息，如果数据库中没有，返回null，如果得到正确的用户名和密码
	 * 2、AuthenticationInfo  可用simpleAuthenticationInfo实现类，封装获取到的正确的账号和密码
	 * 返回正确类型的对象
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//1、将token转换为UserNamePasswordToken
		UsernamePasswordToken uptoken = (UsernamePasswordToken) authenticationToken;

		//2、获取用户名
		User user = new User();
		//用户名
		user.setUsername(uptoken.getUsername());
		//密码
		user.setPassword(uptoken.getPassword().toString());

		User us = userDao.login(user);
		if (us != null) {
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(us.getUsername(), us.getPassword(), "a");
			authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(us.getPassword_salt()));
			return authenticationInfo;
		} else {
			throw new ExcessiveAttemptsException("账号密码错误");
		}
	}

	/**
	 * 角色权限认证
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String username = principalCollection.getPrimaryPrincipal().toString();

		List<String> roles = userDao.selectRole(username);
		List<String> permissions = userDao.selectPermission(username);

		Set<String> ro = new HashSet<String>();
		Set<String> per = new HashSet<String>();

		for (String role : roles) {
			ro.add(role);
		}
		for (String permission : permissions) {
			per.add(permission);
		}

		SimpleAuthorizationInfo sim = new SimpleAuthorizationInfo();
		sim.setRoles(ro);
		sim.setStringPermissions(per);

		return sim;
	}
}

