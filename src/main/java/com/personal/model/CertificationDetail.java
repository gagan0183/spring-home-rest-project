package com.personal.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "certification_detail_table")
@EntityListeners(AuditingEntityListener.class)
@Audited
@AuditTable(value = "certification_detail_audit_table")
public class CertificationDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "certification_detail_generator")
	@TableGenerator(name = "certification_detail_generator", pkColumnName = "generator_column", pkColumnValue = "certification_detail_value", allocationSize = 1, initialValue = 0, valueColumnName = "generator_value", table = "homeproject_generator_table")
	@Column(name = "certification_detail_id", insertable = false, nullable = false, unique = true)
	private int certificationDetailId;
	@Column(name = "tutorial_name", nullable = false)
	private String tutorialName;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "certification_id", insertable = true, updatable = true, referencedColumnName = "certification_id")
	private Certification certification;

	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String lastModifiedBy;
	@CreatedDate
	private Date createdOn;
	@LastModifiedDate
	private Date lastModifiedOn;

	public CertificationDetail() {

	}

	public int getCertificationDetailId() {
		return certificationDetailId;
	}

	public void setCertificationDetailId(int certificationDetailId) {
		this.certificationDetailId = certificationDetailId;
	}

	public String getTutorialName() {
		return tutorialName;
	}

	public void setTutorialName(String tutorialName) {
		this.tutorialName = tutorialName;
	}

	public Certification getCertification() {
		return certification;
	}

	public void setCertification(Certification certification) {
		this.certification = certification;
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
}
