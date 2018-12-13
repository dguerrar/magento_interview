package com.dguerrar.integration.tests;

import java.util.ArrayList;
import java.util.List;

import com.dguerrar.domain.Line;
import com.dguerrar.domain.Order;
import com.dguerrar.domain.ProcessingOrder;

public class TestSetup {
	

	public  static  ProcessingOrder ORDER1;
	public  static  ProcessingOrder ORDER11;
	public  static  ProcessingOrder ORDER2;
	public  static  ProcessingOrder ORDER3;
	public  static  ProcessingOrder ORDER4;
	public  static  String ORDER5_STR;
	
	
	public  static  Order OORDER1;
	public  static  Order OORDER11;
	public  static  Order OORDER2;
	public  static  Order OORDER3;
	public  static  Order OORDER4;


	
	
	
	public TestSetup() {
		
		ORDER5_STR="{\"id\":1,\"store_id\":10,\"lines\":[{\"line_number\":1,\"sku\":\"line1\"},{\"line_number\":2,\"sku\":\"line2\"},{\"line_number\":3,\"sku\":\"line3\"}]}";
		
		
        OORDER11= new Order();
        OORDER11.setId(1l);
        OORDER11.setStore_id(10l);
        Line line11= new Line(1l, "line1");
        Line line12= new Line(2l, "line2");
        Line line13= new Line(3l, "line3");
        List<Line> lines1= new ArrayList<>();
        lines1.add(line11);
        lines1.add(line12);
        lines1.add(line13);
        OORDER11.setLines(lines1);
        
        
        OORDER1= new Order();
        OORDER1.setId(1l);
        OORDER1.setStore_id(10l);
        Line line1= new Line(1l, "line1");
        Line line2= new Line(2l, "line2");
        Line line3= new Line(3l, "line3");
        List<Line> lines= new ArrayList<>();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        OORDER1.setLines(lines);
        
        OORDER2= new Order();
        OORDER2.setId(2l);
        OORDER2.setStore_id(10l);
        Line line21= new Line(2l, "line1");
        Line line22= new Line(3l, "line2");
        Line line23= new Line(4l, "line3");
        List<Line> lines2= new ArrayList<>();
        lines2.add(line21);
        lines2.add(line22);
        lines2.add(line23);
        OORDER2.setLines(lines2);
        
        OORDER3= new Order();
        OORDER3.setId(3l);
        OORDER3.setStore_id(10l);
        Line line31= new Line(1l, "line1");
        Line line32= new Line(3l, "line2");
        Line line33= new Line(4l, "line3");
        List<Line> lines3= new ArrayList<>();
        lines3.add(line31);
        lines3.add(line32);
        lines3.add(line33);
        OORDER3.setLines(lines3);
        
        OORDER4= new Order();
        OORDER4.setId(3l);
        OORDER4.setStore_id(10l);
        List<Line> lines4= new ArrayList<>();
        OORDER4.setLines(lines4);
        
        ORDER1= new ProcessingOrder();
        ORDER1.setOrder(OORDER1);
        
        ORDER11= new ProcessingOrder();
        ORDER11.setOrder(OORDER11);
        
        ORDER2= new ProcessingOrder();
        ORDER2.setOrder(OORDER2);
        
        ORDER3= new ProcessingOrder();
        ORDER3.setOrder(OORDER3);
        
        ORDER4= new ProcessingOrder();
        ORDER4.setOrder(OORDER4);
	}
	
}
