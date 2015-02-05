package persistencia;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class Sonido implements Serializable{
	  
	private static final long serialVersionUID = 1L;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	  private Long idSonido;
	  private byte[] sonido;
	  private Long frameLenght;
	  private int lenght;
	  
	  private boolean	bigEndian;
	  private int	channels;
	  private String	encoding;
	  private float	frameRate;
	  private int	frameSize;
	  private float	sampleRate;
	  private int	sampleSizeInBits;
	  
	public Sonido(){}
	
	public Sonido(AudioInputStream is, int lenght){
		 try {
			sonido = new byte[lenght];
			int readers = is.read(sonido);
			frameLenght=is.getFrameLength();
			this.lenght=lenght;
			
			
			AudioFormat af1 = is.getFormat();
			
			encoding=af1.getEncoding().toString();
			sampleRate=af1.getSampleRate();
			this.sampleSizeInBits=af1.getSampleSizeInBits();
			this.channels=af1.getChannels();
			this.frameSize=af1.getFrameSize();
			frameRate=af1.getFrameRate();
			bigEndian=af1.isBigEndian();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modificar(AudioInputStream is, int lenght){
		 try {
			sonido = new byte[lenght];
			int readers = is.read(sonido);
			frameLenght=is.getFrameLength();
			this.lenght=lenght;
			
			
			AudioFormat af1 = is.getFormat();
			
			encoding=af1.getEncoding().toString();
			sampleRate=af1.getSampleRate();
			this.sampleSizeInBits=af1.getSampleSizeInBits();
			this.channels=af1.getChannels();
			this.frameSize=af1.getFrameSize();
			frameRate=af1.getFrameRate();
			bigEndian=af1.isBigEndian();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	  
	public Long getIdSonido() {
		return idSonido;
	}
	public void setIdSonido(Long idSonido) {
		this.idSonido = idSonido;
	}
	public byte[] getSonido() {
		return sonido;
	}
	public void setSonido(byte[] sonido) {
		this.sonido = sonido;
	}
	public Long getFrameLenght() {
		return frameLenght;
	}
	public void setFrameLenght(Long frameLenght) {
		this.frameLenght = frameLenght;
	}
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	public boolean isBigEndian() {
		return bigEndian;
	}
	public void setBigEndian(boolean bigEndian) {
		this.bigEndian = bigEndian;
	}
	public int getChannels() {
		return channels;
	}
	public void setChannels(int channels) {
		this.channels = channels;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public float getFrameRate() {
		return frameRate;
	}
	public void setFrameRate(float frameRate) {
		this.frameRate = frameRate;
	}
	public int getFrameSize() {
		return frameSize;
	}
	public void setFrameSize(int frameSize) {
		this.frameSize = frameSize;
	}
	public float getSampleRate() {
		return sampleRate;
	}
	public void setSampleRate(float sampleRate) {
		this.sampleRate = sampleRate;
	}
	public int getSampleSizeInBits() {
		return sampleSizeInBits;
	}
	
	public void setSampleSizeInBits(int sampleSizeInBits) {
		this.sampleSizeInBits = sampleSizeInBits;
	} 	  
	  
	public AudioInputStream toAudioInputStream(){
		AudioFormat af = new AudioFormat(new AudioFormat.Encoding(encoding), this.getSampleRate(), this.getSampleSizeInBits(),this.getChannels(),this.getFrameSize(),this.getFrameRate(),this.isBigEndian());
	    
	    AudioInputStream os = new AudioInputStream((InputStream)(new ByteArrayInputStream(sonido)), af, frameLenght);
	    return os;
	}
	  
}
