package com.ead.clients.authuserapi;

import com.ead.exceptions.ServiceAuthUserUnavailableException;
import com.ead.exceptions.UnexpectedErrorException;
import com.ead.model.response.users.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class UserByIdOrElseThrowClientApi {

    private final RestTemplate restTemplate;

    @Value("${ead.api.url.auth-user}")
    private String REQUEST_URI;

    @Value("${ead.api.path.users}")
    private String PATH_USERS;

    private String getUrlTemplate(final UUID userId) {
        return UriComponentsBuilder.fromHttpUrl(REQUEST_URI)
                                   .path(PATH_USERS)
                                   .path("/" + userId)
                                   .encode()
                                   .toUriString();
    }

    public Optional<UserResponse> call(final UUID userId) {
        try {
            final String url = this.getUrlTemplate(userId);

            log.error("UserByIdOrElseThrowClientApi.call URL: {}", url);

            final ResponseEntity<UserResponse> response =
                    this.restTemplate.exchange(url, HttpMethod.GET, null, UserResponse.class);

            return Optional.of(response).map(ResponseEntity::getBody);
        } catch (HttpStatusCodeException ex) {
            log.error("UserByIdOrElseThrowClientApi.call Error", ex);

            if (!ex.getStatusCode().equals(HttpStatus.NOT_FOUND))
                throw new UnexpectedErrorException(ex);
        } catch (Exception ex) {
            log.error("UserByIdOrElseThrowClientApi.call Error", ex);

            throw new ServiceAuthUserUnavailableException(ex);
        }

        return Optional.empty();
    }
}
