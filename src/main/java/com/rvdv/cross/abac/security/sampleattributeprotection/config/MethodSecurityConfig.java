package com.rvdv.cross.abac.security.sampleattributeprotection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import com.rvdv.cross.abac.security.spring.AbacPermissionEvaluator;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
	@Autowired
	AbacPermissionEvaluator permissionEvaluator;
	
	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		DefaultMethodSecurityExpressionHandler result = new DefaultMethodSecurityExpressionHandler();
		result.setPermissionEvaluator(permissionEvaluator);
		return result;
	}
	
}