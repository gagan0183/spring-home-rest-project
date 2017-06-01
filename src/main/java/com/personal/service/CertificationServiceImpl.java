package com.personal.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.personal.hateoas.resource.CertificationResource;
import com.personal.model.Certification;
import com.personal.rep.CertificationRepository;

@Service
public class CertificationServiceImpl implements CertificationService {

	@Inject
	private CertificationRepository certificationRepository;

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

		return certificationResource;
	}
}
