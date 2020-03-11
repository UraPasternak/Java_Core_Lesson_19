package ua.lviv.lgs.hw19;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Employee e = new Employee("Олег", 21, 1000);
		Methods.serialize(e);
		Employee eDes = (Employee) Methods.deserialize();
		System.out.println(eDes); // якщо з salary зняти модифікатор transient то виводить: 
		                          // Employee [name=Олег, id=21, salary=1000]
		System.out.println("==================================");

		Employee e1 = new Employee("Юрій", 28, 1500);
		Methods.serialize(e1);
		Employee e1Des = (Employee) Methods.deserialize();
		System.out.println(e1Des);
		System.out.println("==================================");

		List<Employee> list = new ArrayList<>();
		list.add(e);
		list.add(e1);
		list.add(new Employee("Марія", 12, 700));
		list.add(new Employee("Руслан", 2, 1000));
		list.add(new Employee("Олена", 5, 1600));
		list.add(new Employee("Андрій", 33, 1000));
		
		Methods.serialize(list);
		List<Employee> listDeserialized = (List<Employee>) Methods.deserialize();
		System.out.println("Deserialized list:");
		for (Employee emp : listDeserialized)
			System.out.println(emp);

	}
}