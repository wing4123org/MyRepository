package cn.tempus.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tempus.task.oracle2sqlserverTask;
import net.sf.json.JSONArray;

@Controller
@Scope("session")
@RequestMapping("/test1")
public class testCtr {
	
	@Autowired
    private testService testservice;
	
	@Autowired
	oracle2sqlserverTask task;
	
	@RequestMapping("/home1")
	public String home(){
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/getuserbyid")
	public JSONArray getUserById(@RequestParam("fid") String fid){
		
		System.out.println(fid);
		
		List<HashMap<String, Object>> user=new ArrayList<HashMap<String,Object>>();
		
		if(fid.equals("")){
			user = testservice.getUserlist();
		}else{
			user = testservice.getUserById(fid);
		}
		
		JSONArray ja = JSONArray.fromObject(user);
		
		return ja;
	}
	
	@ResponseBody
	@RequestMapping(value="/testinsert")
	public int testinsert(HttpServletRequest request){
		
		task.vpn();
		
		return 1;
		
	}
	
	
	
}
