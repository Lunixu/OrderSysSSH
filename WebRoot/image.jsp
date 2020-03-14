<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/jepg; charset=utf-8" import="java.awt.*,java.awt.image.*,javax.imageio.*,java.io.File"%>
<%
	int width = 90;//验证码宽度
	int height = 38;//验证码高度
	int codeCount = 4;//验证码个数
	int lineCount = 19;//干扰线条数
	
	char[] codeSequence = {'A','B','C','D','E','F','G','H','I','J','K','L',
							'M','N','P','Q','R','S','T','U','V','W','X'
							,'Y','Z','1','2','3','4','5','6','7','8','9'};
	//定义随机类
	Random r = new Random();
	//定义存储验证码的类
	StringBuilder builderCode = new StringBuilder();
	//定义画布
	BufferedImage buffer = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
	//得到画笔
	Graphics g = buffer.getGraphics();
	//1、设置颜色，化边框
	g.setColor(Color.black);
	g.drawRect(0, 0, width, height);
	//2、设置颜色，填充内部
	g.setColor(Color.white);
	g.fillRect(1, 1, width-2, height-2);
	//3、设置干扰线
	g.setColor(Color.gray);
	for(int i = 0; i < lineCount; i++){
		g.drawLine(r.nextInt(width), r.nextInt(width), r.nextInt(width), r.nextInt(width));
	}
	//4、设置验证码颜色
	g.setColor(Color.blue);
	//4、1设置验证码字体
	g.setFont(new Font("宋体", Font.BOLD, 20));
	for(int i = 0; i < codeCount; i++){
		char c = codeSequence[r.nextInt(codeSequence.length)];
		builderCode.append(c);
		g.drawString(c+"", 15*(i+1), 23);
	}
	//6、保存验证码到session中
	session.setAttribute("codeValidate", builderCode.toString());
	System.out.print(session.getAttribute("codeValidate"));
	//7、强验证码亚索诚JPEG图片个是，并放入相应中
	ImageIO.write(buffer, "jpeg", response.getOutputStream());
	//ImageIO.write(buffer, "png", new File("D://111.png"));
	//8、清空缓存
	out.clear();
	//9、放在body中
	out = pageContext.pushBody();
%>