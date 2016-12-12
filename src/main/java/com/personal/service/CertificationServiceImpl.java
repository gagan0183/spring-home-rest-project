package com.personal.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.personal.hateoas.resource.CertificationResource;
import com.personal.model.Certification;
import com.personal.model.CertificationDetail;
import com.personal.rep.CertificationDetailRepository;
import com.personal.rep.CertificationRepository;

@Service
public class CertificationServiceImpl implements CertificationService {

	@Inject
	private CertificationRepository certificationRepository;

	@Inject
	private CertificationDetailRepository certificationDetailRepository;

	@Override
	public CertificationResource addCertification(CertificationResource certificationResource) {
		Certification certification = new Certification();
		certification.setCertificationName(certificationResource.getCertificationName());
		certification.setCertificationDate(certificationResource.getCertificationDate());
		certification.setCertificationProvider(certificationResource.getCertificationProvider());
		certification.setDifficultyLevel(certificationResource.getDifficultyLevel());
		certification.setCertificationType(certificationResource.getCertificationType());
		certification.setCertificatePrint(certificationResource.isCertificatePrint());
		certification.setRevision(certificationResource.isRevision());
		certificationRepository.saveAndFlush(certification);

		for (CertificationDetail certificationDetail1 : certificationResource.getCertificationDetail()) {
			CertificationDetail certificationDetail = new CertificationDetail();
			certificationDetail.setTutorialName(certificationDetail1.getTutorialName());
			certificationDetail.setCertification(certification);
			certificationDetailRepository.save(certificationDetail);
		}

		return certificationResource;
	}
}
