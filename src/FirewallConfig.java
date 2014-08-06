import org.json.*;

import java.util.ArrayList;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.io.IOException;
import java.lang.String;
import java.net.InetAddress;

public class FirewallConfig
{

	/* Variable Declaration */
	private InetAddress IPsrc;
	private InetAddress IPdst;
	private int port;
	private JSONObject networkPath;
	
	/* Constructors */

	FirewallConfig() throws UnknownHostException
	{
		IPsrc = InetAddress.getLocalHost();
		IPdst = InetAddress.getLocalHost();
		port = 8080;
	}
	
	FirewallConfig(String src, String dst, int prt) throws UnknownHostException
	{
		IPsrc = InetAddress.getByName(src);
		IPdst = InetAddress.getByName(dst);
		port = prt;
		
		//THIS IS BAD -- Error check @ input later on -- defaulting to 8080 is bad -- potential to be abused -- constructor shouldn't need output
		if(port < 0 && port > 65536)
		{
			System.out.println("Port out of range. Specify valid port number");
			port = 8080;
		}
		
	}
	
	/* Public Functions */

	/*
	 * 	main
	 * 	pre:
	 * 	post:
	 */
	public int main()
	{
		return 0;
	}

	/*
	 * 	setSrcIP
	 * 	pre: Takes a valid IP as a string
	 * 	post: Sets new IP as InetAddress object. Returns 0 if successful
	 */
	public int setSrcIP(String newIP) throws UnknownHostException
	{
		IPsrc = InetAddress.getByName(newIP);
		return 0;
	}

	/*
	 * 	setDstIP
	 * 	pre: Takes a valid IP as a string
	 * 	post: Sets new IP as InetAddress object. Returns 0 if successful
	 */
	public int setDstIP(String newIP) throws UnknownHostException
	{
		IPdst = InetAddress.getByName(newIP);
		return 0;
	}

	/*
	 * 	setPort
	 * 	pre: Takes a valid port as integer
	 * 	post: Sets new port as int. Returns 0 if successful
	 */
	public int setPort(int newPort)
	{
		if(newPort > 0 && newPort < 65536)
		{
			port = newPort;
		}
		else
		{
			return -1;
		}
		return 0;
	}

	/*
	 * 	getSrcIP
	 * 	pre: None
	 * 	post: Returns source IP as InetAddress object
	 */
	public InetAddress getSrcIP()
	{
		return IPsrc;
	}

	/*
	 * 	getDstIP
	 * 	pre: None
	 * 	post: Returns destination IP as InetAddress object
	 */
	public InetAddress getDstIP()
	{
		return IPdst;
	}

	/*
	 * 	getPort
	 * 	pre: None
	 * 	post: Returns port number as integer
	 */
	public int getPort()
	{
		return port;
	}

	/* Private Functions */

	private int findNetPath()
	{
		return 0;
	}
	
	private int parseJSON()
	{
		return 0;
	}
	
	private int getHTTP(String urlStr) throws IOException
	{
		return 0;
	}

}
