package test;

import junit.framework.Assert;
import main.Juxing;
import main.Point;

import org.junit.Test;

public class JuxingTest {
	
	
	@Test
	public void juxingIsIntersect(){
		Juxing jx = new Juxing(new Point(2,6),new Point(6, 2));
		Juxing jx2 = new Juxing(new Point(3,4), new Point(4,3));
		Assert.assertTrue(jx.compare(jx2));
		//Assert.assertTrue(jx.compare(jx2) || jx2.compare(jx));
	}
	
	@Test
	public void juxingIsNotIntersect(){
		Juxing jx = new Juxing(new Point(2,4),new Point(5,2));
		Juxing jx2 = new Juxing(new Point(6,8), new  Point(10,5));
		Assert.assertFalse(jx.compare(jx2));
	}
}