package test;

import junit.framework.Assert;
import main.guessNumber.MyIllegalUnitException;
import main.guessNumber.Length;

import org.junit.Test;

public class UnitTest {
	@Test
	public void should_1_kilometer_when_1000_meter() throws Exception{
		Length unit=new Length();
		Assert.assertEquals(1.0f, unit.exchange(Length.KILOMETER,Length.METER,1000));
	}
	
	
	@Test
	public void should_2000_meter_when_2_kilometer() throws Exception{
		Length unit=new Length();
		Assert.assertEquals(2000f, unit.exchange(Length.METER,Length.KILOMETER,2));
	}
	
	@Test(expected=Exception.class)
	public void should_throw_exception_when_not_greater_than_0_kilometer() throws Exception{
		Length unit=new Length();
		Assert.assertEquals(2000f, unit.exchange(Length.METER,Length.KILOMETER,-1));
	}
	
	
	@Test(expected=MyIllegalUnitException.class)
	public void should_throw_exception_when_not_support_unit() throws Exception{
		Length unit=new Length();
		Assert.assertEquals(2000f, unit.exchange("km","mi",2));
	}
	
	
	@Test
	public void should_greater_when_2000_meter_and_1000_meter(){
		Length unit=new Length();
		Assert.assertEquals(1,unit.compare(2000f,1000f));
	}
	
	@Test
	public void should_equals_when_2_meter_and_2_meter(){
		Length unit=new Length();
		Assert.assertEquals(0,unit.compare(2f,2f));
	}
	
	@Test
	public void should_less_when_1000_meter_and_2000_meter(){
		Length unit=new Length();
		Assert.assertEquals(-1,unit.compare(1000f,2000f));
	}
	
	@Test
	public void should_6_when_2_meter_add_4_meter(){
		Length unit=new Length();
		Assert.assertEquals(6.0f,unit.add(2f,4f));
	}
	
	@Test
	public void should_2_when_5_meter_sub_3_meter(){
		Length unit=new Length();
		Assert.assertEquals(2.0f,unit.sub(5f,3f));
	}
	
	@Test
	public void should_greater_when_1_kilometer_compare_3_meter() throws Exception{
		Length unit=new Length();
		Assert.assertEquals(1,unit.compare(Length.KILOMETER,2000f,Length.METER,1000f));
	}
	
//	@Test
//	public void should_greater_when_1_kilometer_compare_3_meter() throws Exception{
//		Unit unit=new Unit();
//		Assert.assertEquals(1,unit.compare(Unit.KILOMETER,2000f,Unit.METER,1000f));
//	}
}
