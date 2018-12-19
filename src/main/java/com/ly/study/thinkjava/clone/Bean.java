package com.ly.study.thinkjava.clone;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class Bean {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		//////////////////////////////////////////////
		List<Human> lst = new ArrayList<>();
		lst.add(new Human(11));
		lst.add(new Human(12));

		List<Human> lst2 = (List)BeanUtils.cloneBean(lst);
		for (Human h : lst2) {
			System.out.println(h.getAge());
		}
		
		/////////////////////////////////////////////
		Collection<Employee> org = new HashSet<>();
		Human h = new Human(23);
		org.add(new Employee(h, "Manager"));   

        Collection<Employee> copy = new HashSet<Employee>(org.size());   
        Iterator<Employee> iterator = org.iterator();   
        while(iterator.hasNext()){   
            copy.add(iterator.next().clone());   
        }  

        System.out.println(org);
        System.out.println(copy);
        System.out.println();
        
        Iterator<Employee> itr = copy.iterator();   
        while(itr.hasNext()){   
        	itr.next().getHuman().setAge(11);
//            itr.next().setDesignation("staff");   
        }   
        System.out.println(org);
        System.out.println(copy);
	}
}

class Employee implements Cloneable {   
    private Human human;   
    private String designation;   
      
    public Employee(Human human, String designation) {   
        this.human = human; 
        this.designation = designation;   
    }   
    public String getDesignation() {   
        return designation;   
    }   
      
    public void setDesignation(String designation) {   
        this.designation = designation;   
    }   
      
    public Human getHuman() {
		return human;
	}
	public void setHuman(Human human) {
		this.human = human;
	}
	@Override public String toString() {   
        return String.format("%s: %s", human.getAge(), designation );   
    }   
    @Override   
    protected Employee clone() {
        Employee clone = null;   
        try{   
            clone = (Employee)super.clone();   
            clone.human = human.clone();
        }catch(CloneNotSupportedException e){   
            throw new RuntimeException(e);  // won't happen   
        }   
        return clone;   
    }  
}  