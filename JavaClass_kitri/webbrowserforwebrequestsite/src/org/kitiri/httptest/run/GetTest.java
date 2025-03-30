package org.kitiri.httptest.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class GetTest {
	
	public static void main(String[] args) {
		
		String RESPONSE_FILE = "C:/Users/kitri03/Desktop/kitri/Git/JavaClass_Kitri/webbrowserforwebrequestsite/file/response.txt";
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		try (SSLSocket socket = (SSLSocket) factory.createSocket("newsstand.naver.com", 443);
			InputStream in_socket = socket.getInputStream();
			 PrintWriter out_socket = new PrintWriter(
			           						   new OutputStreamWriter(
			           								   socket.getOutputStream(), 
			           								   StandardCharsets.UTF_8), true);
				
			 BufferedWriter fileWriter = new BufferedWriter(
					 							new FileWriter(RESPONSE_FILE));
			){
			// 자원 요청

			// 요청 명령
			out_socket.print("GET /?list&pcode=055 HTTP/1.1");
			out_socket.print("\n");
			
			// 요청 헤더
			out_socket.print("User-Agent: WebSniffer/1.2 (+http://websniffer.com/)");
			out_socket.print("\n");
			out_socket.print("Host: newsstand.naver.com");
			out_socket.print("\n");
			out_socket.print("Accept: */*");
			out_socket.print("\n");
			out_socket.print("Referer: https://websniffer.com/");
			out_socket.print("\n");
			out_socket.print("Connection: close");
			out_socket.print("\n");
			// 요청 헤더 종료
			out_socket.print("\n");
			// 바디 종료
			out_socket.print("\n");

			out_socket.flush();
			
			String sResponse = null;
			System.out.println(in_socket);
			byte[] buffer = new byte[1024];
			StringBuilder str = new StringBuilder();
			int i = 1;
			while(true){
				str.append((char) in_socket.read());
				System.gc();
				i++;
				if (i == 500) {
					break;
				}
			}
			System.out.println(str);
			
//			while((sResponse = in_socket.re()) != null) {
//				System.out.println(sResponse);
//				fileWriter.write(sResponse);
//				fileWriter.newLine();  
//			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
