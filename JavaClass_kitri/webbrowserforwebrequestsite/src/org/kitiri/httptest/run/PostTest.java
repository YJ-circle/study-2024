package org.kitiri.httptest.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import utfenc.UTFENC;

public class PostTest {

	public static void main(String[] args) {
		try {
			// WAS 서버 접속
			Socket socket =
				new Socket("192.168.0.13", 8090);
			
			// I/O 입출력 스트림
			BufferedReader in_socket =
				new BufferedReader(
					new InputStreamReader(
						socket.getInputStream(), 
						StandardCharsets.UTF_8)
				);
			PrintWriter out_socket = 
				new PrintWriter(
					new OutputStreamWriter(
						socket.getOutputStream(), 
						StandardCharsets.UTF_8), true);
			
			String queryString = "id=kht&pwd=123";
			String[] fSplit = queryString.split("&");
			String[] sSplit01 = fSplit[0].split("=");
			String[] sSplit02 = fSplit[1].split("=");
			String[] queryKey = {"id", "pwd"};
			String[] queryVal = new String[2];
			// 값에 한글이 포함되었는지 여부 확인
			if(sSplit01[1].matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
				queryVal[0] = UTFENC.utfenc(sSplit01[1]);
			} else {
				queryVal[0] = sSplit01[1];
			}
			
			if(sSplit02[1].matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
				queryVal[1] = UTFENC.utfenc(sSplit02[1]);
			} else {
				queryVal[1] = sSplit02[1];
			}
			
			String queryStringEncoded = 
				queryKey[0] + "=" + queryVal[0] + "&" 
						+ queryKey[1] + "=" + queryVal[1];
			
			int contentLenght = queryStringEncoded.length();
			
			// 자원 요청
			// 요청 명령
			out_socket.print("POST /wrt/posttest HTTP/1.1");
			out_socket.print("\n");
			// 요청 헤더
			out_socket.print("Accept: */*");
			out_socket.print("\n");
			out_socket.print("Accept-Charset: */");
			out_socket.print("\n");
			out_socket.print("Host: 192.168.0.13");
			out_socket.print("\n");
			out_socket.print("Referer: http://192.168.0.13/wrt/testform");
			out_socket.print("\n");
			out_socket.print("User-Agent: WebSniffer/1.2 (+http://websniffer.com/)");
			out_socket.print("\n");
			out_socket.print("Content-length:" + contentLenght);
			out_socket.print("\n");
			out_socket.print("Content-Type: application/x-www-form-urlencoded");
			out_socket.print("\n");
			out_socket.print("Accept-Encoding: gzip, deflate");
			out_socket.print("\n");
			// 요청 헤더 종료
			out_socket.print("\n");
			// 바디 내용
			out_socket.print(queryStringEncoded);
			out_socket.print("\n");
			// 바디 종료
			out_socket.print("\n");

			out_socket.flush();
			
			String sResponse = null;
			while((sResponse = in_socket.readLine()) != null) {
				System.out.println(sResponse);
			}
			
			in_socket.close();
			out_socket.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
