package com.alison.service;

import java.io.IOException;
import java.util.List;

import com.alison.dao.HobbyDao;
import com.alison.dao.PersonDao;
import com.alison.pojo.Hobby;
import com.alison.pojo.Person;

public class PersonService {
	
	private PersonDao pdao;
	private HobbyDao hdao;
	
	public PersonService() throws IOException{
		System.out.println("进入service");
		pdao = new PersonDao();
	}
	
	public void addPerson(Person p, List<String> hobbies){
		pdao.addPerson(p);
		for(String h : hobbies){
			Hobby hobby = new Hobby(h,p.getId());
			hdao.addHobby(hobby);
		}
	}
	
	public List<Person> listAll(){
		return pdao.listAll();
	}
	
}
