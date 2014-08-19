import org.json.*;

import java.util.LinkedList;
import java.net.UnknownHostException;
import java.io.IOException;
import java.lang.String;
import java.net.InetAddress;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class FirewallConfig
{

	/* Variables */
	private InetAddress IPsrc;
	private InetAddress IPdst;
	private int port;
	private LinkedList<FirewallObj> listFirewalls;
	private JSONObject networkPath;
	private final String API_URL = "https://10.30.100.210/firemon/api/1.0/";
	
	//TODO Change this variable name -- should this even be static? Do I even need this object?
	private static FirewallConfig master;
	
	private HttpsURLConnection url;
	
	/* Firewall Object */
	private class FirewallObj
	{
		InetAddress IPsrc;
		InetAddress IPdst;
		int port; // TODO needed?
		int dropNum; //Rule number that issues an Action=Drop on the connection. All other rules come before this rule.
		String namePolicy;
		String nameInterfaceSrc;
		String nameInterfaceDst;
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
		//Validity Check
		if(args.length < 3)
		{
			System.out.println("Invalid arguments");
		}
		
		//Initialize Class + Parameters
		try
		{
			master = new FirewallConfig(args[0], args[1], Integer.parseInt(args[2]));
		} catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Check if path is good
		if(master.testPath() == true)
		{
			//if so, run the firemon recommended report
			//print the results to a log
			master.findNetPath();
		}
		
		//next step is to prompt user to confirm whether to make changes.
		//If yes, signal firemon to implement the rule
		
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
	 * 	pre: No arguments
	 * 	post: Returns source IP as InetAddress object
	 */
	public InetAddress getSrcIP()
	{
		return IPsrc;
	}

	/*
	 * 	getDstIP
	 * 	pre: No arguments
	 * 	post: Returns destination IP as InetAddress object
	 */
	public InetAddress getDstIP()
	{
		return IPdst;
	}

	/*
	 * 	getPort
	 * 	pre: No arguments
	 * 	post: Returns port number as integer
	 */
	public int getPort()
	{
		return port;
	}

	/* Private Functions */
	
	/*
	 * 	testPath
	 * 	pre: No arguments
	 * 	post: Tests if path from SRC to DST exists on PORT and tests if a policy exists already.
	 */
	private boolean testPath()
	{
		//Run a policy test
		return false;
	}

	private int findNetPath()
	{
		//Run Recommended Report
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
