package com.campusdual.amazing_store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertNotEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;
import com.campusdual.amazing_store.auth.JwtUtils;

@SpringBootTest
class AmazingStoreTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private JwtUtils jwtUtils;

    @Test
    void testPropertiesLoading() {
        assertNotNull("No debe ser nulo",jwtUtils.getJwtSecret());
        assertNotEquals("", jwtUtils.getJwtExpirationMs(), "Debe tener valor");
    }
}

