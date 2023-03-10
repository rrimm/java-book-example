import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			byte arr[] = new byte[100];
			in.read(arr);	// 배열 사용 시 한 번에 100바이트 read
			System.out.println(new String(arr));	// 화면에 출력
			String str = "Hello,Client";
			out.write(str.getBytes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception ignored) {
			}
			try {
				serverSocket.close();
			} catch (Exception ignored) {
			}
		}

	}

}
