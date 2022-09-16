package MyUtil;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public boolean isExists(String name, Cookie[] cookie) {
		boolean isYes = false;
		for(Cookie c:cookie) {
			if (c.getName() == name) {
				isYes = true;
			}
		}
		return isYes;
	}
		
}
