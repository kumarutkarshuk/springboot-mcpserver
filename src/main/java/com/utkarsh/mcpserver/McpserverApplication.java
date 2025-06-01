package com.utkarsh.mcpserver;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpserverApplication.class, args);
	}

	// register tools
	@Bean
	public List<ToolCallback> danTools(CourseService courseService) {
		return List.of(ToolCallbacks.from(courseService));
	}
}
