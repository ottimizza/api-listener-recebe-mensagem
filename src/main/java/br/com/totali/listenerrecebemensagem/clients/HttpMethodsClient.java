package br.com.totali.listenerrecebemensagem.clients;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpMethodsClient {
    
    public void postMethod(String url, String body, String webhookUrl, String authorization) throws Exception {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost(url);
            post.setEntity(new StringEntity(body));
            post.setHeader("Authorization", authorization);
            
            CloseableHttpResponse response = closeableHttpClient.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            
            if(webhookUrl != null && !webhookUrl.equals("")){
                post = new HttpPost(webhookUrl);
                post.setHeader("Content-Type", "application/json");
                post.setEntity(new StringEntity(result));
                try {
                    closeableHttpClient.execute(post);
                }
                catch(Exception ex) {
                    System.out.println("ERROR -> Returning response on callbackUrl: "+ex.getMessage());
                    throw ex;
                }
            }
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public void getMethod(String url, String webhookUrl, String authorization) throws Exception {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String result = "";
        HttpGet get = new HttpGet(url);
        get.setHeader("Authorization", authorization);
        try {
            CloseableHttpResponse response = closeableHttpClient.execute(get);
            result = EntityUtils.toString(response.getEntity());
            if(webhookUrl == null || webhookUrl.equals("")) 
                throw new IllegalArgumentException("WebhookkUrl not given!");
            HttpPost post = new HttpPost(webhookUrl);
            post.setHeader("Content-Type", "application/json");
            post.setEntity(new StringEntity(result));
            try {
                closeableHttpClient.execute(post);
            }
            catch(Exception ex) {
                System.out.println("ERROR -> Returning response on webhookUrl: "+ex.getMessage());
                throw ex;
            }
        }
        catch(Exception ex) {
            System.out.println("ERROR -> When sending request: "+ex.getMessage());
            throw ex;
        }
    }

}
