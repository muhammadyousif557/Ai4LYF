package co.Ai4Lyf.getotp;

import java.io.IOException;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class OTPVerification {
    String apiKey = "DKbFkJdnpVfAAKoRE9xbbXSlNxfdYS4T";
    String serverID = "jmk9yjpo";
    String serverDomain = "jmk9yjpo.mailosaur.net";

    // Generate a random email once and reuse it
    private String generatedEmail;

    public String CreateRandomEmail() {
        // Only generate the email if it hasn't been generated yet
        if (generatedEmail == null) {
            // Limit the length of the timestamp part of the email to avoid exceeding the character limit
            String timestamp = String.valueOf(System.currentTimeMillis()).substring(0, 10);  // First 10 digits of the timestamp
            generatedEmail = "user" + timestamp + "@" + serverDomain; // Ensure this part is within 50 characters
        }
        return generatedEmail;
    }

    // Method to reset the generated email before each test
    public void resetGeneratedEmail() {
        generatedEmail = null;  // Reset the generated email
    }

    // Method to get OTP from email, and also return the generated email
    public String GetOTP() throws MailosaurException, IOException, InterruptedException {
        String setRandomemailId = CreateRandomEmail();  // Generate a random email for Mailosaur
        System.out.println("Generated Email: " + setRandomemailId);
        // Your existing code to fetch OTP from Mailosaur
        MailosaurClient mailosaur = new MailosaurClient(apiKey);
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverID);
        params.withReceivedAfter(System.currentTimeMillis() - 900000);  // Search for emails received in the last 15 minutes
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(setRandomemailId);  // Use the random email to search for OTP
        // Polling mechanism to wait for the email
        Message message = null;
        int maxRetries = 3;
        int retries = 0;
        while (retries < maxRetries) {
            try {
                // Try to get the latest message
                message = mailosaur.messages().get(params, criteria);
                if (message != null) {
                    break;
                }
            } catch (MailosaurException e) {
                System.err.println("Error retrieving email: " + e.getMessage());
            }

            retries++;
            if (retries < maxRetries) {
                System.out.println("Email not found. Retrying... (" + retries + "/" + maxRetries + ")");
                Thread.sleep(30000);  // Wait for 30 seconds before retrying
            }
        }

        // If no email was found after maxRetries, throw an exception
        if (message == null) {
            throw new RuntimeException("No matching messages found after " + maxRetries + " retries.");
        }
        // Log the email body (both plain text and HTML)
        String emailBody = message.text().body();  // Get the plain text content as String
        String htmlBody = message.html().body();  // Get the HTML content as String
        //System.out.println("Plain Text Email Body: " + emailBody);
        //System.out.println("HTML Email Body: " + htmlBody);
        // Parse the HTML content using Jsoup to extract OTP
        Document doc = Jsoup.parse(htmlBody);  // Parse the HTML body
        Element otpElement = doc.select("h2").first();  // Select the first <h2> tag (which contains the OTP)    
        if (otpElement != null) {
            String otp = otpElement.text().trim();  // Extract OTP from the <h2> tag and remove any leading/trailing whitespace
            System.out.println("OTP Extracted: " + otp);
            return otp;  // Return the OTP
        } else {
            throw new RuntimeException("OTP not found in the email body.");
        }
    }

    // This method returns the generated email
    public String GetGeneratedEmail() {
        return CreateRandomEmail();
    }
}
