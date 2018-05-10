package cn.java.entity;

public class User {
	private int id;
	private String name;
	private double score;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	

}
