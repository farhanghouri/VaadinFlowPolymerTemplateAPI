package com.gmail.vasim.spring;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel; 

@Route("login")
@HtmlImport("src/LoginForm.html")
@Tag("login-form")
public class MyForm extends PolymerTemplate<MyForm.FormModel>{
 
	@Id("name")
	TextField name;
	@Id("email")
	TextField email;
	@Id("submit")
	Button submit_button;
	

	public interface FormModel extends TemplateModel{
		void setTitle(String title);
		String getUserInput();
		void setUserInput(String userInput);
	}
	
	public MyForm() {
		   getModel().setTitle("Login Form");
		   
		   getModel().setUserInput("waseem"); // not working
		   
		   name.setPlaceholder("name");
		   email.setPlaceholder("email");
		   
		   submit_button.addClickListener(event->{ 
			   submit_button.addClassName("update");
			   getModel().setTitle("Login Form New");
			  Notification.show(name.getValue()+" "+email.getValue() + " "+getModel().getUserInput()); 
		   });
	}
	
	@EventHandler
	void sayHello(){
		Notification.show("hello"); 
	}
	
}
