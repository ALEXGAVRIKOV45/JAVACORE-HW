package HW4;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class PhoneBook {
	private HashMap<String, HashSet<Integer>> Phbook = new HashMap<>();



	public void addManPhone( String name, int number){
		HashSet<Integer> num;
		if (Phbook.containsKey(name)) {
			num = Phbook.get(name);
		}
		else {
			num = new HashSet<>();
		}
		num.add(number);
		Phbook.put(name,num);
	}

	public void PrintPhoneBook(){
		System.out.println(Phbook);
	}

	public Set<Integer> getNumberByName (String name){
		return Phbook.get(name);
	}


}
