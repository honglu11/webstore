/**
 * 
 */
package ca.sait.model;

/**
 * @author honglu
 *
 */
public class Person implements Comparable<Person>{
	
	private long oid;
	private String name;
	private long age;	

	/**
	 * 
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(long oid, String name, int age) {
		this.oid = oid;
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the oid
	 */
	public long getOid() {
		return oid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Person o) {
		// sorting by name
		//return name.toLowerCase().compareTo(o.getName().toLowerCase());
		if ( o == null )
			return -1;
		
		if (name==null) {
			if (o.getName() == null ) {
				return 0;
			}
			else
				return 1;
		}
		return name.compareToIgnoreCase(o.getName());
	}

	/**
	 * @param oid the oid to set
	 */
	public void setOid(long oid) {
		this.oid = oid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public long getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(long age) {
		this.age = age;
	}
	
	 @Override
	public String toString() {		
		return getOid() + " - " + getName() + " - " + getAge();
	}

	 // use source generate hashCode() and equal, hashCode return numberical hashcode for the Object, this is unique
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		System.out.println("Entered hashcode: " + toString());
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (age ^ (age >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (oid ^ (oid >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		System.out.println("Entered equals: "  + toString());
		// if pass person1, return true, if return person2, return false, then this if will be ignored. compare memory location here ony the same object will be the same.
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// compare what kind of class like String class, Person Class
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		
		// other.age can do since Person other in the same Person Class.
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		// blow out since !null.equal(other.name ) get null pointer exceptoin
//		if (!name.equals(other.name))
//		 return false;
//		  if (name == null) {
//			if (other.name != null)
//				return false;
//		}
		
		// keep in mind : only check negative, most of time, won't include oid in compare object
		if (oid != other.oid)
			return false;
		return true;
	}
	 
	// or we can implment the equal in default in interface

}
