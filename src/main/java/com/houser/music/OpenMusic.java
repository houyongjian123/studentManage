package com.houser.music;

import lombok.Data;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class OpenMusic {
    private String systemDir="src/main/resources/music/";

    private String musicPath[]=
            {"two.wav",
                    "one.wav",
                    "three.wav",
                    "哇偶.wav",
                    "four.wav"
            };
   private int randomMusic;
  private Clip clip = null;
    private AudioInputStream audioInputStream;
    long microsecondPosition;
  public OpenMusic() throws UnsupportedAudioFileException, IOException {
      randomMusic= new Random().nextInt(musicPath.length);
      audioInputStream = AudioSystem.getAudioInputStream(new File(systemDir+musicPath[randomMusic]));
      try {
          // 获取音频输入流
          // 打开音频输入流
          clip = AudioSystem.getClip();
          clip.open(audioInputStream);
          clip.loop(Clip.LOOP_CONTINUOUSLY);
          // 开始播放
          clip.start();

      } catch (Exception e) {
          e.printStackTrace();
      }
  }
    public void switchMusic() throws Exception {
      while (true){
          int randomNum=new Random().nextInt(musicPath.length);
          if(randomNum==randomMusic) continue;
          randomMusic=randomNum;
          break;
      }
      audioInputStream.close();
      clip.close();
      audioInputStream=AudioSystem.getAudioInputStream(new File(systemDir+musicPath[randomMusic]));
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        // 开始播放
        clip.start();
    }
    public void PauseMusic(){
         microsecondPosition = clip.getMicrosecondPosition();
        clip.stop();
    }
    public void openMusic() throws LineUnavailableException {
     clip.setMicrosecondPosition(microsecondPosition);
     clip.start();
    }
}
