package test;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;
import main.guessNumber.Length;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LengthExchangeTest {
	private String target;
	
	private String source;;
	
	private float result;
	
	private float sourceNum;
	
	@Test
	public void should_1_kilometer_when_1000_meter() throws Exception{
		Length unit=new Length();
		Assert.assertEquals(result, unit.exchange(target,source,sourceNum));
	}

	 public LengthExchangeTest(String target, String source,float i,float result) {
		 this.target=target;
		 this.source=source;
		 this.sourceNum=i;
		 this.result=result;
	    }
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{ Length.KILOMETER, Length.METER,1000,1.0f }, 
        		{ Length.METER, Length.KILOMETER,1,1000f }
                });
    }
}
