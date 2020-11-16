package window;

import java.io.*;
import java.util.*;
import simulate.*;

public class GenerateController {
	public static GenerateController GC = new GenerateController();
	
	public void Generate(int type,String parameter,String Num) throws IOException {
		int num = Integer.parseInt(Num);
		String[] p = parameter.split(",");
		if(type>6) {
			RealDisFactory rd = new RealDisFactory();
			AbstractRealDistribution r =  rd.CreateDis(type-6, p);
			double[] out=r.sample(num);
			File f = new File(GetTime());
	        FileOutputStream fop = new FileOutputStream(f);
	        // ����FileOutputStream����,�ļ������ڻ��Զ��½�
	 
	        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
	        // ����OutputStreamWriter����,��������ָ������,Ĭ��Ϊ����ϵͳĬ�ϱ���,windows����gbk
	        for(int i = 0; i < num; i++) { 
	        	if(i == num - 1) {
	        		writer.append(String.valueOf(out[i]));
	        		break;
	        	}
	        	writer.append(String.valueOf(out[i])+","); 
	        	}
	        // д�뵽������
	        writer.close();
	        // �ر�д����,ͬʱ��ѻ���������д���ļ�,���������ע�͵�
	        fop.close();
	        System.gc();
		}else {
			IntegerDisFactory id = new IntegerDisFactory();
			AbstractIntegerDistribution a = id.CreateDis(type,p);
			int[] out=a.sample(num);
			File f = new File(GetTime());
	        FileOutputStream fop = new FileOutputStream(f);
	        // ����FileOutputStream����,�ļ������ڻ��Զ��½�
	 
	        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
	        // ����OutputStreamWriter����,��������ָ������,Ĭ��Ϊ����ϵͳĬ�ϱ���,windows����gbk
	        for(int i = 0; i < num; i++) { 
	        	if(i == num - 1) {
	        		writer.append(String.valueOf(out[i]));
	        		break;
	        	}
	        	writer.append(String.valueOf(out[i])+","); 
	        	}
	        // д�뵽������
	        writer.close();
	        // �ر�д����,ͬʱ��ѻ���������д���ļ�,���������ע�͵�
	        fop.close();
	        System.gc();
		}
	}
	
	public String GetTime() {
		//����Calendar����
		  Calendar cal=Calendar.getInstance();
		  
		  //��Calendar���ṩ�ķ�����ȡ�ꡢ�¡��ա�ʱ���֡���
		  int year  =cal.get(Calendar.YEAR);   //��
		  int month =cal.get(Calendar.MONTH)+1;  //��  Ĭ���Ǵ�0��ʼ  ��1�»�ȡ������0
		  int day   =cal.get(Calendar.DAY_OF_MONTH);  //�գ���һ�����еĵڼ���
		  int hour  =cal.get(Calendar.HOUR_OF_DAY);  //Сʱ
		  int minute=cal.get(Calendar.MINUTE);   //��
		  int second=cal.get(Calendar.SECOND);  //��
		  
		  //ƴ�ӳ��ַ������
		  return year+"-"+month+"-"+day+"_"+hour+"."+minute+"."+second+".txt";
	}
}
