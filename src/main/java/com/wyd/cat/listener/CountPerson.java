package com.wyd.cat.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CountPerson implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("网站统计计数器，开始");
        //获取ServletContext对象
		ServletContext context=sce.getServletContext();
		try{
			//从文件中读取计数器的数值
			BufferedReader reader=new BufferedReader(
					new InputStreamReader(context.getResourceAsStream("/count.txt")));
			int count=Integer.parseInt(reader.readLine());
			System.out.println(count);
			reader.close();
			//把计数器对象保存到Web应用范围
			context.setAttribute("counter",count);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("计数器已经销毁");
        //获取ServletContext对象
		ServletContext context=sce.getServletContext();
        //从Web应用范围获得计数器对象
		int counter=(Integer)context.getAttribute("counter");

		if(counter != 0){
			try{
				//把计数器的数值写到count.txt文件中,这里最好把路径输出一下，网站运行时的物理路径
				String filepath=context.getRealPath("");
				filepath=filepath+"/count.txt";
				System.out.println(filepath);
				PrintWriter pw=new PrintWriter(filepath);
				counter++;//统计数量累加
				System.out.println(counter);
				pw.println(counter);
				pw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}	
}

