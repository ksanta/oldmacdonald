package lol.karl.oldmacdonald.polly;

import com.amazonaws.regions.Region;
import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.AmazonPollyClientBuilder;
import com.amazonaws.services.polly.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class PollyClient {

    private final AmazonPolly polly;
    private final Voice voice;

    public PollyClient(Region region) {
        // Create an Amazon Polly client in a specific region
        polly = new AmazonPollyClient();
        polly.setRegion(region);

        // Create describe voices request.
        DescribeVoicesRequest describeVoicesRequest = new DescribeVoicesRequest();
        describeVoicesRequest.setLanguageCode(LanguageCode.EnAU);

        // Synchronously ask Amazon Polly to describe available TTS voices.
        DescribeVoicesResult describeVoicesResult = polly.describeVoices(describeVoicesRequest);

        List<Voice> voices = describeVoicesResult.getVoices();
        voice = voices.get(0);
    }

    public void synthesize(String text, String filename) throws IOException {
        OutputFormat format = OutputFormat.Mp3;
        SynthesizeSpeechRequest synthReq = new SynthesizeSpeechRequest().withText(text).withVoiceId(voice.getId())
                .withOutputFormat(format);
        SynthesizeSpeechResult synthRes = polly.synthesizeSpeech(synthReq);

        InputStream inputStream = synthRes.getAudioStream();

        File targetFile = new File(filename);

        FileUtils.copyInputStreamToFile(inputStream, targetFile);
    }
}
