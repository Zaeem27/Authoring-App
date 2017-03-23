package backend;
import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
 
public class SoundRecorder {
    // record duration, in milliseconds
  // static final long RECORD_TIME = 60000;  // 1 minute
 
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
 
            AudioInputStream ais = new AudioInputStream(line);
 
            System.out.println("Start recording...");
 
            // start recording
            wavFile = new File(waveFileName);
            AudioSystem.write(ais, fileType, wavFile);
 
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
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
    
    /**
     * Entry to run the program
     */
 
    public void setWaveFileName(String waveName) {
    	waveFileName = new String(waveName);
    }
 public void signalFinishRecording(int signal) {
	 if (signal ==0 )
		 finish = 0;
	 else
		 finish = 1;
	 
 }
    public static void main(String[] args) {
    	 
        final SoundRecorder recorder = new SoundRecorder();
        // creates a new thread that waits for a specified
        // of time before stopping
        
        
  /*      
        Thread stopper = new Thread(new Runnable() {
            public void run() {
        		System.out.println("Press any key to end recording..");
            	Scanner scanner = new Scanner(System.in);
            	if(scanner.hasNext()) {
            	   scanner.next();
                   recorder.finish();            	   
            	}
            	scanner.close();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
            }
        });
 */

        System.out.println("Press any key to start recording");
        try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        stopper.start();
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
          @Override
          public void run() {
      		System.out.println("Press any key to end recording.." + finish);
      		
      		if (finish == 1) {
      			recorder.finish();
      		}
      		
          	Scanner scanner = new Scanner(System.in);
          	if(scanner.hasNext()) {
          	   //scanner.next();
                 recorder.finish();            	   
          	}
          	scanner.close();
          	
          	
          }
        }, 0, 100, TimeUnit.MILLISECONDS);
               
       // start recording
        recorder.start();
        exec.shutdownNow();
    }
}
  