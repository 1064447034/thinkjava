package com.ly.study.thinkjava;

import javax.crypto.spec.DESKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

/**
 * DES加密介绍 DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现 。
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */
public class DES {
	public DES() {
	}

	// 测试
	public static void main(String args[]) {
		// 待加密内容
		String str = "测试内容";
		// 密码，长度要是8的倍数
		String password = "Y*1J0#9d";

//		byte[] result = DES.encrypt(str.getBytes(), password);
//		System.out.println("加密后：" + new String(result));

		// 直接将如上内容解密
		//
//		String strPass = "mHTb2l8cVgp4oJ5yjbL+QpH+cYNiHfBXwlJ/NchXIdDIt3fRCgS2D62oXMhrEpWnV1hZlUMOA5hO8Jm4XW2X6SaXywmCmM+5RgZdkbHsnuEJypL5mrxMI9YyNzyov/bH/kTlP7iDSj5y0x+DbEs3Bc2uXdI/TsPBmoifgDtyFgk=";
		// 登录
//		String strPass = "67cJwTeFUWQPH/7ez6cWxadA34i5Ff44czahk+W46q65H6DTFJ7ImRpRnbRs5CQBj7ascx95NzlKeCCBLS2hE8D0CBkd6r2LXy4KVyfrjBOeT+TXOeYARzGCwjttQbDQicdv9noVXcgLI6skz7vvFHfdQ8v3qXIXq6coymQi/wA=";
		
		//航班查询
//		String strPass = "ViRQ1ytphW0LsRnhguQrkyGK8jwby/ZamOxYwsOxQ6GfNJ1z5SBgFdeZ3JMYf5v3RscGffhKpbitU0bh2i/UZS/vijtsLhrc9rB6/P78N5RGEN+9qmN+Aw==";
		//填写信息
//		String strPass = "xsmC0yp/Hdc=";
		
		//预订航班
//		String strPass = "YB4Wsh6eC56Tsk1K6ruE7HLuhWOvQ5gl24N+5TzJtwKFzBSyBPjgIgfNkqjERpdyXUFvyD8pgA8UblsgB2Pmf7e9j+Yr2KTN70nQK7fesjr6YJrfi5ZpBW/K/fTjae3qtgrIWB3JRpgzNl/rVM5/VnXPkQSQOT9dHozmYNiPFMDg3y8TgsyHc7LIGp/b9IHCV6ymnx+DmOe/tcy2G47PHjcEOsuUvTSm5KNcyICgzKdlp2LsQcuBJV1L2tQVMomQxYkXr8sTRPqn3IFxLz652IewPNb5C0oKRoRiLydOA1jv8UGjaRF16cvlmNrC/WH9id6obVMAPie9R5x4O/zLMQAvXpd0aguBBJb95vFkGnHldMOugcZhXsrJFS8Yo7n0Vr6PJ36xEvHK1EhZTRPWEupV8UWTzCkHybiyEOSNE8UFLPtmeF6Zwg3uJEXkEEDp1BNmlhKIbtcbzNra7AYcgKZfiSc8qI9vDvtzu9QVWGlREBOaTuKbnEIsds8BWY7xcEbz0DOppqUuh3CZfCgFXXq3FNPzy8Ac";
		
		//获取支付链接
//		String strPass =  "zHk1apztjXXKu5+SGg6rHR9wbF45a+uBVd4GY/lLSkbegK70goc6e1TagCFFeFE9t9wmvJAxhc0w0Ttvnz9VygxlLILeS0A7";
		
		//支付
//		String strPass = "mHTb2l8cVgp4oJ5yjbL+QpH+cYNiHfBXwlJ/NchXIdDIt3fRCgS2D62oXMhrEpWnV1hZlUMOA5hO8Jm4XW2X6SaXywmCmM+5RgZdkbHsnuEJypL5mrxMI9YyNzyov/bH/kTlP7iDSj5y0x+DbEs3Bc2uXdI/TsPBmoifgDtyFgk=";
//		String strPass = "orfTtwi82xJszRlPXGIe35skKmItqABsZXEBoczV4z7K9wc4XKzvbal3QOlRVmKXXRaxmfC8uq+yosZbrGbcc4F1eXl/8ioxtDKJNKbmp+k8RIF8XSSYjn1BTvecRA9J9lluD47zdiRNJpHEqNU4mKrw6O9jEokbKebYAMhkveU=";
		
		// 取消订单
//		String strPass = "zHk1apztjXXKu5+SGg6rHR9wbF45a+uBbo+wwdLNcfd79JxYPaomzg==";
		
		// 退票
//		String strPass = "mHTb2l8cVgp4oJ5yjbL+QpH+cYNiHfBXwlJ/NchXIdDIt3fRCgS2D62oXMhrEpWnV1hZlUMOA5hO8Jm4XW2X6SaXywmCmM+5RgZdkbHsnuE4VeTK6mqfbY9C1eMtZ7a+MxoME6xpqCri0ERdmsUwYBmua0F1Q9lhf3pR4j4m8rs=";
		
//		String strPass = "zHk1apztjXXKu5+SGg6rHR9wbF45a+uBYA/dP139myx84tqvjRwToQ==";
		
//		String strPass = "zHk1apztjXXKu5+SGg6rHR9wbF45a+uBYA/dP139myw56IVsqX08gmoihtWE0M4hDjrl43N0AU21+5rajNDbkmfJ+R5gb3mpJl7FPR4IRZNe6pfXKLxlPzEodZyYi5FCHNBd/VCAknSj+LAkde+Y99TjQ755raaG2hNtmab5Q0KQm3Dz7T0xZ1zncSKBPtq72kIe/bY/cVkZ8t2MHSibu9qq5N4RkKaqqxqwzltz0j7oZflVNbshWs4PiFhE+11nkbn08XiH4GB7Hi1Dpnp3uW8tJxFg9FMK31Atinh+7O6JRjhurnBIow==";
		
//		String strPass = "67cJwTeFUWSKe0uhIubIUHRBzLTwwiW5I3Hio9meyOxPJIB9SymH/GyoBkgJ rkyPWLmoCHbhodUXzQLD0Av6Tf8gA4lA97Y/RpplveyQ9aviLMl88cc0HY9G fKKjoFtraR7jsy8UhSSVzlYkvmaGPgB2Bniktflgy/8v0pSRt2hAQVolH2Hm 6Q==";
		
//		String strPass = "S/dqIgiAhF3+cXW3QH8fjnPr0Psvw/0hD4ErvES+hyb+c9iwAmQw1oZXRPWMR0niehB+aL+EahLiYzCxEjJt4lktbrwGKNuS/3wHk7YcmDgmOdb+6nTzNZk2ke5Qa0dezocSb7RVErVtBacT6CPji3Y/xVJCd0FI30KTDo0AN1M=, imei=868930020591103";
		
//		String strPass = "S/dqIgiAhF3+cXW3QH8fjnPr0Psvw/0hD4ErvES+hyb+c9iwAmQw1oZXRPWMR0niehB+aL+EahLiYzCxEjJt4lktbrwGKNuS/3wHk7YcmDgmOdb+6nTzNZk2ke5Qa0dezocSb7RVErVtBacT6CPji3Y/xVJCd0FI30KTDo0AN1M=";
		
		String strPass = "1SAvykx91Ebkq8EAZefK4HNIzAu9wouVmJheOBZzC8gP1Oda0AjD%2FlrsFDqzjmmHNvj15F%2B6emlIqxswJ6MxdQkhFXMD1yVAYw47jq533gMP3ymCFgbmQZPbLVJdli9VSQDOwRTyfgIbMorP5VojIPGWD5xnv%2F%2Fp2wR6Qe8chYPGX2CUrnm17tXPBrIKSCGL";

		//byte[] bytes = decoder.decodeBuffer(strPass);
//		byte[] bytes = Base64.decode(strPass);
		byte[] bytes = java.util.Base64.getDecoder().decode(strPass);
		new String(bytes);
		System.out.println("strPassLengthL:" + strPass.length());
		
		System.out.println("strPassLengthL:" + strPass.length());
		String pass = "Y*1J0#9d";
		try {
			//byte[] decryResult = DES.decrypt(result, password);
			byte[] decryResult = DES.decrypt(bytes, pass);
			System.out.println("解密后：" + new String(decryResult));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 加密
	 * 
	 * @param datasource
	 *            byte[]
	 * @param password
	 *            String
	 * @return byte[]
	 */
	public static byte[] encrypt(String datasource, String password) {
		try {
			DESKeySpec desKey = new DESKeySpec(password.getBytes("UTF-8"));
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, new IvParameterSpec(password.getBytes("UTF-8")));
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource.getBytes("UTF-8"));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param src
	 *            byte[]
	 * @param password
	 *            String
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, String password) throws Exception {
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes("UTF-8"));
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, new IvParameterSpec(password.getBytes("UTF-8")));
		// 真正开始解密操作
		return cipher.doFinal(src);
	}
}