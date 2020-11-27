package app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class User{
	
	private String name;
	private int alter;
	public User(String name, int alter) {
	
		this.name = name;
		this.alter = alter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", alter=" + alter + "]";
	}
	
	
}

public class Test {
	
	public static void main(String[] args) {
		
		List<String> namen = Arrays.asList("Max","Anton","Ilse","Max","Ina"); 
		
		Stream<String> namenStream = namen.stream();
		
		//distinct-Liste eindeutig
		System.out.println(namenStream.distinct().collect(Collectors.toList()));
		
		
		List<User> users = Arrays.asList(	new User("Max",34),
											new User("Inge",24),
											new User("Anton",14)  );
		
		// filter
		List<User> oldUsers = users.stream().filter( u-> u.getAlter() > 18 ).collect(Collectors.toList());
		System.out.println(oldUsers);
		// map
		
		List<String> usernames = users.stream().
				filter(u-> u.getAlter() > 18 ).
				map(u-> u.getName()).  // map -> convertiert hier zu String-List
				collect(Collectors.toList());
		
		System.out.println(usernames);
		
		// reduce reduziert immer auf ein Ergebnis-Objekt
		
		User user = users.stream().reduce( (u1,u2)-> u1.getAlter()<u2.getAlter()?u1:u2 ).get();
		System.out.println(user);
		
	}

}
