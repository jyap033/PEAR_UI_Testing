package scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class dataProvider {
@Test(dataProvider = "getData")
public void setData(String username, String password)
{
	System.out.println("Your name is:" + username);
	System.out.println("Your password is:" + password);
}

@DataProvider
public Object[][] getData(){
	Object[][] data = new Object[2][2];
	
	//first row
	data[0][0] = "user1";
	data[0][1] = "abcd";
	
	//second row
	data[1][0] = "user2";
	data[1][1] = "abcd2";
	return data;
			
}
}
