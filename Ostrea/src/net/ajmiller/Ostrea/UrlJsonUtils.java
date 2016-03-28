package net.ajmiller.Ostrea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import org.json.JSONObject;

class UrlJsonUtils {

    static JSONObject getJSON(String urlStr) {
        String out = "";
        String inputLine;
        BufferedReader in;
        URL url;

        try {
            url = new URL(urlStr);
            in = new BufferedReader(new InputStreamReader(getURLStream(url)));
            while ((inputLine = in.readLine()) != null) {
                out += inputLine;
            }
        } catch (IOException e) {
            urlStr = null;
            System.err.println("Unable to parse url " + urlStr + e);
            e.printStackTrace();
        }
        return new JSONObject(out);
    }

    static InputStream getURLStream(URL url) {
        InputStream is = null;
//        Proxy proxy = null; 
        Proxy proxy =  new Proxy(Proxy.Type.HTTP, new InetSocketAddress("web-proxy.corp.hp.com", 8080));
        try {
        	if (proxy != null)
        	{
        		is = url.openConnection(proxy).getInputStream();
        	} else
        	{
        		is = url.openConnection().getInputStream();
        	}
        } catch (IOException e) {
            System.out.println("AJM, exception getting URL connection");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return is;
    }

}
