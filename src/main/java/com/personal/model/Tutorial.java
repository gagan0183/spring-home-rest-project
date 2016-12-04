package com.personal.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tutorial_table")
@EntityListeners(AuditingEntityListener.class)
@Audited
@AuditTable(value = "tutorial_audit_table")
public class Tutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tutorial_generator")
	@TableGenerator(name = "tutorial_generator", pkColumnName = "generator_column", pkColumnValue = "tutorial_value", allocationSize = 1, initialValue = 1, valueColumnName = "generator_value", table = "homeproject_generator_table")
	@Column(name = "tutorial_id", insertable = false, nullable = false, unique = true)
	private int tutorialId;
	@Column(name = "tutorial_name", nullable = false)
	private String tutorialName;
	@Column(name = "tutorial_type", nullable = false)
	private String tutorialType;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "complete_date", nullable = false)
	private Date completeDate;
	@Basic(optional = true)
	@Column(name = "revision", nullable = true)
	private boolean revision;

	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String lastModifiedBy;
	@CreatedDate
	private Date createdOn;
	@LastModifiedDate
	private Date lastModifiedOn;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public boolean isRevision() {
		return revision;
	}

	public void setRevision(boolean revision) {
		this.revision = revision;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public int getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}

	public String getTutorialName() {
		return tutorialName;
	}

	public void setTutorialName(String tutorialName) {
		this.tutorialName = tutorialName;
	}

	public String getTutorialType() {
		return tutorialType;
	}

	public void setTutorialType(String tutorialType) {
		this.tutorialType = tutorialType;
	}
}
