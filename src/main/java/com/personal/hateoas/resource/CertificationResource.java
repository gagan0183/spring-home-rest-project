package com.personal.hateoas.resource;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import com.personal.model.CertificationDetail;

@Component
public class CertificationResource extends ResourceSupport {
	private String certificationName;
	private Date certificationDate;
	private String certificationProvider;
	private String difficultyLevel;
	private String certificationType;
	private boolean certificatePrint;
	private List<CertificationDetail> certificationDetail;
	private boolean revision;

	public CertificationResource() {

	}

	public CertificationResource(String certificationName, Date certificationDate, String certificationProvider,
			String difficultyLevel, String certificationType, boolean certificatePrint,
			List<CertificationDetail> certificationDetail, boolean revision) {
		super();
		this.certificationName = certificationName;
		this.certificationDate = certificationDate;
		this.certificationProvider = certificationProvider;
		this.difficultyLevel = difficultyLevel;
		this.certificationType = certificationType;
		this.certificatePrint = certificatePrint;
		this.certificationDetail = certificationDetail;
		this.revision = revision;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public Date getCertificationDate() {
		return certificationDate;
	}

	public String getCertificationProvider() {
		return certificationProvider;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public String getCertificationType() {
		return certificationType;
	}

	public boolean isCertificatePrint() {
		return certificatePrint;
	}

	public List<CertificationDetail> getCertificationDetail() {
		return certificationDetail;
	}

	public boolean isRevision() {
		return revision;
	}
}
