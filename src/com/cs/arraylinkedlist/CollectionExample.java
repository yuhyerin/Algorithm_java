package com.cs.arraylinkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionExample {
	
	// map은 콜렉션 하위가 아님.
	Map<String, String> hashmap = new HashMap<>();
	Map<String, String> hashtable = new Hashtable<>();
	Map<String, String> treemap = new TreeMap<>();
	
	// 콜렉션에 크게 List, Set 있음. 
	List<String> linkedlist = new LinkedList<>();
	List<String> stack = new Stack<>();
	List<String> vector = new Vector<>();
	List<String> arraylist = new ArrayList<>();
	
	Set<String> hashset = new HashSet<>();
	Set<String> sortedset = new TreeSet<>();

}
