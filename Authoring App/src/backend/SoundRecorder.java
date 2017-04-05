package backend;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class SoundRecorder {

    // path of the wav file
    private File wavFile;
    private String waveFileName = "RecordAudio.wav";
    private static int finish = 0;   

    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
 
    // the line from which audio data is captured
    TargetDataLine line;
 
    /**
     * Defines an audio format
     */
    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }
 
    
    
    /**
     * Captures the sound and record into a WAV file
     */
    
    
    void start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
 
            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // start capturing
 
            System.out.println("Start capturing...");
            Runnable runner = new Runnable() {
            	 public void run() {
                AudioInputStream ais = new AudioInputStream(line);
     
                System.out.println("Start recording...");
     
                // start recording
                try {
                    wavFile = new File(waveFileName);
                    AudioSystem.write(ais, fileType, wavFile);               	
                }
                catch (IOException e) {
                	
                }
             	 }
        	};
            Thread captureThread = new Thread(runner);
            captureThread.start();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }
 
    /**
     * Closes the target data line to finish capturing and recording
     */
    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }
    
    public void setWaveFileName(String waveName) {
    	waveFileName = new String(waveName);
    }
 
}