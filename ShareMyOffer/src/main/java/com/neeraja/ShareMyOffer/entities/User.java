package com.neeraja.ShareMyOffer.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "is required")
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "is required")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message = "is required")
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@NotNull(message = "is required")
	@Column(unique = true, name = "mobile_number")
	private String mobileNumber;
	
	@NotNull(message = "is required")
	@Column(unique = true, name = "email")
	private String email;
	
	@NotNull(message = "is required")
	@Column(name = "rating")
	private double rating;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<UserOffer> userOffers;

	public User(int id,String firstName, String lastName, String dateOfBirth, String mobileNumber, String email, double rating) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.rating = rating;
	}
	
//	@NotNull(message = "is required")
//	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//	@JoinTable(name = "user_offer",
//	joinColumns = @JoinColumn(name = "user_id"),
//	inverseJoinColumns = @JoinColumn(name = "offer_id"))
//	private List<Offer> offers;
	
}
