/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.whowantstobeamillionaire;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 *
 * @author User
 */
public class SoundPlayer{
    private AudioInputStream inputStream;
    private URL file;
    private Clip clip;
    
    public SoundPlayer() {
        try {
            this.clip = AudioSystem.getClip();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void play(String audioUrl) {
        if(clip != null && clip.isRunning()) clip.stop();
        if(clip != null && clip.isOpen()) clip.close();
        try {
            if(inputStream != null) inputStream.close();
            file = new URL(audioUrl);
            inputStream = AudioSystem.getAudioInputStream(file);
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}