package kr.jm.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

import kr.jm.utils.exception.JMExceptionManager;

@Component
public class JMSpringBootHealth extends AbstractHealthIndicator {

	@Autowired
	private AbstractJMSpringBootStatus jmServiceSpringBootStatus;

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		builder.withDetail("Error Count", JMExceptionManager.getErrorCount());
		jmServiceSpringBootStatus.checkStatus(builder);
	}

}
