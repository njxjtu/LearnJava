package LearnJava;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class EncodeExample {
	
	String urlEncoder(String input) {
		String result = input;
		try {
			result = URLEncoder.encode(input, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String args[]) {
		String url = "https://localhost:8443/somepath?someparam=Spring Boot";
		EncodeExample ee = new EncodeExample();
		System.out.println("Original URL: " + url);
		System.out.println("Encoded URL: " + ee.urlEncoder(url));
	}
}
