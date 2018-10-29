/*
 * 
 * Author: Muhammad Ahmed
 * Purpose: Reads data from text file
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	List<Double> data = new ArrayList<Double>();
	List<Double> timeIndex = new ArrayList<Double>();
	static double s = 1/44100;
	static int sampleSize= 32;
	Reader()
	{
	//data= null;
	}
	
	public void importData()
	  throws IOException {
	     String file ="src/ringtoneData.txt";
	      
	     BufferedReader readerO = new BufferedReader(new FileReader(file));
	    int i=0;
	    String t=null;
	    while ( i<sampleSize) {
			timeIndex.add(i*s);

	    	t= readerO.readLine();
			data.add(Double.parseDouble(t));
			i=i+1;	     
	}
	     readerO.close();

	}
	
	public double getData(int i)
	{
		return data.get(i);
	}
	public double getTimeData(int i)
	{
		return timeIndex.get(i);
	}
	
	public double[] getRealData()
	{
		double[] tempA =new double[data.size()];
		for (int i=0; i<data.size();i++)
		{
			tempA[i]=data.get(i);
		}
		return tempA;
	}
	public double[] getImagData()
	{
		double[] tempA =new double[timeIndex.size()];
		for (int i=0; i<timeIndex.size();i++)
		{
			tempA[i]=timeIndex.get(i);
		}
		return tempA;
	}

}
