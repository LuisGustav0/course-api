package com.ead.clients;

import com.ead.model.response.courseuser.PageableUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class PageableUserClientApi {

    private final RestTemplate restTemplate;

    @Value("${ead.api.url.auth-user}")
    private static String REQUEST_URI;

    @Value("${ead.api.path.users}")
    private static String PATH_USERS;

    private String getUrlTemplate() {
        return UriComponentsBuilder.fromHttpUrl(REQUEST_URI)
                                   .path(PATH_USERS)
                                   .queryParam("courseId", "{courseId}")
                                   .queryParam("page", "{page}")
                                   .queryParam("size", "{size}")
                                   .queryParam("sort", "{sort}")
                                   .encode()
                                   .toUriString();
    }

    private Map<String, Object> getQueryParams(final UUID courseId,
                                               final Pageable pageable) {
        final int pageNumber = pageable.getPageNumber();
        final int pageSize = pageable.getPageSize();
        final String sort = pageable.getSort().toString().replace(": ", ",");

        Map<String, Object> params = new HashMap<>();
        params.put("courseId", courseId);
        params.put("page", pageNumber);
        params.put("size", pageSize);
        params.put("sort", sort);

        return params;
    }

    public PageableUserResponse call(final UUID courseId, final Pageable pageable) {
        final String url = this.getUrlTemplate();
        final Map<String, Object> params = this.getQueryParams(courseId, pageable);

        log.info("GET PageableUserClientApi.call Request URL: {}", url);

        try {
            final ParameterizedTypeReference<PageableUserResponse> responseType =
                    new ParameterizedTypeReference<>() {};

            final ResponseEntity<PageableUserResponse> pageableResult =
                    this.restTemplate.exchange(url, HttpMethod.GET, null, responseType, params);

            return pageableResult.getBody();
        } catch (HttpStatusCodeException ex) {
            log.error("GET PageableUserClientApi.call URL: {}", url);
        }

        return null;
    }
}
