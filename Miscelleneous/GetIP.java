import java.io.*;
import java.net.*;
import java.util.*;
class GetIP{
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the site name");
		String site=br.readLine();
		try{
			InetAddress ip=InetAddress.getByName(site);
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("The IP Address is:  "+ip);
			System.out.println("-------------------------------------------------------------------------------");
		}catch(UnknownHostException ue){
			System.out.println("Website not found");
		}
		site="http://"+site;
		URL u=new URL(site);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Protocol:  "+u.getProtocol());
		System.out.println("Host:  "+u.getHost());
		System.out.println("File:  "+u.getFile());
		System.out.println("Port:  "+u.getPort());
		System.out.println("Path:  "+u.getPath());
		System.out.println("External form:  "+u.toExternalForm());
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		URLConnection conn=u.openConnection();
		System.out.println("Date: "+new Date(conn.getDate()));
		System.out.println("Content-Type: "+conn.getContentType());
		System.out.println("Expiry: "+conn.getExpiration());
		System.out.println("Last modified: "+new Date(conn.getLastModified()));
		int l=conn.getContentLength();
		System.out.println("Length of content: "+l);
		System.out.println("-------------------------------------------------------------------------------");
		if(l==0){
			System.out.println("Content not available");
			return;
		}else{
			int ch;
			InputStream in=conn.getInputStream();
			while((ch=in.read())!=-1)
				System.out.print((char)ch);
		}
		System.out.println("-------------------------------------------------------------------------------");
	}
}