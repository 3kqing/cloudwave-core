package com.cloudwave.fwapp.module.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwave.fw.utils.security.AesEncrypt;
import com.cloudwave.fw.utils.security.MD5Encrypt;
import com.cloudwave.fwapp.base.action.AbstractAction;
import com.cloudwave.fwapp.module.domain.User;
import com.cloudwave.fwapp.module.service.UserService;
import com.cloudwave.fwapp.web.ResponseEntity;

@Controller
@RequestMapping("/sign")
public class SignAction extends AbstractAction {

	@Resource
	private UserService userService;
	
	/**
	 * @param user 被加密后的[用户名+#+MD5加密之后的密码]
	 * @param key MD5加密之后的用户账号
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,  value="/signin")
	public ResponseEntity signIn(@PathVariable("info") String info
			, @PathVariable("key") String key) {
		ResponseEntity re = new ResponseEntity();
		// 1. 解密登录信息
		if (StringUtils.isEmpty(info) || StringUtils.isEmpty(key)) {
			re.setResponseMessage(ResponseEntity.INFO, "未获取到认证信息!");
			return re;
		}
		byte[] decryptFrom = AesEncrypt.parseHexStr2Byte(info);
		byte[] decryptResult = AesEncrypt.decrypt(decryptFrom, key);
		String user = new String(decryptResult);
		
		// 2.1 验证信息完整性
		String[] userarr = user.split("#");
		if (userarr.length != 2) {
			re.setResponseMessage(ResponseEntity.INFO, "非法认证信息!");
			return re;
		}
		String signinfo = userarr[0];
		String password = userarr[1];
		
		if (StringUtils.isEmpty(signinfo)) {
			re.setResponseMessage(ResponseEntity.INFO, "用户名不能为空!");
			return re;
		}
		if (StringUtils.isEmpty(password)) {
			re.setResponseMessage(ResponseEntity.INFO, "密码不能为空!");
			return re;
		}
		
		// 2.2 验证用户是否存在
		User u = this.userService.getByNameOrEmail(signinfo);
		
		if (u == null || !password.equals(u.getPassword())) {
			re.setResponseMessage(ResponseEntity.INFO, "用户名或密码错误!");
			return re;
		}
		
		// 3. 保存登录信息
		
		
		// 4. 返回用户信息
		
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,  value="/signup")
	public ResponseEntity signUp(@PathVariable("email") String email
			, @PathVariable("password") String password
			, @PathVariable("verifycode") String verifycode) {
		ResponseEntity re = new ResponseEntity();
		
		// 1. 验证邮箱是否存在
		boolean existsEmail = this.userService.checkEmail(email);
		if (existsEmail) {
			re.setResponseMessage(ResponseEntity.INFO, "此邮箱已被注册,请换一个试试!");
			return re;
		}
		
		
		User u = new User();
		u.setEmail(email);
		String savepwd = MD5Encrypt.encrypt(password);
		u.setPassword(savepwd);
		
		this.userService.save(u);
		
		return re;
	}
	
	@RequestMapping(method = RequestMethod.GET,  value="/test")
	public void test() {
		boolean existsEmail = this.userService.checkEmail("11");
	}
}
