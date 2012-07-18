package main.guessNumber;

import java.util.HashMap;
import java.util.Map;

public class Length {

	public static final String METER = "meter";
	public static final String KILOMETER = "kilometer";
	public static final  Map<String,Float> rates=new HashMap<String,Float>();
	
	
	static{
		rates.put(KILOMETER+"_"+METER, 0.001F);
		rates.put(METER+"_"+KILOMETER, 1000F);
	}
	
	
	public float exchange(String target, String source, float i) throws Exception {
		if(i<0)
			throw new MyIllegalParameterException();
		Float rate = rates.get(target+"_"+source);
		if(rate ==null)
			throw new MyIllegalUnitException();
		return i*rate;
	}


	public int compare(float f, float g) {
		if(f==g)
			return 0;
		return f>g?1:-1; 
	}


	public float add(float f, float g) {
		return f+g;
	}


	public float sub(float f, float g) {
		return f-g;
	}


	public int compare(String target, float f, String source, float g) throws Exception {
		if(!this.rates.containsKey(target+"_"+source))
			throw new MyIllegalUnitException();
		float  souceValue=this.exchange(target, source, g);
		return compare(f,souceValue);
		
	}
	
}
