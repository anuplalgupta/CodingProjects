//package practice;
//
//import java.io.File;
//import java.io.IOException;
//
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.SdkClientException;
//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import org.apache.commons.logging.LogFactory;
//import  com.fasterxml.jackson.databind.JsonMappingException;
//import  com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.annotation.JsonView;
//import org.apache.http.protocol.HttpRequestExecutor;
//import org.apache.http.client.HttpClient;
//import org.joda.time.DateTimeZone;
//
//public class TryS3Upload {
//
//    public static void main(String[] args) throws IOException {
//        String clientRegion = "us-west-2";
//        String bucketName = "test-bucket-20e20f2c";
//        String fileObjKeyName = "testUpload/testvideo";
//        String fileName = "C:\\Users\\anupl\\Desktop\\testvideo.mp4.txt";
//
//        try {
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                    .withRegion(clientRegion)
//                    .withCredentials(new ProfileCredentialsProvider())
//                    .build();
//
//            // Upload a text string as a new object.
//            //s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");
//
//            // Upload a file as a new object with ContentType and title specified.
//            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
//            ObjectMetadata metadata = new ObjectMetadata();
//            metadata.setContentType("plain/text");
//            metadata.addUserMetadata("x-amz-meta-title", "someTitle");
//            request.setMetadata(metadata);
//            s3Client.putObject(request);
//        }
//        catch(AmazonServiceException e) {
//            // The call was transmitted successfully, but Amazon S3 couldn't process
//            // it, so it returned an error response.
//            e.printStackTrace();
//        }
//        catch(SdkClientException e) {
//            // Amazon S3 couldn't be contacted for a response, or the client
//            // couldn't parse the response from Amazon S3.
//            e.printStackTrace();
//        }
//    }
//}