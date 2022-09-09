package com.ead.clients.authuserapi;

import com.ead.exceptions.ServiceAuthUserUnavailableException;
import com.ead.exceptions.UnexpectedErrorException;
import com.ead.model.request.usercourse.SubscriptionUserInCourseRequest;
import com.ead.model.response.usercourse.SubscriptionUserInCurseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class SubscriptionUserInCourseClientApi {

    private final RestTemplate restTemplate;

    @Value("${ead.api.url.auth-user}")
    private String REQUEST_URI;

    @Value("${ead.api.path.users}")
    private String PATH_USERS;

    @Value("${ead.api.path.courses-subscription}")
    private String PATH_COURSES_SUBSCRIPTION;

    private String getUrlTemplate(final UUID userId) {
        return UriComponentsBuilder.fromHttpUrl(REQUEST_URI)
                                   .path(PATH_USERS)
                                   .path("/" + userId)
                                   .path(PATH_COURSES_SUBSCRIPTION)
                                   .encode()
                                   .toUriString();
    }

    public SubscriptionUserInCurseResponse call(final UUID userId, final UUID courseId) {
        try {
            final String url = this.getUrlTemplate(userId);
            final var request = new SubscriptionUserInCourseRequest(courseId);

            ResponseEntity<SubscriptionUserInCurseResponse> responseEntity =
                    this.restTemplate.postForEntity(url, request, SubscriptionUserInCurseResponse.class);

            return responseEntity.getBody();
        } catch (HttpStatusCodeException ex) {
            throw new UnexpectedErrorException(ex);
        } catch (Exception ex) {
            throw new ServiceAuthUserUnavailableException(ex);
        }
    }
}
