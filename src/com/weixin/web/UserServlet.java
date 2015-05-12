package com.weixin.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;*/

import net.sf.json.JSONObject;

/*import com.yangche99.service.SendMsgService;
import com.yangche99.service.SysparamService;
import com.yangche99.service.UsersService;
import com.yangche99.util.DBUtil;
import com.yangche99.util.MapUtil;
import com.yangche99.util.MemcachedCache;
import com.yangche99.util.SendMsgUtil;
import com.yangche99.util.WeixinUtil;
import com.yangche99.web.weixin.servlet.SimulationMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;*/
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 获取用户信息
 * @author baizhongxdycom
 *
 */
public class UserServlet extends HttpServlet{
     
	/**
	 * 处理微信服务器验证
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		  //String state = request.getParameter("state");
		
		 //System.out.println(WeixinUtil.getSecret());
		/*  //若code不为空时有两种情况  一.经过OAuth2.0用的是scope=snsapi_base   二.请求OAuth2.0 用的是scope=snsapi_userinfo并且用户授权通过   
		 String code = request.getParameter("code");
		 if(code!=null){
			//通过OAuth2.0授权的code获取获得用户的openid(没有关注的用户也可以获得openid) ,access_token(这个access_token不是普通access_token 无次数限制);
		     Map<String,Object>  mapAuth=WeixinUtil.getDatabyOAuth(code);
		     System.out.println("mapAuth=========+++++++++++"+mapAuth.toString());
			 String openid=mapAuth.get("openid").toString();
			 String access_token=mapAuth.get("access_token").toString();
			 String scope=mapAuth.get("scope").toString();
			 String unionid=null;
			 Map<String,Object>  mapuser=null;
			 if("snsapi_base".equals(scope)){
				  mapuser=WeixinUtil.getUserdatebytoken(openid);
				  System.out.println("mapAuth=========snsapi_base+++++++++++"+mapuser.toString());
				  mapuser.put("from", "token");
			 }else if("snsapi_userinfo".equals(scope)){
				 mapuser=WeixinUtil.getUserdatebyOAuth(openid, access_token);
				 mapuser.put("from", "oauth");
				 System.out.println("mapAuth=========snsapi_userinfo+++++++++++"+mapuser.toString());
			 }
			 unionid=(String) mapuser.get("unionid");
			 WeixinUtil.addOrupdateUserData(mapuser, this.getServletContext());
			 request.getSession().setAttribute("openid", openid);
			 request.getSession().setAttribute("unionid", unionid);
			 request.getSession().setAttribute("openid", openid);
			 request.getSession().setAttribute("jingweidu",SimulationMethod.map.get(openid+"lnglat"));
		  //若code为空时有两种情况     一.直接请求没有经过OAuth2.0                                       二.请求OAuth2.0 用的是scope=snsapi_userinfo并且用户没有授权通过 
		 }else{
			 
		 }
		  
		//页面的跳转方向
		 String flag=request.getParameter("flag");
	     String url=request.getServletPath() + "?" + (request.getQueryString());
		if("factorylist".equals(flag)){
			//response.sendRedirect("/weixin/repairfactory/findfactorylistfourstep?fromwhere=menu&order=distance&latlng="+(MapUtil.getLocationWeixin(request)==null?"":MapUtil.getLocationWeixin(request)));	
		
		}else if("myorder".equals(flag)){
			response.sendRedirect("/weixin/order/myorder/");
		}
		else if("myordernotpay".equals(flag)){
			response.sendRedirect("/weixin/order/myordernotpay/");
		}
		else if("myorderreturn".equals(flag)){
			response.sendRedirect("/weixin/order/myorderreturn/");
		}
		else if("vin".equals(flag)){
			response.sendRedirect("/weixin/car/vinfrommenu/");
		}
		else if("gsf".equals(flag)){
			response.sendRedirect("/weixin/car/gsffrommenu/");
		}
		else if("baoyang".equals(flag)){
			response.sendRedirect("/weixin/car/bychaxun/");
		}
		else if("baoyangoneyuan".equals(flag)){
			response.sendRedirect("/weixin/baoyang/baoyangoneyuan");
		}
		else if("partlist".equals(flag)){
			response.sendRedirect("/weixin/part/seltype");
		}else if("fourstep".equals(flag)){
			response.sendRedirect("/weixin/baoyang/fourstep");
		}
		else if("tgbaoyang".equals(flag)){
			response.sendRedirect("/weixin/baoyang/tgbaoyang");
		}
		else if("binduser".equals(flag)){
			response.sendRedirect("/weixin/userscenter/binduser");
		}
		else if("bindorder".equals(flag)){
			response.sendRedirect("/weixin/userscenter/bindorder");
		}else if("mycoupons".equals(flag)){
			response.sendRedirect("/weixin/userscenter/mycoupons");
		}
		else if("repforder".equals(flag)){
			response.sendRedirect("/weixin/repairfacory/repfacorder");
		}
		else if("baoyangrecord".equals(flag)){
			response.sendRedirect("/weixin/user/baoyang/getmycarlist");
		}
		else if("giftpack".equals(flag)){
			response.sendRedirect("/weixin/giftpack/index");
		}else if("intro".equals(flag)){
			response.sendRedirect("/weixin/cx/intro");
		}else if("applyother".equals(flag)){
			response.sendRedirect("/weixin/baoyang/appotherlist");
		}else if("applybls".equals(flag)){
			response.sendRedirect("/weixin/cx/applybls");
		}else if("tolbcode".equals(flag)){//激活码兑换入口
			response.sendRedirect("/weixin/giftpack/tocode");
		}else if("troubleapply".equals(flag)){//故障解答
			response.sendRedirect("/weixin/troubleapply/troubleapplylist");
		}else if("weitalk".equals(flag)){
			if(request.getParameter("parentid")!=null){
				response.sendRedirect("/weixin/weitalk/weitalk_detail?parentid="+request.getParameter("parentid"));
			}else{
				response.sendRedirect("/weixin/weitalk/weitalk_list");
			}
		//}
	else if("vin_add".equals(flag)){
			response.sendRedirect("/weixin/vin/vin_add");
		}
		else if("weitalk".equals(flag)){
			response.sendRedirect("/weixin/weitalk/weitalk_type_list");
		}
		
		else if("testhuodong".equals(flag)){
			System.out.println("url=url======="+url);
			if(request.getParameter("cishu")==null){
				response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Weixin.appid+"&redirect_uri="+URLEncoder.encode(Weixin.USERSERVLET+"?flag=testhuodong&cishu=1")+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
			}else{
				
			}
		}else if("testhuodongli".equals(flag)){
			System.out.println("url=url======="+url);
			if(request.getParameter("cishu")==null){
				response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Weixin.appid+"&redirect_uri="+URLEncoder.encode(Weixin.USERSERVLET+"?flag=testhuodongli&cishu=1")+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
			}
		}
		else if("huodong1".equals(flag)){
			System.out.println("url=url======="+url);
			if(request.getParameter("cishu")==null){
				response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Weixin.appid+"&redirect_uri="+URLEncoder.encode(Weixin.USERSERVLET+"?flag="+flag+"&cishu=1")+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
			}else{
				response.sendRedirect("/weixin/weihuodong/huodong1/fenxianghuodong");
				response.sendRedirect("/weixin/weihuodong/huodong1/showhuodong");
			}
		}
		
		
		else{
			response.sendRedirect("/weixin/");
		}
*/
		}


}
