package com.calculations;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import com.valuepack.ValueProvider;


import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Controller
public class BMIController 
{
	
	@RequestMapping("/")
	public ModelAndView welcomeLocator()
	{
		ModelAndView model=new ModelAndView("Welcome");
		return model;
	}
	
	@RequestMapping("/Index")
	public ModelAndView enterIndex()
	{
		ModelAndView model=new ModelAndView("Index");
		return model;
	}
	
	@RequestMapping("/StandardBMICalculator")
	public ModelAndView standardBmiCalculator(@RequestParam("feet") int feet,@RequestParam("inch") int inch,@RequestParam("weight") float weight)
	{
		ModelAndView model=new ModelAndView("BMIResult");
		ValueProvider provider=new ValueProvider();
		Float bmi;
		int height=((feet*12)+inch);
		weight=weight*2.2f;
		bmi=((float)weight/(height*height))*provider.getValue();
		model.addObject("bmi",bmi);
		return model;
	}
	
	@RequestMapping("/MetricBMICalculator")
	public ModelAndView metricBmiCalculator(@RequestParam("height") float height,@RequestParam("weight") int weight)
	{
		ModelAndView model=new ModelAndView("BMIResult");
		Float bmi;
		bmi=((float)weight/(height*height));
		model.addObject("bmi",bmi);
		return model;
	}
	
	@RequestMapping("/HeightCalculator")
	public ModelAndView heightCalculator(@RequestParam("weight") int weight,@RequestParam("bmi") float bmi)
	{
		ModelAndView model=new ModelAndView("HeightResult");
		Float height;
		height=(float)Math.sqrt((weight/bmi));
		model.addObject("height",height);
		return model;
	}
	
	@RequestMapping("/WeightCalculator")
	public ModelAndView weightCalculator(@RequestParam("height") float height,@RequestParam("bmi") float bmi)
	{
		ModelAndView model=new ModelAndView("WeightResult");
		Float weight;
		weight=(float)(bmi*(height*height));
		model.addObject("weight",weight);
		return model;
	}

	@RequestMapping(value="/ValidateLogin", method=RequestMethod.POST)
	public ModelAndView validateLogin(@RequestParam("uName") String name,@RequestParam("password") String password,HttpServletRequest request)
	{
		ModelAndView model;
		BMIModel bmiModel=new BMIModel();
		if(bmiModel.checkUser(name, password))
		{
			model=new ModelAndView("Index");
			request.getSession().setAttribute("isLoggedIn", true);
		}
		else
		{
			model=new ModelAndView("WrongEntry");
		}
		
		return model;
	}
	
	@RequestMapping(value="/AddUsers", method=RequestMethod.POST)
	public ModelAndView addUsers(@RequestParam("uName") String name,@RequestParam("password") String password,HttpServletRequest request)
	{
		ModelAndView model;
		if((name!=null)&&(name!=""))
		{
			model=new ModelAndView("Success");
			request.getSession().setAttribute("isLoggedIn", true);
			BMIModel bmiModel=new BMIModel();
			bmiModel.addUsers(name, password);
		}
		else
			model= new ModelAndView("BlankEntries");
		return model;
	}
	
	@RequestMapping("/Logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		ModelAndView model=new ModelAndView("Welcome");
		request.getSession().setAttribute("isLoggedIn", false);
		return model;	
	}
	
	@RequestMapping("/MailSend")
	public ModelAndView sendMail(@RequestParam(value="name") String userName,@RequestParam(value="email") String userEmail,@RequestParam(value="msg") String msgBody)
	{
		ModelAndView model=new ModelAndView("MailSent");
		Properties prop = new Properties();
	    Session session = Session.getDefaultInstance(prop,null);
	    try{    
	        Message mimeMessage = new MimeMessage(session);
	        mimeMessage.setFrom(new InternetAddress("harirehm@gmail.com"));
	        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("harirehm@gmail.com", "Mr./Ms. "+userName));
	        mimeMessage.setSubject("Message from BMI calculations app");
	        mimeMessage.setText("Name :: "+userName+"\nEmail-id :: "+userEmail+"\n\nMessage body ::\n"+msgBody);
	        Transport.send(mimeMessage);
	        System.out.println("Successfull Delivery.");
	    } catch (AddressException e) {
	        e.printStackTrace();
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
		return model;
	}
	
}