package Test;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import com.locker.BagNotExistException;
import com.locker.DepositBag;
import com.locker.DepositResult;
import com.locker.DepositStatus;
import com.locker.GeneratePwd;
import com.locker.MyBag;

public class LockerTest {

	@Test
	public void should_not_equal_when_get_pwd_twice(){
		GeneratePwd  generatePwd= new GeneratePwd();
		String pwd=generatePwd.generatePwd();		
		String pwd2=generatePwd.generatePwd();
		Assert.assertEquals(false, pwd.equals(pwd2));
	}
	
	@Test
	public void should_depositBag_success_when_stock_is_not_full(){
		DepositBag depositBag=new DepositBag(Arrays.asList(new Integer[]{0,1,0}));
		DepositStatus result = depositBag.deposit(new MyBag()).getStatus();
		Assert.assertEquals(DepositStatus.SUCCESS, result);
	}
	
	@Test
	public void should_depositBag_success_when_stock_is_full(){
		DepositBag depositBag=new DepositBag(Arrays.asList(new Integer[]{0,1,0}));
		depositBag.deposit(new MyBag());
		DepositResult result=depositBag.deposit(new MyBag());
		Assert.assertEquals(DepositStatus.STOCK_IS_FULL, result.getStatus());
	}
	
	@Test
	public void should_getBag_success_when_the_exists_pwd()  {
		DepositBag depositBag=new DepositBag(Arrays.asList(new Integer[]{0,1,0}));
		MyBag box=new MyBag();
		DepositResult result = depositBag.deposit(box);		
		MyBag bag = depositBag.getBag(result.getPwd());
		Assert.assertSame(box,bag);
	}
	
	@Test(expected=BagNotExistException.class)
	public void should_getBag_success_when_not_exists_pwd(){
		DepositBag depositBag=new DepositBag(Arrays.asList(new Integer[]{0,1,0}));		
		depositBag.getBag("1234");
	}

	@Test
	public void should_not_beyond_maxStock(){
		DepositBag depositBag=new DepositBag(Arrays.asList(new Integer[]{0,1,0}));
		Assert.assertFalse(depositBag.isBeyondMaxStock());
	}
}
