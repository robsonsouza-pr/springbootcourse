package com.udemy.springbootcourse.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.udemy.springbootcourse.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="request_stage")
public class RequestStage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="text")
	private String description;
	
	@Column(name="realization_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date realizationDate;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User owner;
	
	@ManyToOne
	@JoinColumn(name="request_id")
	private Request request;
	
	@Enumerated(EnumType.STRING)
	private RequestState state;

}
