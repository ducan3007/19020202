package org.example;

import java.io.*;
import java.util.Scanner;


public class DictionaryManagement {
    static Scanner input = new Scanner(System.in);
    static Dictionary dictionary = new Dictionary();

    public static void insertFromFile() {
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("src/dictionaries.txt")));
            while (in.hasNext()) {
                String temp = in.nextLine();
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == '#') {
                        Word w = new Word(temp.substring(0, i), temp.substring(i+1 , temp.length()));
                        dictionary.getListWords().add(w);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
        }
    }

    public String dictionaryLookup(String word) {
        String explain = "";
        int index = dictionary.isContain(word);
        if (index >= 0) {
            explain += dictionary.getListWords().get(index).getExplain();
            if (explain.charAt(0) == '#') {
                explain = explain.substring(1, explain.length());
            }
            explain = explain.replaceAll("#", "\n\n");
            explain = explain.replaceAll("\\|", "\n");
            word = word.toUpperCase() + "\n" + explain;
            return word;
        }
        return "";
    }

    public int RemoveWord(String word) {
        int index = dictionary.isContain(word);
        if (index >= 0) {
            dictionary.getListWords().remove(index);
            return index;
        }
        return -1;
    }

    public void addWord() {
        if (!addwordController.word.equals("") && !addwordController.explain.equals("")) {
            dictionary.getListWords().add(new Word(addwordController.word, addwordController.explain));
            addwordController.word = "";
            addwordController.explain = "";
            dictionary.getListWords().sort((o1, o2) -> o1.getWord().compareTo(o2.getWord()));
        }
    }
    public void modifyWord(){
        if(ModifyController.index >= 0 && !ModifyController.explain.equals("")){
            dictionary.getListWords().get(ModifyController.index).setExplain(ModifyController.explain);
        }
    }
    public void saveAllChange(){
            try{
                File file = new File("src/dictionaries.txt");
                file.delete();
                File newFile = new File("src/dictionaries.txt");
                FileWriter fileWriter = new FileWriter(newFile, false);
                for(int i = 0;i<dictionary.getListWords().size();i++){
                    fileWriter.write(dictionary.getListWords().get(i).getWord()+"#"+dictionary.getListWords().get(i).getExplain()+"\n");
                }
                fileWriter.close();
            }catch (IOException e){
                System.out.print("No file");
            }
    }
}



