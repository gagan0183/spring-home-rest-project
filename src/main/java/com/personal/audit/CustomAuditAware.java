package com.personal.audit;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditAware implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return "Gagan";
	}

}
