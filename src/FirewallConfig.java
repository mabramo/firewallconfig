import org.json.*;

import java.util.LinkedList;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.io.IOException;
import java.lang.String;
import java.net.InetAddress;

public class FirewallConfig
{

	/* Variables */
	private InetAddress IPsrc;
	private InetAddress IPdst;
	private int port;
	private LinkedList<FirewallObj> listFirewalls;
	private JSONObject networkPath;
	
	/* Firewall Object */
	//Is this needed? Does it make sense? I can push a network path of FirewallObjs to a list. But I can do that with IPs. Do this if obj has multiple members
	private class FirewallObj
	{
		private InetAddress ip;
	}
	
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
		
		if(port < 0 && port > 65536)
		{
			throw new IllegalArgumentException("invalid port: " + port);
		}
		
	}
	
	/* Public Functions */

	/*
	 * 	main
	 * 	pre:
	 * 	post:
	 */
	public static int main(String[] args)
	{
		if(args.length < 3)
		{
			System.out.println("Invalid arguments");
		}
		try
		{
			FirewallConfig master = new FirewallConfig(args[0], args[1], Integer.parseInt(args[2]));
		} catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	/*
	 * 	testPath
	 * 	pre: None
	 * 	post: Tests if path from SRC to DST exists on PORT and tests if a policy exists already.
	 */
	private boolean testPath()
	{
		return false;
	}

	private int findNetPath()
	{
		//uses Recommended Report
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
