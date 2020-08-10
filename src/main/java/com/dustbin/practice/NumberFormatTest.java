package com.dustbin.practice;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {

	public static void main(String[] args) {
		
		Locale indiaLocale = new Locale("en","IN");
		
		//System.out.println(Locale.US);
		//System.out.println(indiaLocale);
		
		double payment = 12324.134d;
		
		NumberFormat us= NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat india= NumberFormat.getCurrencyInstance(indiaLocale);
		NumberFormat chaina= NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat france= NumberFormat.getCurrencyInstance(Locale.FRANCE);
		
		System.out.println("US: " + us.format(payment));
        System.out.println("India: " + india.format(payment));
        System.out.println("China: " + chaina.format(payment));
        System.out.println("France: " + france.format(payment));

	}

}
