package com.example.demo.model;

import java.time.Instant;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@EntityListeners(AuditingListener.class)
@Entity
public class Foo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="\"value\"")
	private String value;

	@Enumerated
	private SomeEnum enumerated;

	@OneToOne(cascade = CascadeType.ALL)
	private Flurb flurb;

	@CreatedDate
	Instant createdAt;

	@CreatedBy
	String createdBy;

	@LastModifiedDate
	Instant modifiedAt;

	@LastModifiedBy
	String modifiedBy;

	@OrderBy
	@ElementCollection
	private List<String> phoneNumbers;

	public Foo() {
	}

	public Foo(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Flurb getFlurb() {
		return flurb;
	}

	public void setFlurb(Flurb flurb) {
		this.flurb = flurb;
	}

	enum SomeEnum {
		ONE, TWO
	}

	@Override
	public String toString() {
		return String.format(
				"Foo[id=%d, value='%s']",
				id, value);
	}

}