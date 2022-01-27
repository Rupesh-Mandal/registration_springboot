package com.example.demo.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenrepsitory confirmationTokenrepsitory;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenrepsitory.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenrepsitory.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenrepsitory.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}
