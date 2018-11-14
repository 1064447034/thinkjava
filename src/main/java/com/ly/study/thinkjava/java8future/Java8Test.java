package com.ly.study.thinkjava.java8future;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {
	public static void main(String[] args) {
		Integer[] num = {10, 30, 17, 20, 15, 18, 45, 12};
		List<Integer> lst = Arrays.asList(num);
		lst.stream().sorted((a, b)->a - b).forEach(System.out::println);
		
		Collections.sort(lst, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		System.out.println(lst);
		
		Integer[] nums = {1, 20, 63, 58, 185, 60, 59, 20};
		System.out.println(Arrays.stream(nums).filter(x->x>50).count());
		
		Random r = new Random();
		Supplier<Integer> supplier = r::nextInt;
		
		Stream.generate(supplier).limit(10).forEach(System.out::println);
		
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
	
		Optional accResult = Stream.of(1, 2, 3, 4).reduce((acc, item)->{acc += item; return acc;});
		System.out.println(accResult.get());
		
		Integer ret = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		System.out.println(ret);
		
		Stream.of("aaaa", "bbbb", "cccc").reduce(String::concat);
		
		
		Set<Integer> collectList = Stream.of(1, 2, 3, 4).collect(Collectors.toSet());
		System.out.println(collectList);
		
		
		Optional<Integer> collectMaxBy = Stream.of(1, 2, 3, 4).collect(Collectors.maxBy(Comparator.comparingInt(o->o)));
		System.out.println(collectMaxBy.get());
		
		
		Map<Boolean, List<Integer>> collectPart = Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(x->x % 2 == 0));
		System.out.println(collectPart);
		
		Map<Boolean, List<Integer>> collectGroup = Stream.of(1, 2, 3, 4).collect(Collectors.groupingBy(x->x % 2 == 0));
		System.out.println(collectGroup);
		
		
		System.out.println(Stream.of("a", "b", "c", "d").collect(Collectors.joining("|")));
		
        Optional<Integer> opt = Stream.of(1, 3, 5, 7, 9).filter(x->x > 10).findFirst();
        System.out.println(opt.isPresent());
        
        Optional<Integer> opt2 = Stream.of(1, 3, 5, 7, 9).filter(x->x == 5).findFirst();
        System.out.println(opt2.isPresent());
        
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).parallelStream().forEachOrdered(x->System.out.print(x + " "));
	}
}

