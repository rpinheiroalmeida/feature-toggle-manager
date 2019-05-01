package com.core.toggle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class FeaturesAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Around(
            "@within(featureAssociation) || @annotation(featureAssociation)"
    )
    public Object around(ProceedingJoinPoint joinPoint, FeatureToggle featureAssociation) throws Throwable {
        if (featureAssociation.value().isActive()) {
            return joinPoint.proceed();
        } else {
            logger.info("Feature " + featureAssociation.value().name() + " is not enabled!");
            return null;
        }
    }
}
