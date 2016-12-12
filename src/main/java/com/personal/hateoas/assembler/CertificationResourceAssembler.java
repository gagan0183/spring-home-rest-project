package com.personal.hateoas.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.personal.controller.CertificationController;
import com.personal.hateoas.resource.CertificationResource;
import com.personal.model.Certification;

@Component
public class CertificationResourceAssembler extends ResourceAssemblerSupport<Certification, CertificationResource> {

	public CertificationResourceAssembler() {
		super(CertificationController.class, CertificationResource.class);
	}

	@Override
	public CertificationResource toResource(Certification certification) {
		CertificationResource certificationResource = createResourceWithId(
				"/certification/" + certification.getCertificationId(), certification);
		return certificationResource;
	}

	@Override
	protected CertificationResource instantiateResource(Certification certification) {
		return new CertificationResource(certification.getCertificationName(), certification.getCertificationDate(),
				certification.getCertificationProvider(), certification.getDifficultyLevel(),
				certification.getCertificationType(), certification.isCertificatePrint(),
				certification.getCertificationDetail(), certification.isRevision());
	}
}
