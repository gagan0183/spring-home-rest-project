package com.personal.hateoas.resource;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import com.personal.model.VideotutorialDetail;

@Component
public class VideotutorialResource extends ResourceSupport {
	private String videotutorialName;
	private Date videotutorialDate;
	private String videotutorialProvider;
	private String difficultyLevel;
	private String videotutorialType;
	private boolean certificatePrint;
	private List<VideotutorialDetail> videotutorialDetail;
	private boolean revision;

	public VideotutorialResource() {

	}

	public VideotutorialResource(String videotutorialName, Date videotutorialDate, String videotutorialProvider,
			String difficultyLevel, String videotutorialType, boolean certificatePrint,
			List<VideotutorialDetail> videotutorialDetail, boolean revision) {
		super();
		this.videotutorialName = videotutorialName;
		this.videotutorialDate = videotutorialDate;
		this.videotutorialProvider = videotutorialProvider;
		this.difficultyLevel = difficultyLevel;
		this.videotutorialType = videotutorialType;
		this.certificatePrint = certificatePrint;
		this.videotutorialDetail = videotutorialDetail;
		this.revision = revision;
	}

	public String getvideotutorialName() {
		return videotutorialName;
	}

	public Date getvideotutorialDate() {
		return videotutorialDate;
	}

	public String getvideotutorialProvider() {
		return videotutorialProvider;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public String getvideotutorialType() {
		return videotutorialType;
	}

	public boolean isCertificatePrint() {
		return certificatePrint;
	}

	public List<VideotutorialDetail> getvideotutorialDetail() {
		return videotutorialDetail;
	}

	public boolean isRevision() {
		return revision;
	}
}
