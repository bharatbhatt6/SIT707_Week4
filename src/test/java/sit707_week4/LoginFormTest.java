package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s223148345";
		Assert.assertNotNull("Student ID is s223148345", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Bharat Bhatt";
		Assert.assertNotNull("Student name is Bharat Bhatt", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	
	
	@Test
    public void testFailEmptyUsernameAndWrongPassword()
    {
		LoginStatus status = LoginForm.login(null, "abcde");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	
	@Test
    public void testFailEmptyUsernameAndCorrectPassword()
    {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	
	@Test
    public void testFailWrongUsernameAndEmptyPassword()
    {
		LoginStatus status = LoginForm.login("XYZ", null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	
	@Test
    public void testFailWrongUsernameAndWrongPassword()
    {
		LoginStatus status = LoginForm.login("ABC", "xyzm");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
    public void testFailWromgUsernameAndCorrectPassword()
    {
		LoginStatus status = LoginForm.login("LMAO", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	
	@Test
    public void testFailCorrectUsernameAndEmptyPassword()
    {
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	
	@Test
    public void testFailCorrectUsernameAndWrongPassword()
    {
		LoginStatus status = LoginForm.login("ahsan", "LOL");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	
	@Test
    public void testFailCorrectUsernameAndCorrectPasswordAndCorrectValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		boolean res = LoginForm.validateCode(null);
		Assert.assertTrue( res== false );
    }
	
	
	@Test
    public void testFailCorrectUsernameAndCorrectPasswordAndWrongValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		boolean res = LoginForm.validateCode("99456");
		Assert.assertTrue( res== false );
    }
	
	
	@Test
    public void testPassCorrectUsernameAndCorrectPasswordAndCorrectValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		boolean res = LoginForm.validateCode("123456");
		Assert.assertTrue( res== true );

    }
	
	
}
