package com.management.cradle.model;

import jakarta.persistence.*;

@Entity
@Table(name="Counters")
public class Counters {

  @Id	
  private String counterId;
  private int nextValue;
  private String initialValue;
  
  public Counters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Counters(String counterId, int nextValue, String initialValue) {
		super();
		this.counterId = counterId;
		this.nextValue = nextValue;
		this.initialValue = initialValue;
	}
	
	@Id
	public String getCounterId() {
		return counterId;
	}
	
	public void setCounterId(String counterId) {	
		this.counterId = counterId;
	}
	
	public int getNextValue() {
		return nextValue;
	}
	
	public void setNextValue(int nextValue) {
		this.nextValue = nextValue;
	}
	
	public String getInitialValue() {
		return initialValue;
	}
	
	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}
	
	@Override
	public String toString() {
		return "Counters [counterId=" + counterId + ", nextValue=" + nextValue + ", initialValue=" + initialValue
				+ "]";
	}
	
	
	public int nextValue() {
		return ++nextValue;
	}
	

  
}
