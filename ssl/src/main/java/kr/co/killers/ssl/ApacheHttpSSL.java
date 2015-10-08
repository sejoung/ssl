package kr.co.killers.ssl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class ApacheHttpSSL {

	public static void test(String url) throws Exception {
		HttpClient httpclient = new HttpClient();
		GetMethod httpget = new GetMethod(url);
		System.setProperty("https.protocols", "SSLv3");

		httpget.getParams().setSoTimeout(10000);

		try {
			try {
				httpclient.executeMethod(httpget);
			} catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(httpget.getStatusLine());
			System.out.println(httpget.getResponseBodyAsString());

		} finally {
			httpget.releaseConnection();
		}
	}

	public static void main(String[] args) throws Exception {

		test("https://www.google.co.kr/#newwindow=1&q=JAVA+SSL+PKIX+path+building+failed");

	}

}