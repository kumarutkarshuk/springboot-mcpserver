package com.utkarsh.mcpserver;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> courses = new ArrayList<>();

    @Tool(name = "get_courses", description = "Get a list of courses")
    public List<Course> getCourses() {
        return courses;
    }

    @Tool(name = "get_course", description = "Get a single course by title")
    public Course getCourse(String title) {
        return courses.stream()
                .filter(course -> course.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    @PostConstruct
    public void init() {
        courses.addAll(List.of(
                new Course("course-1",
                        "https://youtu.be/31KTdfRH6nY"),
                new Course("course-2",
                        "https://youtu.be/UgX5lgv4uVM")
        ));
    }
}
