/**
 * 
 */
package DemoEtEFlow.InOutbound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;




/**
 * @author p.rout 
 *
 */
public class Restfulrequest {
	

           
      String endpoint = "http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction";
	  
	@Test
	
	public void VerifyHitRESTfulGETRequestResponseSuccessfully() throws ClientProtocolException, IOException {
		
		//HttpClient client =  HttpClientBuilder.create().build(); 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		HttpResponse response = client.execute(request);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent()))); 
//		String response1 = br.readLine(); 
//		System.out.println("response" + response); 
		
 		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
     	String line="";
 		StringBuffer  sb = new StringBuffer();
 		while((line=br.readLine())!=null)
 		{
 		sb.append(line);
 		}
     	System.out.println(response.getStatusLine());
 		
  	int StatusCode = (response.getStatusLine().getStatusCode());
		
	
		
 	System.out.println(response.getStatusLine().getStatusCode());
    	
 		  System.out.println(sb);
     	
      	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
      	
//      	PrintWriter pw = new PrintWriter(System.getProperty("user.dir")+"//Response//DML.json");
//      		pw.write(sb.toString());
//         		pw.write(br.toString());
//      			pw.close();
//      			pw.flush();
  
  	   
	}
}
      	
    	
 
	 
 

 
