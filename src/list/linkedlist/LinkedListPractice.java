package list.linkedlist;

import java.util.LinkedList;

public class LinkedListPractice {
	
	public static void main(String args[]) {
		//LinkedList<String> placesToVisit = new LinkedList<>(); // declare LinkedList
		
		var placesToVisit = new LinkedList<String>();
		placesToVisit.add("Sydney");
		placesToVisit.add(0, "Canberra");
		System.out.println(placesToVisit);
		
	
		addMoreElement(placesToVisit);
		System.out.println(placesToVisit);
		
		removeElements(placesToVisit);
		System.out.println(placesToVisit);
		
	}

	
	private static void addMoreElement(LinkedList<String> list) {
		
		list.add("Darwin");
		list.add("Hobart");
		
		//Queue methods
		list.offer("Melbourne");
		list.offerFirst("Brisbane");
		list.offerLast("Toowomba");
		// Stack Methods
		list.push("Alice Springs");
	}
	
	private static void removeElements(LinkedList<String> list) {
		list.remove(4);
		list.remove("Brisbane");
	
		System.out.println(list);
		String s1 = list.remove();
		System.out.println(s1 +" was removed");
		
		String s2 = list.removeFirst();
		System.out.println(s2 +" was removed");
		
		String s3 = list.removeLast();
		System.out.println(s3 +" was removed");
		
		
		//Queue/Deque poll
		String p1 = list.poll();
		System.out.println(p1 + " was removed");
		String p2 = list.pollFirst(); // remove first element;
		
		System.out.println(p2 + " was removed");
		String p3 = list.pollLast(); // remove last element
		System.out.println(p3 + " was removed");
	
		list.push("Sydney");
		list.push("Brisbane");
		list.push("Canberra");
		
		System.out.println(list);
		
		
		String p4 = list.pop();
		System.out.println(p4 + " was removed");
	}
	
	
	
}
