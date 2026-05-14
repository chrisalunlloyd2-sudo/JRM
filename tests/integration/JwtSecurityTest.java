package com.jrm.chronos.security;

import com.jrm.chronos.security.jwt.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
    "chronos.jwtSecret=testSecretKeyForJrmChronosProjectWhichNeedsToBeLongEnough",
    "chronos.jwtExpirationMs=3600000"
})
public class JwtSecurityTest {

    @Autowired
    private JwtUtils jwtUtils;

    @Test
    void generateAndValidateToken_ShouldPass() {
        String username = "testUser";
        String token = jwtUtils.generateJwtToken(username);
        
        assertNotNull(token);
        assertTrue(jwtUtils.validateJwtToken(token));
        assertEquals(username, jwtUtils.getUserNameFromJwtToken(token));
    }
}
