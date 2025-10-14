import com.oop.game.JAR.protocol.request.LoginRequest;
import com.oop.game.JAR.protocol.request.RegisReq;
import com.oop.game.JAR.protocol.response.LoginResponse;
import com.oop.game.JAR.protocol.response.RegisRes;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {
    public static  void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",3009);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RegisReq req = new RegisReq("dungcony","motnhipdap");
        LoginRequest lreq = new LoginRequest("dungcony","motnhipdap");

        out.writeObject(lreq);
        out.flush();


        LoginResponse res = (LoginResponse) in.readObject();
        System.out.println(res.isSuccess() + res.getErrorMessage());


    }
}
