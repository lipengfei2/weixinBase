package com.weixin.http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

//import org.jeewx.api.core.req.WeiXinReqService;


import com.weixin.req.MediaAbstract;
import com.weixin.req.ReqAbstract;

public class HttpRequest {

	/*** 连接超时 */
	private static int connectTimeOut = 5000;

	/*** 读取数据超时 */
	private static int readTimeOut = 10000;

	/*** 请求编码 */
	public static String requestEncoding = "UTF-8";

	/*** 响应编码 */
	public static String responseEncoding = "UTF-8";

	/**
	 * 将参数转换成string
	 * 
	 * @param paramMap
	 * @param requestEncoding
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String getMapParamsToStr(Map params, String requestEncoding)
			throws IOException {
		StringBuffer paramsStr = new StringBuffer();
		// 设置边界
		for (Iterator iter = params.entrySet().iterator(); iter.hasNext();) {
			Entry element = (Entry) iter.next();
			paramsStr.append(element.getKey().toString());
			paramsStr.append("=");
			paramsStr.append(URLEncoder.encode(element.getValue().toString(),
					requestEncoding));
			paramsStr.append("&");
		}
		if (paramsStr.length() > 0) {
			paramsStr = paramsStr.deleteCharAt(paramsStr.length() - 1);
		}

		return params.toString();
	}

	public static String connect(String url, Map params, String method) {
		HttpURLConnection con = null;
		BufferedReader br = null;
		String response = "", brLine = "";
		try {
			con = (HttpURLConnection) (new URL(url).openConnection());
			con.setRequestMethod(method);
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setConnectTimeout(connectTimeOut);
			con.setReadTimeout(readTimeOut);
			con.setUseCaches(false);
			OutputStream out = con.getOutputStream();

			if (params != null) {
				String paramStr = getMapParamsToStr(params, requestEncoding);
				out.write(paramStr.getBytes());
				out.flush();
				out.close();
			}
			br = new BufferedReader(new InputStreamReader(con.getInputStream(),
					responseEncoding));
			while ((brLine = br.readLine()) != null)
				response = (new StringBuilder(String.valueOf(response)))
						.append(brLine).toString();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				con.disconnect();
			}
		}
		return response;
	}

	public static String connect(ReqAbstract req) {
		HttpURLConnection con = null;
		BufferedReader br = null;
		String response = "", brLine = "";
		try {
			String acess_token = req.getAccessToken().getAccess_taken();
			System.out.println("acess_token=" + acess_token);
			con = (HttpURLConnection) (new URL(req.getURL().replace(
					"ACCESS_TOKEN", acess_token)).openConnection());
			con.setRequestMethod(req.getMethod());
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setConnectTimeout(connectTimeOut);
			con.setReadTimeout(readTimeOut);
			con.setUseCaches(false);
			OutputStream out = con.getOutputStream();
			String params = req.getParams();
			System.out.println("params=" + params);
			if (params != null) {
				out.write(params.getBytes());
				out.flush();
				out.close();
			}
			br = new BufferedReader(new InputStreamReader(con.getInputStream(),
					responseEncoding));
			while ((brLine = br.readLine()) != null)
				response = (new StringBuilder(String.valueOf(response)))
						.append(brLine).toString();
			// System.out.println(response);
			// req.getErrcode().setErrmsg(response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				con.disconnect();
			}
		}
		return response;
	}

	public static String uploadMedia(MediaAbstract  req) {
		HttpURLConnection con = null;
		String response = "", brLine = "";
		try {
			String acess_token = req.getAccessToken().getAccess_taken();
			System.out.println(req.getURL().replace("ACCESS_TOKEN",acess_token));
			URL urlObj = new URL(req.getURL().replace("ACCESS_TOKEN",
					acess_token));
			con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false); // post方式不能使用缓存
			String BOUNDARY = "----------" + System.currentTimeMillis();
			con.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + BOUNDARY);

			StringBuilder sb = new StringBuilder();
			sb.append("--"); // 必须多两道线
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
					+ "IMG_20150403_143747.JPG" + "\"\r\n");
			sb.append("Content-Type:application/octet-stream\r\n\r\n");
			byte[] head = sb.toString().getBytes();
			OutputStream out = new DataOutputStream(con.getOutputStream());
			out.write(head);
			
			DataInputStream in = new DataInputStream(new FileInputStream("E:/IMG_20150403_143747.jpg"));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			in.close();
			byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线
			out.write(foot);
			out.flush();
			out.close();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while ((brLine = br.readLine()) != null)
				response = (new StringBuilder(String.valueOf(response)))
						.append(brLine).toString();
			br.close();
			System.out.println(response);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public static String uploadMedia(String url, Map parameters,
			String recvEncoding, InputStream fileIn, String fileName,
			String contentType) {
		HttpURLConnection con = null;
		String responseContent = null;
		try {
			// 设置边界
			String BOUNDARY = "----------" + System.currentTimeMillis();
			String params = getMapParamsToStr(parameters, requestEncoding);

			URL urlObj = new URL(url + "&" + params.toString());
			// 连接
			con = (HttpURLConnection) urlObj.openConnection();
			/**
			 * 设置关键值
			 */
			con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false); // post方式不能使用缓存

			// 设置边界
			con.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + BOUNDARY);

			// 请求正文信息

			// 第一部分：
			StringBuilder sb = new StringBuilder();
			sb.append("--"); // 必须多两道线
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
					+ fileName + "\"\r\n");
			sb.append("Content-Type:application/octet-stream\r\n\r\n");

			byte[] head = sb.toString().getBytes(recvEncoding);

			// 获得输出流
			OutputStream out = new DataOutputStream(con.getOutputStream());
			// 输出表头
			out.write(head);
			// 文件正文部分
			// 把文件已流文件的方式 推入到url中
			DataInputStream in = new DataInputStream(fileIn);
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			in.close();

			// 结尾部分
			byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n")
					.getBytes(recvEncoding);// 定义最后数据分隔线

			out.write(foot);
			out.flush();
			out.close();

			InputStream iddn = con.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(iddn,
					recvEncoding));
			String tempLine = rd.readLine();
			StringBuffer tempStr = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			while (tempLine != null) {
				tempStr.append(tempLine);
				tempStr.append(crlf);
				tempLine = rd.readLine();
			}
			responseContent = tempStr.toString();
			rd.close();
		} catch (IOException e) {
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
		return responseContent;
	}

	public static String downMa(String reqUrl, Map parameters, String method,
			String recvEncoding, String filePath, String media_id) {
		HttpURLConnection con = null;
		String responseContent = null;
		try {
			con = (HttpURLConnection) (new URL(reqUrl).openConnection());

			con.setRequestMethod(method);
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setConnectTimeout(connectTimeOut);
			con.setReadTimeout(readTimeOut);
			con.setUseCaches(false);

			BufferedInputStream in = new BufferedInputStream(
					con.getInputStream());
			String fileSuffix = "";
			OutputStream out = new FileOutputStream(new File(filePath
					+ File.separator + media_id + "." + fileSuffix));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = in.read(buf)) != -1) {
				out.write(buf, 0, size);
			}
			out.flush();
			out.close();
			in.close();
			responseContent = filePath + File.separator + media_id + "."
					+ fileSuffix;
		} catch (IOException e) {
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}

		return responseContent;
	}
	

	public static String downloadMedia(MediaAbstract  req) {
		HttpURLConnection con = null;
		String responseContent = null;
		try {
			String access_token=req.getAccessToken().getAccess_taken();
			System.out.println(access_token);
			con = (HttpURLConnection) (new URL("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", access_token)).openConnection());

			con.setRequestMethod(req.getMethod());
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setConnectTimeout(connectTimeOut);
			con.setReadTimeout(readTimeOut);
			con.setUseCaches(false);
			OutputStream out = con.getOutputStream();
			//String params = req.getParams();
			String params = "{\"media_id\":\"2tCuULM5J6SoDZZQzmv_bE2nRQlzFqxsUz41xGKF6JlzBGJwqVQl4MKcaSw1Y-oM\"}";
			System.out.println("params=" + params);
			if (params != null) {
				out.write(params.getBytes());
				out.flush();
				out.close();
			}
			String fileContentType = con.getHeaderField("Content-Type");
			Map<String,List<String>> map=con.getHeaderFields();
			System.out.println(con.getHeaderFields());
			
			
			
			System.out.println(fileContentType);
			
			
			BufferedInputStream in = new BufferedInputStream(
					con.getInputStream());
			String fileSuffix = "";
			OutputStream out2 = new FileOutputStream(new File("E:/"
					+ File.separator + "abc" + "." + fileSuffix));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = in.read(buf)) != -1) {
				out.write(buf, 0, size);
			}
			out.flush();
			out.close();
			in.close();
			
			
			/*responseContent = filePath + File.separator + media_id + "."
					+ fileSuffix;*/
		} catch (IOException e) {
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}

		return responseContent;
	}
	
	
/*	public static String getFileSuffix(String contentType) {
		if (file_content_type == null) {
			file_content_type = new Properties();
			InputStream in = WeiXinReqService.class.getClassLoader().getResourceAsStream("fie-content-type.properties");
			try {
				file_content_type.load(in);
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		String fileSuffix = "";
		Set type = file_content_type.entrySet();
		Iterator it = type.iterator();
		while (it.hasNext()) {
			Map.Entry entity = (Entry) it.next();
			if (entity.getValue().equals(contentType)) {
				fileSuffix = (String) entity.getKey();
				break;
			}
		}
		return fileSuffix;
	}*/


}
