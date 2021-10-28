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
public class SoundPlayer
{
    private String audioUrl;
    private Clip clip;
    
    public SoundPlayer(String audioUrl) {
        super();
        this.audioUrl = audioUrl;
        try {
            this.clip = AudioSystem.getClip();
            URL file = new URL(this.audioUrl);
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            clip.open(inputStream);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean isAlive(){
        return clip != null && clip.isRunning();
    }
    
    public void start() {
        if(clip != null) {
            clip.start(); 
        }
    }
    
    public void finish() {
        if(clip != null) {
            clip.stop();
        }
    }
}