import com.weixin.req.menu.MenuCreate;

import net.sf.json.JSONObject;




public class Test {
	
	public static void main(String[] args) {
		//JSONObject.toBean(Menu.class);
	    JSONObject.fromObject("{\"name\":\"as\",\"id\":\"213\"}");
		MenuCreate m=	(MenuCreate) JSONObject.toBean(JSONObject.fromObject("{name:\"as\",id:\"213\"}"),MenuCreate.class);
       //System.out.println("dsdd");
	
		
	}

}
