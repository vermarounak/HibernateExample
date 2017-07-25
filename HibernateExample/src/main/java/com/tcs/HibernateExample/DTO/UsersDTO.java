package com.tcs.HibernateExample.DTO;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.tcs.HibernateExample.Utilities.DateAttributeConverter;

@Entity
@Table(name = "test_users_t")
public class UsersDTO {

	public UsersDTO() {

	}

	private int userId;
	private String userName;
	private String createdBy;
	private LocalDate updatedDate;

	@Id
	@GenericGenerator(name = "generated_user_id", strategy = "sequence", parameters = { @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_id_seq")

	})
	@GeneratedValue(generator = "generated_user_id")
	@Column(name = "user_id", nullable = false, unique = true)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", nullable = false, insertable = true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "created_by", nullable = false, insertable = true)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "updated_date", nullable = true, updatable = true)
	@Convert(converter = DateAttributeConverter.class)
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UsersDTO(int userId, String userName, String createdBy,
			LocalDate updatedDate) {
		this.userId = userId;
		this.userName = userName;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
	}

}
