package keyon.tang.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	/**
	 * 检验本地生成的验证码和用户输入的验证码
	 * @param request
	 * @return
	 */
	public static boolean checkVerifyCode(HttpServletRequest request) {
		//获得本地生成的验证码
		String verifyCodeExpected = (String) request.getSession().getAttribute(
				Constants.KAPTCHA_SESSION_KEY);
       //获取页面输入的验证码
		String verifyCodeActual = HttpServletRequestUtil.getString(request,
				"verifyCode");
		if (verifyCodeActual == null
				|| !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
