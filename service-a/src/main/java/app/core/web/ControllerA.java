package app.core.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController

public class ControllerA {
	
	@Autowired
	private RestTemplate rt;
	
	@Autowired
	private DiscoveryClient discovery;
	
	@Autowired
	private LoadBalancerClient lb;
	
	@HystrixCommand(fallbackMethod = "handleFallback")
	@GetMapping("/service/a")
	public String handleA() {
		//String baseUri = getUriLB("service-b").toString();
		//String url = baseUri + "/service/b";
		String url = "http://service-b/service/b";
		String response = rt.getForObject(url, String.class);
		return response;
		
	}
	
	public String handleFallback(Throwable t) {
		return "Service A fallback: "+t;
		
	}
	
	private URI getUriLB(String serviceId) {
		 return lb.choose(serviceId).getUri();
	}

	
	private URI getUri(String serviceId) {
		List<ServiceInstance> instances = discovery.getInstances(serviceId);
		return instances.get(0).getUri();
	}
}
