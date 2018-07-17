package com.mastercard.pts.integrated.issuing.utils;


public class Exceptionhandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		handle(e);
		
	}
	
	public void handle(Throwable throwable)
	{
		System.out.println("We will rock you++++++++++++++++++++++++++"+throwable.getMessage());
       if(throwable.getMessage().contains("StaleElementReferenceException")){
    	   System.out.println("We will rock you++++++++++++++++++++++++++");
       }
	}
	
	 public static void registerExceptionHandler() {
		    Thread.setDefaultUncaughtExceptionHandler(new Exceptionhandler());
		    //System.setProperty("sun.awt.exception.handler", Exceptionhandler.class.getName());
		  }
}