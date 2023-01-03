package org.testeSchedule;

import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;
import javax.swing.*;

public class TesteScheduled {
    public static void main(String[] args) throws Exception {
        // Carrega o arquivo de áudio (não funciona com .mp3, só .wav)
        File caminhoSom = new File("src/main/assets/Hiss-crash.wav");
        URL url = new URL("https://freesoundhub.com/files/download/Sound_14688.waviss");
        Clip oClip = AudioSystem.getClip();
        AudioInputStream oStream = AudioSystem.getAudioInputStream(url);
        oClip.open(oStream);

        oClip.loop(0); // Toca uma vez
        //clip.loop(Clip.LOOP_CONTINUOUSLY); // Toca continuamente (para o caso de músicas)

        // Para a execução (senão o programa termina antes de você ouvir o som)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Clique pra fechar!");
            }
        });

    }
}
