package edu.gmu.swe645.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String telephoneNumber;
    private String email;
    private LocalDate surveyDate;

    private String likedMost;
    private String interestSource;
    private String recommendationLikelihood;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(LocalDate surveyDate) {
		this.surveyDate = surveyDate;
	}
	public String getLikedMost() {
		return likedMost;
	}
	public void setLikedMost(String likedMost) {
		this.likedMost = likedMost;
	}
	public String getInterestSource() {
		return interestSource;
	}
	public void setInterestSource(String interestSource) {
		this.interestSource = interestSource;
	}
	public String getRecommendationLikelihood() {
		return recommendationLikelihood;
	}
	public void setRecommendationLikelihood(String recommendationLikelihood) {
		this.recommendationLikelihood = recommendationLikelihood;
	}

    // Getters and Setters
}
