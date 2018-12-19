package com.ly.study.thinkjava.guavatest;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Guava {
	 public static <T> void print(Collection<? super T> c) {
		System.out.println(c);
	}
	 
	public static void main(String[] args) {
		List<String> lst = null;
		print(lst);
		
		List<Integer> intList = Lists.newArrayList(1, 2, 3, 5, 6);
		System.out.println(intList);
		
		Predicate<Integer> predicate = new Predicate<Integer>() {
			@Override
			public boolean apply(Integer input) {
				return input != 3 && input != 5;
			}
		};
		
		List<Integer> resultList = Lists.newArrayList(Iterables.filter(intList, predicate));
		System.out.println(resultList);
		
		System.out.println(new Guava().getLevel(23.0));
	}
	
	// 2
	private Map<Predicate<Double>, String> config = Maps.newHashMap();
	{
		config.put(new Predicate<Double>() {
			@Override
			public boolean apply(Double input) {
				return input >= 90;
			}
		}, "优秀");
		
		config.put(new Predicate<Double>() {
			@Override
			public boolean apply(Double input) {
				return input >= 60 && input < 90;
			}
		}, "良好");
		
		config.put(new Predicate<Double>() {
			@Override
			public boolean apply(Double input) {
				return input < 60;
			}
		}, "不及格");
	}
	
	private String getLevel(Double score) {
		for (Map.Entry<Predicate<Double>, String> entry : config.entrySet()) {
			if (entry.getKey().apply(score)) {
				return entry.getValue();
			}
		}
		return "unknown";
	}

	// 3
}

class LowRainfallPredicate implements Predicate<City> {
	@Override
	public boolean apply(City input) {
		return input.getAverageRainfall() < 40;
	}
}

class City {
	private String name;
	private String zipCode;
	private Integer population;
	private String climate;
	private double averageRainfall;

	public City() {
	}

	public City(String name) {
		this(name, null, null);
	}

	public City(String name, String zipCode, Integer population) {
		this.name = name;
		this.zipCode = zipCode;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public double getAverageRainfall() {
		return averageRainfall;
	}

	public void setAverageRainfall(double averageRainfall) {
		this.averageRainfall = averageRainfall;
	}

}