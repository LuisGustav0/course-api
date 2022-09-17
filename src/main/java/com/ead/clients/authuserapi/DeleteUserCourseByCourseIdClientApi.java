package com.ead.clients.authuserapi;

import com.ead.exceptions.ServiceAuthUserUnavailableException;
import com.ead.exceptions.UnexpectedErrorException;
import com.ead.model.response.courseuser.DeleteCourseUserResponse;
import com.ead.model.response.usercourse.DeleteUserCourseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class DeleteUserCourseByCourseIdClientApi {

    private final RestTemplate restTemplate;

    @Value("${ead.api.url.auth-user}")
    private String REQUEST_URI;

    @Value("${ead.api.path.users}")
    private String PATH_USERS;

    @Value("${ead.api.path.courses}")
    private String PATH_COURSES;

    private String getUrlTemplate(final UUID courseId) {
        return UriComponentsBuilder.fromHttpUrl(REQUEST_URI)
                                   .path(PATH_USERS)
                                   .path(PATH_COURSES)
                                   .path("/" + courseId)
                                   .encode()
                                   .toUriString();
    }

    public DeleteUserCourseResponse call(final UUID courseId) {
        try {
            final String url = this.getUrlTemplate(courseId);

            final ResponseEntity<DeleteUserCourseResponse> responseEntity =
                    this.restTemplate.exchange(url, HttpMethod.DELETE, null, DeleteUserCourseResponse.class);

            return responseEntity.getBody();
        } catch (HttpStatusCodeException ex) {
            throw new UnexpectedErrorException(ex);
        } catch (Exception ex) {
            throw new ServiceAuthUserUnavailableException(ex);
        }
    }
}
