package individual.test;

import java.io.IOException;
import java.io.PrintWriter;

/*
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


import individual.context.Context;


public class TestServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private String data;
	private String cls;
	private Gson gson=new Gson(); 
	private PrintWriter writer;
	private Context context; 
	
	
	@Override
	public void init() throws ServletException {

		context=Context.getContext();
		context.addTranDataMap(TestCome.class,TestBack.class);
		context.addActor(TestActor.class);
		context.showWorks();
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		writer=resp.getWriter();
		data=req.getParameter("data");
		cls=req.getParameter("class");
		if(data==null||"".equals(data)||cls==null||"".equals(cls)) {
			onDefeat();
			return;
		}
		
	
		String result=context.back(gson.fromJson(data, context.getwork(cls)));
		if(result==null) {
			onDefeat();
			return;
		}
		writer.write(gson.toJson(result));
	
	
	}
	
	private void onDefeat() {
		writer.write("false");
	}

}
*/
