package LearnJava;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class ClientCredentialsGenerator {

    /**
     * Generates a unique client ID (using UUID) and a cryptographically secure client secret.
     * The secret is generated using SecureRandom and encoded with Base64 URL-safe encoding.
     */
    public static void main(String[] args) {
        // 1. Generate Client ID (UUID)
        // UUIDs are 32 hexadecimal characters long, often presented with hyphens.
        String clientId = generateClientId();

        // 2. Generate Client Secret
        // We use 36 bytes, which results in a 48-character URL-safe Base64 encoded secret.
        String clientSecret = generateClientSecret(36); 

        System.out.println("--- Generated OAuth/OIDC Credentials ---");
        System.out.println("Client ID: " + clientId);
        System.out.println("Client Secret: " + clientSecret);
        System.out.println("----------------------------------------");
    }

    /**
     * Generates a new unique identifier for the Client ID.
     * @return A UUID string without hyphens.
     */
    public static String generateClientId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * Generates a cryptographically strong random byte array and encodes it using Base64 URL-safe encoding.
     * @param byteLength The desired length of the random byte array.
     * @return The Base64 encoded secret string.
     */
    public static String generateClientSecret(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[byteLength];
        secureRandom.nextBytes(bytes);

        // Use Base64 URL-safe encoding to ensure the secret can be safely used in URLs and JSON.
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}