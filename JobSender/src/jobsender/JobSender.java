
package jobsender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


/**
 *
 * @author Kyle
 */
 /* 
 * job sender requires user to input a number, that number will represent the amount of time the job
 * takes the node to do. for instance a job number of 3 will take the node 3 seconds to do
 */
public class JobSender{
  public static void main(String[] args) throws SocketException, IOException {
      System.out.print("Please input a time you'd like your job to go on for.\n");  
      BufferedReader clientRead =new BufferedReader(new InputStreamReader(System.in));
      InetAddress IP = InetAddress.getLocalHost();
    
      DatagramSocket clientSocket = new DatagramSocket();
      clientSocket.setSoTimeout(0);
      while(true)    //true
      {
      byte[] sendbuffer = new byte[1024];   
      System.out.print("input Job Time : ");
      try{
      String clientData = clientRead.readLine();      
      int clientMsg = Integer.parseInt(clientData);
      
      if ( clientMsg >= 1 && clientMsg <= 40){     
      String jobMsg="JOB/"+clientData+"/0";
      sendbuffer = jobMsg.getBytes();        
      DatagramPacket sendPacket =
      new DatagramPacket(sendbuffer, sendbuffer.length, IP, 8888);      
      clientSocket.send(sendPacket);         
      }
      else{
          System.out.println("invalid input please try a number between 1 and 40");  
      }}
      catch(NumberFormatException e){
                  System.out.println("please input a number");
              }
      }
 }
}
    

