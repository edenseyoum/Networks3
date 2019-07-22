import java.util.*;
import java.io.*;
import java.net.*;



public class CookieClient {



   public static void main (String[] args) throws IOException{


	if (args.length != 2){
	    System.err.println("Usage: java CookieClient " + "<host> " + "<port number>");

	    System.exit(1);
	}


	String hostAddress = args[0];
	int portNo = Integer.parseInt(args[1]);

    Socket socket = new Socket(hostAddress, portNo);

    String toSend = "ThanksServer";

    System.out.println("Connecting to server");

    DataInputStream in = new DataInputStream(socket.getInputStream());


    String fortune = (String)in.readUTF();


    System.out.println("Your fortune: " + fortune);


   DataOutputStream out = new DataOutputStream(socket.getOutputStream());
   out.writeUTF(toSend);

    socket.close();


    //in.close();

    System.out.println("Exiting");
   }
}
