package com.cloudwave.fwapp.module.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwave.fw.utils.RegexUtils;
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
	public ResponseEntity signin(String account, String ciphertext) {
		ResponseEntity re = new ResponseEntity();
		// 1. 检查登录信息
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(ciphertext)) {
			re.setResponseMessage(ResponseEntity.INFO, "未获取到认证信息!");
			return re;
		}
		
		// 2. 获取用户信息
		User u = this.userService.getByAccountOrEmail(account);
		
		if (u == null) {
			re.setResponseMessage(ResponseEntity.INFO, "用户名或密码错误!");
			return re;
		}
		
		// 3. 解密登录信息
		byte[] decryptFrom = AesEncrypt.parseHexStr2Byte(ciphertext);
//		byte[] decryptResult = AesEncrypt.decrypt(decryptFrom, u.getPassword());
//		String valueResult = new String(decryptResult);
		
		AesEncrypt ae = new AesEncrypt(u.getPassword());
		String valueResult = ae.decrypt(decryptFrom);
		System.out.println("解密结果："+valueResult);
		
		if (StringUtils.isEmpty(valueResult)) {
			re.setResponseMessage(ResponseEntity.INFO, "非法认证信息!");
			return re;
		}
		
		if (!valueResult.equals(account)) {
			re.setResponseMessage(ResponseEntity.INFO, "用户名或密码错误!");
			return re;
		}
		
		
		// 3. 异步记录登录信息-->可能用于用户行为分析
		
		
		// 4. 生成token，并返回用户信息
		
		
		re.setData(u);
		
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,  value="/signup")
//	public ResponseEntity signup(@PathVariable("email") String email
//			, @PathVariable("password") String password) {  //这样写总是返回 400 错误！
	public ResponseEntity signup(String email, String password) {
		ResponseEntity re = new ResponseEntity();
		// 1. 验证参数合法性
		if (StringUtils.isEmpty(email)) {
			re.setResponseMessage(ResponseEntity.WARN, "邮箱不能为空!");
			return re;
		}
		if (!RegexUtils.isEmail(email)) {
			re.setResponseMessage(ResponseEntity.WARN, "非法邮箱格式!");
			return re;
		}
		if (StringUtils.isEmpty(password)) {
			re.setResponseMessage(ResponseEntity.WARN, "请填写密码!");
			return re;
		}
		// 2.验证邮箱是否存在
		boolean existsEmail = this.userService.checkEmail(email);
		if (existsEmail) {
			re.setResponseMessage(ResponseEntity.WARN, "此邮箱已被注册,请换一个试试!");
			return re;
		}
		
		
		User u = new User();
		u.setEmail(email);
		u.setUsername(email);  // 用户名默认使用用户邮箱, 用户登录后提示用户修改
		String savepwd = MD5Encrypt.encrypt(password);
		u.setPassword(savepwd);
		
		// 这里应该用切面编程和异步事件任务把详细注册信息写入到统计数据库
		
		this.userService.save(u);
		
		re.setCode(ResponseEntity.SUCCESS);
		return re;
	}
	
	@RequestMapping(method = RequestMethod.GET,  value="/test")
	public void test() {
		boolean existsEmail = this.userService.checkEmail("11");
	}
}
