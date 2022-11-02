package com.redhash.conference;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

import java.net.URI;

@Builder
public class ConferenceException extends RuntimeException {

    private final String type;
    private final String title;
    private final String detail;
    private final HttpStatusCode statusCode;

    public ConferenceException(String type, String title, String detail, HttpStatusCode statusCode) {
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.statusCode = statusCode;
    }

    public ProblemDetail toProblem() {
        var problem = ProblemDetail.forStatus(statusCode);
        problem.setType(URI.create(type));
        problem.setTitle(title);
        problem.setDetail(detail);
        return problem;
    }

    @Override
    public String getMessage() {
        return toString();
    }

    @Override
    public String toString() {
        return "ConferenceException{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
