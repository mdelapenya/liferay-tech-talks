package com.github.migue.metrics.internal.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.osgi.service.component.ComponentContext;

import com.github.migue.metrics.api.model.Metric;
import com.github.migue.metrics.spi.MetricsProvider;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;

/**
 * Component responsible for the handling and registering of all metrics
 * providers.
 * 
 * Asking for all the metrics will collect all the providers and return all the
 * collected metrics.
 * 
 */
public class MetricsManager {

	void activate(ComponentContext componentContext) {
		System.out.println("Starting the metrics manager. Waiting for metrics providers . . .");

		_executorService.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					// run forever and collect metrics every 1 seconds

					try {
						List<User> noContacts = _userLocalService.getNoContacts();
						System.out.println("Reference: " + _userLocalService);
						
					} catch (SystemException e) {
						e.printStackTrace();
					}

					List<Metric> metrics = collect();

					for (Metric metric : metrics) {
						System.out.println(metric);
					}

					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
	}

	public void addMetricsProvider(MetricsProvider metricsProvider) {
		_extensions.put(metricsProvider.getId(), metricsProvider);
	}

	public void removeMetricsProvider(MetricsProvider metricsProvider) {
		_extensions.remove(metricsProvider.getId());
	}

	public void deactivate(ComponentContext componentContext) throws Exception {
		_executorService.shutdown();
	}

	public void bindUserService(UserLocalService userService) {
		_userLocalService = userService;
	}

	public void unbindUserService(UserLocalService userService) {
		_userLocalService = null;
	}

	protected List<Metric> collect() {
		List<Metric> metrics = new ArrayList<Metric>();

		for (Long extensionId : _extensions.keySet()) {
			MetricsProvider metricsProvider = _extensions.get(extensionId);

			metrics.add(metricsProvider.collect());
		}

		return metrics;
	}

	private UserLocalService _userLocalService;

	private Map<Long, MetricsProvider> _extensions = new HashMap<Long, MetricsProvider>();

	private ExecutorService _executorService = Executors.newCachedThreadPool();

}