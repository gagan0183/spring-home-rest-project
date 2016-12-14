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
@Table(name = "videotutorial_table")
@EntityListeners(AuditingEntityListener.class)
@Audited
@AuditTable(value = "videotutorial_audit_table")
public class Videotutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "videoTutorial_generator")
	@TableGenerator(name = "videoTutorial_generator", pkColumnName = "generator_column", pkColumnValue = "videoTutorial_value", allocationSize = 1, initialValue = 0, valueColumnName = "generator_value", table = "homeproject_generator_table")
	@Column(name = "videotutorial_id", insertable = false, nullable = false, unique = true)
	private int videotutorialId;
	@Column(name = "videotutorial_name", nullable = false)
	private String videotutorialName;
	@Column(name = "videotutorial_date", nullable = false)
	private Date videotutorialDate;
	@Column(name = "videotutorial_provider", nullable = false)
	private String videotutorialProvider;
	@Column(name = "difficulty_level", nullable = false)
	private String difficultyLevel;
	@Column(name = "videotutorial_type", nullable = false)
	private String videotutorialType;
	@Type(type = "yes_no")
	@Column(name = "certificate_print", nullable = false)
	private boolean certificatePrint;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "videoTutorial")
	private List<VideotutorialDetail> videotutorialDetail;
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

	public Videotutorial() {

	}

	public int getvideoTutorialId() {
		return videotutorialId;
	}

	public void setvideoTutorialId(int videotutorialId) {
		this.videotutorialId = videotutorialId;
	}

	public String getvideotutorialName() {
		return videotutorialName;
	}

	public void setvideoTutorialName(String videotutorialName) {
		this.videotutorialName = videotutorialName;
	}

	public Date getvideotutorialDate() {
		return videotutorialDate;
	}

	public void setvideotutorialDate(Date videotutorialDate) {
		this.videotutorialDate = videotutorialDate;
	}

	public String getvideotutorialProvider() {
		return videotutorialProvider;
	}

	public void setvideoTutorialProvider(String videotutorialProvider) {
		this.videotutorialProvider = videotutorialProvider;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getvideotutorialType() {
		return videotutorialType;
	}

	public void setvideoTutorialType(String videotutorialType) {
		this.videotutorialType = videotutorialType;
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

	public List<VideotutorialDetail> getvideotutorialDetail() {
		return videotutorialDetail;
	}

	public void setvideoTutorialDetail(List<VideotutorialDetail> videotutorialDetail) {
		this.videotutorialDetail = videotutorialDetail;
	}
}
