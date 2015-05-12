package com.weixin.req.menu;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

import com.weixin.http.HttpRequest;
import com.weixin.req.ReqAbstract;
import com.weixin.util.JsonUtil;

public class MenuCreate extends ReqAbstract {

	private String URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private List<Button> button;
	private String method = "POST";

	@Override
	public void doWeinxinReq() {
		String response = HttpRequest.connect(this);
	}

	public List<Button> getButton() {
		return button;
	}

	public void setButton(List<Button> button) {
		this.button = button;
	}

	public MenuCreate() {
		super();
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public static void main(String[] args) {

		List<Button> button = new ArrayList<Button>();
		Button button1 = new Button("click", "菜单1", "keyvalue", null);
		button.add(button1);

		List<Button> sub_button2 = new ArrayList<Button>();
		sub_button2.add(new Button("click", "菜单21eee", "keyvalue", null));
		sub_button2.add(new Button("click", "菜单22ee", "keyvalue", null));
		Button button2 = new Button("菜单2", sub_button2);
		button.add(button2);

		List<Button> sub_button3 = new ArrayList<Button>();
		sub_button3.add(new Button("click", "菜单31", "keyvalue", null));
		sub_button3.add(new Button("click", "菜单32", "keyvalue", null));
		sub_button3.add(new Button("click", "菜单33", "keyvalue", null));
		Button button3 = new Button("菜单3", sub_button3);
		button.add(button3);

		MenuCreate m = new MenuCreate();
		m.setButton(button);
		m.doWeinxinReq();

	}

}
