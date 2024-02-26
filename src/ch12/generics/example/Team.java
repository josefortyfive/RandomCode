package ch12.generics.example;

import java.util.List;
import java.util.ArrayList;

public class Team<T> {

	private String teamName;
	private List<T> teamMembers = new ArrayList<>();
	private int totalWins = 0;
	private int totalLosses = 0;
	private int totalTies = 0;
	
	public Team(String teamName) {
		this.teamName = teamName;
	}

	public void addTeamMember(T  t) {
		
		// if player is not added, add team player
		if(!teamMembers.contains(t)) {
			teamMembers.add(t);
		}
	}
	
	
	public void listTeamMembers() {
		System.out.println(teamName + " Roster: ");
		System.out.println(teamMembers);
	}
	
	public int ranking() {
		return (totalLosses * 2) + totalTies + 1;	
		
	}
	
	
	public String setScore(int ourScore, int theirScore) {
		
		String message = "lost to";
		if(ourScore > theirScore) {
			totalWins++;
			message = "beat";
		} else if (ourScore == theirScore) {
			totalTies++;
			message = "tied";
		} else {
			totalLosses++;
		}
		
		return message;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return teamName + " (Ranked " +ranking() + ") ";
	
	}
	
	
}
