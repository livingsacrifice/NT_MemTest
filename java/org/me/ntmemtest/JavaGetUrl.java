/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.ntmemtest;

import java.io.*;
import java.net.*;

/*import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;*/

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;


/**
 *
 * @author srichard
 */
public class JavaGetUrl {
	/*private static String getMetaTag(Document document, String attr) {
	    Elements elements = document.select("meta[name=" + attr + "]");
	    for (Element element : elements) {
	        final String s = element.attr("content");
	        if (s != null) return s;
	    }
	    elements = document.select("meta[property=" + attr + "]");
	    for (Element element : elements) {
	        final String s = element.attr("content");
	        if (s != null) return s;
	    }
	    return null;
	}
	public static String GetURLdesc (String bookx, int chapterx, int versex, String versionx){
		String html = "";
		Document finaldoc;
		try {
			
			finaldoc = Jsoup.connect("http://www.biblegateway.com/passage/?search=" + bookx + "%20" + chapterx + ":" + versex + "&version=" + versionx).get();
			html = getMetaTag(finaldoc, "og:description");
		}
		catch (MalformedURLException mue) {
            html = mue.getMessage();
            System.out.println("Ouch - a MalformedURLException happened.");
            mue.printStackTrace();
            //System.exit(1);
        }
        catch (IOException ioe) {
            html = ioe.getMessage();
            System.out.println("Oops - an IOException happened.");
            ioe.printStackTrace();
            //System.exit(1);
        }
        finally {
            return html;
        } // end of 'finally'
	}*/
    public static String GetURL (String address){
        String html = "";
        try {

            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(address);
            HttpResponse response = client.execute(request);
            InputStream in = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder str = new StringBuilder();
            String line = null;
            String breakStr = "og:description";
            whileLoop:
            while((line = reader.readLine()) != null)
            {
                str.append(line);
                if (line.contains(breakStr)){
                	//got the line with content
                	break whileLoop;
                }
                
            }
            in.close();
            html = str.toString();
            return html;
        }
        catch (MalformedURLException mue) {
            html = mue.getMessage();
            System.out.println("Ouch - a MalformedURLException happened.");
            mue.printStackTrace();
            //System.exit(1);
        }
        catch (IOException ioe) {
            html = ioe.getMessage();
            System.out.println("Oops - an IOException happened.");
            ioe.printStackTrace();
            //System.exit(1);
        }
        finally {
            return html;
        } // end of 'finally'
    } // end of main
} // end of class