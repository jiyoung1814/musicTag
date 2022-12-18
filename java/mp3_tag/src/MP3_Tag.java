import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MP3_Tag {
    File fs;
    public MP3_Tag(){
        int cnt = 5000; //KPOP =0, Billboard = 1000, UK = 2000, 트로트 = 4000 , 일본 = 5000
        String text = "";
        fs = new File("D:\\JiYouong\\대학\\3학년 2학기\\과제\\데이터프로그래밍\\raw\\mp3_tag\\data\\melon_Japan\\song");
        if(fs.isDirectory()){
            File list[] = fs.listFiles();
            for(File f : list){
                try{

                    MP3File mp3 = (MP3File) AudioFileIO.read(f);
                    AbstractID3v2Tag tag2 = mp3.getID3v2Tag();

                    Tag tag = mp3.getTag();
                    String title = tag.getFirst(FieldKey.TITLE);
                    String artist = tag.getFirst(FieldKey.ARTIST);
                    String album = tag.getFirst(FieldKey.ALBUM);
                    String year = tag.getFirst(FieldKey.YEAR);
                    String genre = tag.getFirst(FieldKey.GENRE).replaceAll("; ","/");
//                    String country  = tag.getFirst(FieldKey.COUNTRY);

                    String image = tag.getFirst(FieldKey.COVER_ART);
//                    text += String.format("%04d",cnt)+": "+title+"|"+artist+"|"+album+"|"+year+"|"+genre+"\n";
                    text += String.format("'"+title+"', ");

                    System.out.println((cnt++)+": "+text);

                    //*********************img 저장시
//                    String lyrics = tag.getFirst(FieldKey.LYRICS);
//                    text += lyrics;

//                    String fileName = "D:\\JiYouong\\대학\\3학년 2학기\\과제\\데이터프로그래밍\\melon_teuroteu\\lyrics\\"+ String.format("%04d",cnt) +".txt";
//                    File file = new File(fileName);
//                    try {
//                        FileWriter fileWriter = new FileWriter(file, false);
//                        fileWriter.write(text);
//                        fileWriter.flush();
//                        fileWriter.close();
//                    } catch (IOException e) {
//                        System.out.println("fileWriter Error: "+e.getMessage());
//                    }
//                    text ="";
//                    System.out.println((cnt++)+": "+text);
//
                    //*********************img 저장시

                }catch (Exception e){
                    System.out.println("에러: "+e.getMessage());
                }
                //*******************정보 저장 시
                String fileName = "D:\\JiYouong\\대학\\3학년 2학기\\과제\\데이터프로그래밍\\raw\\mp3_tag\\data\\melon_Japan\\data\\songData_name.txt";
                File file = new File(fileName);
                try {
                    FileWriter fileWriter = new FileWriter(file, false);
                    fileWriter.write(text);
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("fileWriter Error: "+e.getMessage());
                }
                //*******************정보 저장 시


            }
        }
    }

}
