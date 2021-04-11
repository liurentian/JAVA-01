
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author RenTian Liu
 * @version 1.0
 * @date 2021-04-11 11:10
 */
public class HttpServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8082);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                service(socket);
            }).start();
        }

    }

    private static void service(Socket socket) {
        try {
            Thread.sleep(5);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio2";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }
}
