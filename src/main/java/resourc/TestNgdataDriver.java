package resourc;



import org.testng.annotations.DataProvider;



public class TestNgdataDriver {
	
	@DataProvider(name = "getData")
	public static Object[][] getData() {
		
		//ist combination username and password- good credit history
		//2nd comb username and password- no credit history					// we have 3 combination(rows), each with 2 values(column) 
		//3rd comb username and password - bad credit history			// this means an Array with 3rows and 2 columns
		
		// Now Define A Multi-Dimentional Array
		Object[][] dat = new Object[3][2];
		// 1st
		dat[0][0]= "olushesi@yahoo.com";
		dat[0][1]= "Rodmanraylex1";
		
		// 2st
		dat[1][0]= "secondusername";
		dat[1][1]= "secondpassword";
		
		// 3st
		dat[2][0]= "thirdusername";
		dat[2][1]= "thirdpassword";
		
		//Now we need to return data so that Method MobileLoginLoan() can catch it
		return dat;
		
	}

}
