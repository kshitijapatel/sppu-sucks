
import java.io.*;
import java.net.*;

class UDPClient
{
   public static void main(String args[]) throws Exception
   {
      BufferedReader inFromUser =
         new BufferedReader(new InputStreamReader(System.in));
 
      DatagramSocket clientSocket = new DatagramSocket();
 //Client Socket is created
 
      InetAddress IPAddress = InetAddress.getByName("localhost");
 //Gets the IP Address 
 
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      byte[] buf=new byte[1024];
      
      System.out.println("Client 1 is Ready.");
      while(true) {
    	  
    	  System.out.print("\nTo The Server : ");
      String sentence = inFromUser.readLine();
      
      sendData = sentence.getBytes();
 //sends data
      
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 5000);
      clientSocket.send(sendPacket);
   
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
 
      String modifiedSentence = new String(receivePacket.getData());
      System.out.print("\nFrom The Server :" + modifiedSentence);
      }
   
   }
}