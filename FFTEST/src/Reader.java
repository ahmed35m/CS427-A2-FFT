/*
// program: Reader.java
// author: Muhammad Ahmed
// course: CS 427
// date: 29-Oct-2018
// assignment #3
// description: this class's purpose is to import sound data
//from a text file into arrays and provide FFT.java the array when requested through the getters.
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
	static int sampleSize= 65536;
	Reader()
	{
	//data= null;
	}
	
	public void importData()
	  throws IOException {
	     String file ="src/myToneProcessed.txt";
	      
	     BufferedReader readerO = new BufferedReader(new FileReader(file)); //Initialize and read file
	    int i=0;
	    String t=null;
	    while ( i<sampleSize) {
			timeIndex.add(i*s);  	//add time index

	    	t= readerO.readLine();  	//read the line into a string
			data.add(Double.parseDouble(t));
			i=i+1;	     
	}
	     readerO.close();			//Close file after processing

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
			tempA[i]=data.get(i);   // cast arraylist to double[] type
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
