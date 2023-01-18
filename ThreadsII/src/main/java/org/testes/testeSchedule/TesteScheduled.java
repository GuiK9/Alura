package org.testes.testeSchedule;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class TesteScheduled {
    public static void main(String[] args) throws Exception {
        // Carrega o arquivo de áudio (não funciona com .mp3, só .wav)
        File caminhoSom = new File("src/main/assets/Hiss-crash2.wav");
        Clip oClip = AudioSystem.getClip();
        AudioInputStream oStream = AudioSystem.getAudioInputStream(caminhoSom);

        Runnable tocaMusica = new TocaMusica(oClip, oStream);
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(tocaMusica, 0, 1, TimeUnit.SECONDS);

        //clip.loop(Clip.LOOP_CONTINUOUSLY); // Toca continuamente (para o caso de músicas)

        // Para a execução (senão o programa termina antes de você ouvir o som)

    }

    private static class TocaMusica implements Runnable {
        private Clip oClip;
        private AudioInputStream oStream;
        public TocaMusica(Clip oClip, AudioInputStream oStream) {
            this.oClip = oClip;
            this.oStream = oStream;
        }

        @Override
        public void run() {
            try {
                oClip.open(oStream);
                oClip.start();
                System.out.println("deu 20 segundos");
                System.out.println(oClip.isOpen());
                Thread.sleep(50000);
                oClip.close();
//                if(!oClip.isOpen()){
//                    System.out.println("flag");
//                    oClip.close();
//                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
