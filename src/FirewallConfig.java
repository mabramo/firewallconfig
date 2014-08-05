import org.json.*;
import java.util.ArrayList;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
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
		
		//THIS IS BAD -- Error check @ input later on
		if(port < 0 || port > 65536)
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

	public int setSrcIP(String newIP)
	{
		return 0;
	}

	public int setDstIP(String newIP)
	{
		return 0;
	}

	public int setPort(int newPort)
	{
		return 0;
	}

	public InetAddress getSrcIP()
	{
		return IPsrc;
	}

	public InetAddress getDstIP()
	{
		return IPdst;
	}

	public int getPort()
	{
		return port;
	}

	/* Private Functions */

	private int findNetPath()
	{
		return 0;
	}

}
