
public class PersonTwo {
  public StringBuilder name = new StringBuilder(8);
  public StringBuilder phoneNumber = new StringBuilder();
  
  public void displayPersonInfo( ) {
	  name.append("hong").append(" ").append("lu");
	  
	  System.out.println(" Name " + name.toString());
	  System.out.println(" Name Capacity " + name.capacity());
  }

}
