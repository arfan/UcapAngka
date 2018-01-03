/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.kmbmicro.ucapangka;

import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

/**
 *
 * @author arfan
 */
public class UcapAngka {

    HashMap<String, String> map;
    
    public UcapAngka() {
        map = new HashMap<>();
        
        map.put("satu","satu-end.wav");
        map.put("dua","dua-end.wav");
        map.put("tiga","tiga-end.wav");
        map.put("empat","empat-end.wav");
        map.put("lima","lima-end.wav");
        map.put("enam","enam-end.wav");
        map.put("tujuh","tujuh-end.wav");
        map.put("delapan","delapan-end.wav");
        map.put("sembilan","sembilan-end.wav");
        map.put("sepuluh","sepuluh-end.wav");
        
        map.put("sebelas","sebelas-end.wav");
        map.put("dua-belas","duabelas-end.wav");
        map.put("tiga-belas","tigabelas-end.wav");
        map.put("empat-belas","empatbelas-end.wav");
        map.put("lima-belas","limabelas-end.wav");
        map.put("enam-belas","enambelas-end.wav");
        map.put("tujuh-belas","tujuhbelas-end.wav");
        map.put("delapan-belas","delapanbelas-end.wav");
        map.put("sembilan-belas","sembilanbelas-end.wav");
        // TODO code application logic here
        
        map.put("dua-puluh","duapuluh.wav");
        map.put("tiga-puluh","tigapuluh.wav");
        map.put("empat-puluh","empatpuluh.wav");
        map.put("lima-puluh","limapuluh.wav");
        map.put("enam-puluh","enampuluh.wav");
        map.put("tujuh-puluh","tujuhpuluh.wav");
        map.put("delapan-puluh","delapanpuluh.wav");
        map.put("sembilan-puluh","sembilanpuluh.wav");
        
        map.put("seratus","seratus.wav");
        map.put("dua-ratus","duaratus.wav");
        map.put("tiga-ratus","tigaratus.wav");
        map.put("empat-ratus","empatratus.wav");
        map.put("lima-ratus","limaratus.wav");
        map.put("enam-ratus","enamratus.wav");
        map.put("tujuh-ratus","tujuhratus.wav");
        map.put("delapan-ratus","delapanratus.wav");
        map.put("sembilan-ratus","sembilanratus.wav");
        
        map.put("seribu","seribu.wav");
        map.put("ribu","ribu.wav");
        map.put("juta","juta.wav");
        map.put("milyar","milyar.wav");
        map.put("triliun","triliun.wav");
        map.put("kuadriliun","kuadriliun.wav");
        map.put("kuantiliun","kuantiliun.wav");
        map.put("sekstiliun","sekstiliun.wav");
        map.put("septiliun","septiliun.wav");
        map.put("oktiliun","oktiliun.wav");
        map.put("noniliun","noniliun.wav");
        map.put("desiliun","desiliun.wav");
    }
    
    public void play(ArrayList<String> files) {
        byte[] buffer = new byte[4096];
        for (String filePath : files) {
            File file = new File(filePath);
            try {
                AudioInputStream is = AudioSystem.getAudioInputStream(file);
                AudioFormat format = is.getFormat();
                SourceDataLine line = AudioSystem.getSourceDataLine(format);
                line.open(format);
                line.start();
                while (is.available() > 0) {
                    int len = is.read(buffer);
                    line.write(buffer, 0, len);
                }
                line.drain();
                line.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void ucap(BigInteger num) {
        

        ArrayList<String> list = new ArrayList<>();
        
        String terbilang = Terbilang.sebut(num);
        
        StringTokenizer token = new StringTokenizer(terbilang);
        while(token.hasMoreElements()) {
            String curr = token.nextToken();
            
            //System.out.println(curr);
            
            String m = map.getOrDefault(curr, null);
            if(m!=null) {
                list.add(m);
            } else {
                System.out.println("ngaco abis ["+curr+"]");
            } 
                
        }
        
        play(list);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UcapAngka ucap = new UcapAngka();
//        ucap.ucap(new BigInteger("1000"));
//        ucap.ucap(new BigInteger("1000000"));
//        ucap.ucap(new BigInteger("9000000000"));
//        ucap.ucap(new BigInteger("100000000000"));
//        ucap.ucap(new BigInteger("1.000".replace(".", "")));
//        ucap.ucap(new BigInteger("1.000.000".replace(".", "")));
//        ucap.ucap(new BigInteger("1.000.000.000".replace(".", "")));
//        ucap.ucap(new BigInteger("1.000.000.000.000".replace(".", "")));
//        ucap.ucap(new BigInteger("1.000.000.000.000.000".replace(".", "")));
//        ucap.ucap(new BigInteger("1.000.000.000.000.000.000".replace(".", "")));
//        ucap.ucap(new BigInteger("1.000.000.000.000.000.000.000".replace(".", "")));
//        ucap.ucap(new BigInteger("1.000.000.000.000.000.000.000.000".replace(".", "")));
//        ucap.ucap(new BigInteger("1.000.000.000.000.000.000.000.000.000".replace(".", "")));
//        ucap.ucap(new BigInteger("1.000.000.000.000.000.000.000.000.000.000".replace(".", "")));
        //ucap.ucap(new BigInteger("1.234.567.891.234.567.891.234.567.981.234.567".replace(".", "")));
        //ucap.ucap(new BigInteger("980.234.567".replace(".", "")));
        ucap.ucap(new BigInteger("11000000"));
    }
}
