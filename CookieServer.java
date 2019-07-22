import java.util.*;
import java.io.*;
import java.net.*;

public class CookieServer {
    
    
    public static void main (String[] args) throws IOException{
	


	if (args.length != 1){
	    System.err.println("Usage: java CookieServer " + "<port number>");

	    System.exit(1);
	}


	int portNo = Integer.parseInt(args[0]);

     	ServerSocket ss = new ServerSocket(portNo);

	System.out.println("Listening on port "+ portNo + " ...");

	Socket received = ss.accept();

	System.out.println("Connection established");

	
	DataOutputStream fortuneSent = new DataOutputStream(received.getOutputStream());


     	int i = 0;
	
	int randomNumber = (int)(Math.random()*63);
	
	System.out.println(randomNumber);
	
	try (BufferedReader in = new BufferedReader(new FileReader("fortunes.txt"))){
		String wisdom = "";
		
		
	    
		    while((wisdom = in.readLine()) != null){
			i = i+1;
			if(i == randomNumber){
			    //System.out.println(wisdom);
			    fortuneSent.writeUTF(wisdom);}
		    }
	     	
	    }//try


	System.out.println("Fortune sent");

	DataInputStream msg = new DataInputStream(received.getInputStream());
	String receivedMsg = (String)msg.readUTF();

	System.out.println(receivedMsg);

	ss.close();
	received.close();
	//fortuneSent.close();

	System.out.println("Exiting");
       
	
	
	
    }
}

