package com.oreilly.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * @author Donald F. Coffin, REMI Networks
 **/

@Entity
@Table(name = "officers")
public class Officer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Rank rank;
	private String firstName;
	private String lastName;

	public Officer() {
	}

	public Officer(Integer id,
				   Rank rank,
				   String firstName,
				   String lastName) {
		this.id = id;
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public Rank getRank() {
		return rank;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (Officer) obj;
		return Objects.equals(this.id, that.id) &&
				Objects.equals(this.rank, that.rank) &&
				Objects.equals(this.firstName, that.firstName) &&
				Objects.equals(this.lastName, that.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rank, firstName, lastName);
	}

	@Override
	public String toString() {
		return "Officer[" +
				"id=" + id + ", " +
				"rank=" + rank + ", " +
				"firstName=" + firstName + ", " +
				"lastName=" + lastName + ']';
	}
}
