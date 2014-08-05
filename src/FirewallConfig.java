import org.json.*;
import java.util.ArrayList;
import java.net.HttpURLConnection;
import java.lang.String;

public class FirewallConfig
{

	/* Variable Declaration */
	private String IPsrc;
	private String IPdst;
	private int port;
	private JSONObject networkPath;
	
	/* Constructors */

	FirewallConfig()
	{
		IPsrc = "127.0.0.1";
		IPdst = "127.0.0.1";
		port = 8080;
	}
	
	FirewallConfig(String src, String dst, int prt)
	{
		IPsrc = src;
		IPdst = dst;
		port = prt;
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

	public int setSrcIP()
	{
		return 0;
	}

	public int setDstIP()
	{
		return 0;
	}

	public int setPort()
	{
		return 0;
	}

	public int getSrcIP()
	{
		return 0;
	}

	public int getDstIP()
	{
		return 0;
	}

	public int getPort()
	{
		return 0;
	}

	/* Private Functions */

	private int getNetPath()
	{
		return 0;
	}

}
