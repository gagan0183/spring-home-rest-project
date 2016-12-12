package com.personal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "certification_table")
@EntityListeners(AuditingEntityListener.class)
@Audited
@AuditTable(value = "certification_audit_table")
public class Certification {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "certification_generator")
	@TableGenerator(name = "certification_generator", pkColumnName = "generator_column", pkColumnValue = "certification_value", allocationSize = 1, initialValue = 0, valueColumnName = "generator_value", table = "homeproject_generator_table")
	@Column(name = "certification_id", insertable = false, nullable = false, unique = true)
	private int certificationId;
	@Column(name = "certification_name", nullable = false)
	private String certificationName;
	@Column(name = "certification_date", nullable = false)
	private Date certificationDate;
	@Column(name = "certification_provider", nullable = false)
	private String certificationProvider;
	@Column(name = "difficulty_level", nullable = false)
	private String difficultyLevel;
	@Column(name = "certification_type", nullable = false)
	private String certificationType;
	@Type(type = "yes_no")
	@Column(name = "certificate_print", nullable = false)
	private boolean certificatePrint;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "certification")
	private List<CertificationDetail> certificationDetail;
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

	public Certification() {

	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public Date getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(Date certificationDate) {
		this.certificationDate = certificationDate;
	}

	public String getCertificationProvider() {
		return certificationProvider;
	}

	public void setCertificationProvider(String certificationProvider) {
		this.certificationProvider = certificationProvider;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getCertificationType() {
		return certificationType;
	}

	public void setCertificationType(String certificationType) {
		this.certificationType = certificationType;
	}

	public boolean isCertificatePrint() {
		return certificatePrint;
	}

	public void setCertificatePrint(boolean certificatePrint) {
		this.certificatePrint = certificatePrint;
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

	public List<CertificationDetail> getCertificationDetail() {
		return certificationDetail;
	}

	public void setCertificationDetail(List<CertificationDetail> certificationDetail) {
		this.certificationDetail = certificationDetail;
	}
}
