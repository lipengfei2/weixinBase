package com.weixin.web;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;


/**
 * POST GET 请求
 * @author baizhongxdycom
 *
 */
public class SimulationMethod {
	private URL url;  
    private HttpURLConnection urlconn;  
    int i;
    String inencoding;  
    String outencoding;  
    public static Map map =Collections.synchronizedMap(new HashMap());
    public SimulationMethod(String inencoding, String outencoding) {  
        this.inencoding = inencoding;  
        this.outencoding = outencoding;  
    }  
    public SimulationMethod() {    
    } 
    public String connect(String params, String postUrl,String method) {  
        BufferedReader br = null;  
        String response = "", brLine = "";  
        try {  
            //params=URLEncoder.encode(params,"GB2312"); //use URLEncoder.encode for encode the params  
            url = new URL(postUrl);
            urlconn = (HttpURLConnection) url.openConnection(); 
            urlconn.setRequestProperty("user-agent","mozilla/4.7 [en] (win98; i)");    //set request header 
            urlconn.setRequestProperty("X-Forwarded-For", "127.0.0.1");  
            urlconn.setConnectTimeout(30000);  
            urlconn.setReadTimeout(30000);  
            urlconn.setRequestMethod(method);     // request method, default GET 
            urlconn.setUseCaches(false);    //Post can not user cache  
            urlconn.setDoOutput(true);    //set output from urlconn  
            urlconn.setDoInput(true);    //set input from urlconn  
            OutputStream out = urlconn.getOutputStream();
            if(params!=null){
            	 out.write(params.getBytes(outencoding));  
            }
            out.flush();
            out.close();    // output stream close,That's means need not to post data to this outputstream  
           br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), inencoding)); 
           // br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), outencoding)); 
            while((brLine = br.readLine())!=null)  
                response =(new StringBuilder(String.valueOf(response))).append(brLine).toString();
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if(br != null) {  
                    br.close();  
                }  
            } catch (IOException e) {  
                System.out.println("input stream close fail");  
            }  
            urlconn.disconnect();  
        }  
        return response;  
    }
    public String connectM(String params, String postUrl,String method) {  
    	try {  
            //params=URLEncoder.encode(params,"GB2312"); //use URLEncoder.encode for encode the params  
            url = new URL(postUrl);
            urlconn = (HttpURLConnection) url.openConnection(); 
            urlconn.setRequestProperty("user-agent","mozilla/4.7 [en] (win98; i)");    //set request header 
            urlconn.setRequestProperty("X-Forwarded-For", "127.0.0.1");  
            urlconn.setConnectTimeout(30000);  
            urlconn.setReadTimeout(30000);  
            urlconn.setRequestMethod(method);     // request method, default GET 
            urlconn.setUseCaches(false);    //Post can not user cache  
            urlconn.setDoOutput(true);    //set output from urlconn  
            urlconn.setDoInput(true);    //set input from urlconn  
            OutputStream out = urlconn.getOutputStream();
            //out.write(params.getBytes(outencoding));  
            out.flush();
            out.close();    // output stream close,That's means need not to post data to this outputstream  
            BufferedInputStream bis = new BufferedInputStream(urlconn.getInputStream());
            FileOutputStream fos = new FileOutputStream(new File("E:/myworkpace/bbbbb4444444.amr"));
  	      byte[] buf = new byte[8096];
  	      int size = 0;
  	      while ((size = bis.read(buf)) != -1)
  	        fos.write(buf, 0, size);
  	      fos.close();
  	      bis.close();
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
           
            urlconn.disconnect();  
        }
		return method;  
    	
    }
    
    /*public String connectM2(String params, String postUrl,String method) {  
    	 try {
             // path是指欲下载的文件的路径。
             File file = new File(path);
             // 取得文件名。
             String filename = file.getName();
             // 取得文件的后缀名。
             String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

             // 以流的形式下载文件。
             InputStream fis = new BufferedInputStream(new FileInputStream(path));
             byte[] buffer = new byte[fis.available()];
             fis.read(buffer);
             fis.close();
             // 清空response
             response.reset();
             // 设置response的Header
             response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
             response.addHeader("Content-Length", "" + file.length());
             OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
             response.setContentType("application/octet-stream");
             toClient.write(buffer);
             toClient.flush();
             toClient.close();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         return response;
    	
    }*/
    public JSONObject connectJSON(String params, String postUrl) {
        BufferedReader br = null;  
        String response = "", brLine = "";  
        try {  
            //params=URLEncoder.encode(params,"GB2312"); //use URLEncoder.encode for encode the params  
  
            url = new URL(postUrl);  
            urlconn = (HttpURLConnection) url.openConnection();  
            urlconn.setRequestProperty("user-agent","mozilla/4.7 [en] (win98; i)");    //set request header   
            urlconn.setRequestProperty("X-Forwarded-For", "127.0.0.1");  
            urlconn.setConnectTimeout(30000);  
            urlconn.setReadTimeout(30000);  
            urlconn.setRequestMethod("GET");     // request method, default GET 
            urlconn.setUseCaches(false);    //Post can not user cache  
            urlconn.setDoOutput(true);    //set output from urlconn  
            urlconn.setDoInput(true);    //set input from urlconn  
            OutputStream out = urlconn.getOutputStream();
            out.write(params.getBytes(outencoding));  
            out.flush();  
            out.close();    // output stream close,That's means need not to post data to this outputstream  
  
            br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), inencoding));  
            while((brLine = br.readLine())!=null)  
                response =(new StringBuilder(String.valueOf(response))).append(brLine).toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if(br != null) {  
                    br.close();  
                }  
            } catch (IOException e) {  
                System.out.println("input stream close fail");  
            }  
            urlconn.disconnect();  
        }  
        return JSONObject.fromObject(response);  
    } 
    
    public Map connectMap(String params, String postUrl,String method) {
    	String str=connect(params,postUrl,method);
    	Map<String,Object> map=JSONObject.fromObject(str);
		return map;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   public static void main(String [] aa){

	   
	   SimulationMethod tc = new SimulationMethod("UTF-8", "UTF-8"); 
	  
	  // 微信的刷新access_token
	  // https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx99ed84876db4bea7&secret=021ae711e10605202e1d202b937eb784	
	  /*//测试微信模板
	  String param="{"
		  + "\"touser\":\"oLw1cuG0Yo-GCwA8oMmBiaieXyxY\","
		  + "\"template_id\":\"szm7jcAulM2fR7ctmdWKcc-IEzH-CuvITS9Km87ysJA\","
		  + "\"url\":\"http://weixin.qq.com/download\","
		  + "\"topcolor\":\"#FF0000\","
		 + "\"data\":{"
		 + "\"first\":{\"value\":\"乐事薯片\"},"
		 + "\"tradeDateTime\":{\"value\":\"乐事薯片\"},"
		 + "\"orderType\":{\"value\":\"乐事薯片\"},"
		 + "\"customerInfo\":{\"value\":\"乐事薯片\"},"
		 + "\"orderItemName\":{\"value\":\"乐事薯片\"},"  
		 + "\"remark\":{\"value\":\"乐事薯片\"}"
		  + "}"
		  +" }";
	   tc.connect(param, "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=5w1UinMHKpakN7kc2TE3gOEd5M0AoNlZpHt0fhaPV-hCZkXqfywKjUm8cT4gL0Gmr29SHH40kJewRrVfzDY-0jRyZSyxygN3WpZl_vPeVdw", "POST");
	  */
	 
    //微信网页js接口验证
	String str=  tc.connect(null, "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=4cqn5SNZjsRVzjoVIAy4VMJvAx8r4f_g8HDsoJZFnoHxsUWYw9P7CN8VUCZduD9yoW99wxZftEbTAWQPrFT6F8ejQA3YzeJ9CJtWjfRpaJU&media_id=iTfPSu7FsmPCi6hHrrzSu8i7Dgf2dKvNyzxFZeO_UDU0vf0l1ybuLzo0HFIMLgeU", "GET");
  
	
	
	
	
	
	
	
    //微信用户分析接口
	   /*String str=  tc.connect("{ \"begin_date\": \"2015-01-18\", \"end_date\": \"2015-01-19\"}", "https://api.weixin.qq.com/datacube/getusersummary?access_token=LFxxeN7MCHrVcpwNfSq-LktQku3cxJZR_zu6NJg3bOKIBa5gepYI1h-KWtMp_lpQ0CxrsxeE6ZR8Tzu5gJa5r81h5fqfxbrM1nJ_ZTUl9Q0", "POST");   
	   System.out.println(str);
	   String str2=  tc.connect("{ \"begin_date\": \"2015-01-18\", \"end_date\": \"2015-01-19\"}", "https://api.weixin.qq.com/datacube/getusercumulate?access_token=LFxxeN7MCHrVcpwNfSq-LktQku3cxJZR_zu6NJg3bOKIBa5gepYI1h-KWtMp_lpQ0CxrsxeE6ZR8Tzu5gJa5r81h5fqfxbrM1nJ_ZTUl9Q0", "POST");   
	   	
	   System.out.println(str2);*/
	   	

   
   }

   

   
}
