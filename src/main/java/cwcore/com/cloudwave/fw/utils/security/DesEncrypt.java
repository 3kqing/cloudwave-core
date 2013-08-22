package com.cloudwave.fw.utils.security;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.log4j.Logger;

import org.apache.commons.codec.binary.Base64;

/**
 * DES加密类
 * 
 * 2012.05.15 tomkoo modify 把对sun.misc.BASE64Decoder（sun内部api可能随着jdk的版本升级而变化）的依赖
 * 换成对org.apache.commons.codec.binary.Base64的依赖，避免了升级jdk时出现该类变化的情况
 *   
 * DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。
 * DES加密算法出自IBM的研究，后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，24小时内即可被破解。
 * 
 * @author Tom Koo
 * @since 1.0
 */
public class DesEncrypt {

	private final static String enCoding = "utf-8";

	static Logger log = Logger.getLogger(DesEncrypt.class);

	private final byte[] DESkey = new byte[128];// 设置密钥

	private final byte[] DESIV = new byte[8];// 设置向量

	private AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现

	private Key key = null;

	public DesEncrypt() {
		this(new byte[] {});
	}

	public DesEncrypt(String desKey) {
		this(desKey.getBytes());
	}

	public DesEncrypt(byte[] desKey) {
		try {
			for (int i = 0; desKey != null && i < desKey.length && i < 8; i++) {
				DESkey[i] = desKey[i];
			}
			DESKeySpec keySpec = new DESKeySpec(DESkey);// 设置密钥参数
			iv = new IvParameterSpec(DESIV);// 设置向量
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
			key = keyFactory.generateSecret(keySpec);// 得到密钥对象
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 加密
	 * @param data
	 * @return
	 */
	public String encode(String data) {
		try {
			Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
			enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
			byte[] pasByte = enCipher.doFinal(data.getBytes(enCoding));
			String result = new String(Base64.encodeBase64(pasByte), enCoding);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 解密
	 * @param data
	 * @return
	 */
	public String decode(String data) {
		try {
			Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			deCipher.init(Cipher.DECRYPT_MODE, key, iv);
			byte[] byteData = Base64.decodeBase64(data.getBytes(enCoding));
			byte[] pasByte = deCipher.doFinal(byteData);
			return new String(pasByte, enCoding);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		DesEncrypt desEncrypt = new DesEncrypt("guyonghong");
		String encryptPwd = desEncrypt
				.encode("!@#$%^&*()qertyuip -987531`12fdd21345890=-0eDBNM<?><MNBDSFG{}|}{POIUYd ");
		System.out.println(encryptPwd);
		encryptPwd = desEncrypt.decode(encryptPwd);
		System.out.println(encryptPwd);

	}
}
