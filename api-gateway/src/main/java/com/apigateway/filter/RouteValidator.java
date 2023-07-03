package com.apigateway.filter;

import java.util.List;

import org.springframework.stereotype.Component;
import java.util.function.Predicate;
import org.springframework.http.server.reactive.ServerHttpRequest;

@Component
public class RouteValidator {
	
	 public static final List<String> openApiEndpoints = List.of(
	            "/auth/registerUsers",
	            "/auth/token",
	            "/eureka"
	    );

	    public Predicate<ServerHttpRequest> isSecured =
	            request -> openApiEndpoints
	                    .stream()
	                    .noneMatch(uri -> request.getURI().getPath().contains(uri));


}
