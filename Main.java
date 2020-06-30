import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Main {
	static List<Commodity> list = new ArrayList<Commodity>();
	static void createCommodity(String name,String typename,float rate, int price){
		System.out.println("Name ->"+name);
		System.out.println("Type of Commodity ->"+typename);
		System.out.println("GST rate -> "+rate);
		System.out.println("price ->"+price);

		Type type = new Type(typename,rate);
		Commodity com = new Commodity(type,name,price);
		list.add(com);
	}
	static void deleteCommodity(int c){
		list.remove(c-1);
		System.out.println("Deleted");


		
	}
	static void updateCommodity(int c){
		Commodity com = list.get(c-1);
		System.out.print("What do you want to update?");
		int ch;
		try(BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in))){
			do {
				System.out.println("1.Name\n2.Type \n3.GST Rate\n4.Price\n5.No more updates");
				ch = Integer.parseInt(bufferedReader.readLine());
				switch(ch){
					case 1: System.out.println("Enter New Name");
							com.set_name(bufferedReader.readLine());
							break;
					case 2: System.out.println("Enter New Type");
							com.set_type(new Type(bufferedReader.readLine(),com.get_type().get_gstRate()));
							break;
					case 3: System.out.println("Enter New GST RATE");
							com.set_type(new Type(com.get_type().get_type(),Float.parseFloat(bufferedReader.readLine())));
							break;
					case 4: System.out.println("Enter New Price");
							com.set_price(Integer.parseInt(bufferedReader.readLine()));
							break;
					case 5: System.out.println("No More updates...");
							break;
					default:System.out.println("Enter right choice");
				}
			}while(ch !=5);
		}catch(IOException e){

		}
	}
	static void sellItems(){
		float total_price = 0;
		try(BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in))){
		System.out.println("Select item and enter quantity\ne.g 1 5 \nEnter Bill Please to create bill");
		listItem();
		Commodity com;
		int index = -1;
		int quantity = 0;
		String[] items;
		items = bufferedReader.readLine().split(" ");
		while(!(items[0].equals("Bill") && items[1].equals("Please"))){	
			index = Integer.parseInt(items[0]);
			quantity = Integer.parseInt(items[1]);
			com = list.get(index-1);

			total_price += calculateTotal(com.get_type().get_gstRate(),com.get_price(),quantity);
			items = bufferedReader.readLine().split(" ");
		}
		System.out.println("Total Bill is Rs(final price)."+ total_price);
	}catch(IOException e){

	}

	}
	static float calculateTotal(float rate, int price,int quantity){
		return ((price+((price / 100) * rate)) * quantity);
	}
	static void listItem(){
		int i = 1;
		for(Commodity c: list){
			System.out.println(i+":Name ->"+c.get_name());
			System.out.println("Type ->"+c.get_type().get_type());
			System.out.println("GST Rate per unit -> "+c.get_type().get_gstRate());
			System.out.println("Price per unit ->"+c.get_price());
			System.out.println("===================================\n");
			i++;
		}
	}

	public static void main(String args[]){
		int choice;
		// Scanner in = new Scanner(System.in);
		try(BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in))){
		do{
			System.out.println("1.Create Commodity\n2.Delete Commodity\n3.Update Commodity\n4.Sell items\n5.List\n6.Exit");
			// in = new Scanner(System.in);
			int c = -1;
			choice = Integer.parseInt(bufferedReader.readLine());
			switch(choice){
			

				case 1 :	     
								System.out.println("PLEASE Enter like this'name type price gstrate'");
  								  String[] str = bufferedReader.readLine().split(" ");
    							  int price = Integer.parseInt(str[2]);
    							  float rate = Float.parseFloat(str[3]);
    							  createCommodity(str[0],str[1],rate,price);
    					break;
              
				case 2 :	
							listItem();
							c = Integer.parseInt(bufferedReader.readLine());
							deleteCommodity(c);
					break;
          
				case 3 :
              listItem();
							c = Integer.parseInt(bufferedReader.readLine());
							updateCommodity(c);
						break;
            
				case 4 :	
                sellItems();
					break;
				case 5 :	
                listItem();
					break;
          
				case 6:	
                System.out.print("Thank You...");
						break;
            
				default:
					System.out.println("Enter Valid Choice\n");
			}
		}while(choice !=6);
		}
   							 catch(IOException exception){
    
    						}
	}
}
