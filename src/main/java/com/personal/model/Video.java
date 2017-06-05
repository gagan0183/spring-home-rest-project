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
@Table(name = "video_table")
@EntityListeners(AuditingEntityListener.class)
@Audited
@AuditTable(value = "video_audit_table")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "video_generator")
	@TableGenerator(name = "video_generator", pkColumnName = "generator_column", pkColumnValue = "video_value", allocationSize = 1, initialValue = 1, valueColumnName = "generator_value", table = "homeproject_generator_table")
	@Column(name = "video_id", insertable = false, nullable = false, unique = true)
	private int videoId;
	@Column(name = "video_name", nullable = false)
	private String videoName;
	@Column(name = "source", nullable = false)
	private String source;
	@Column(name = "genre", nullable = false)
	private String genre;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "date", nullable = false)
	private Date date;
	@Column(name = "link")
	private String link;
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

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + videoId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (videoId != other.videoId)
			return false;
		return true;
	}
}
