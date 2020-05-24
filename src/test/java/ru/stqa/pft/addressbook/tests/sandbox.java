package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class sandbox {

    @Test
    public void sendbox() throws Exception {


        String text = "FIFA will never regret it";
        String[] words = text.split(" ");
        System.out.println(words[0]);
        int i = 1;
        for(String word : words){

            if (i == 2) {
                System.out.println(word);
            }
            i++;
        }}
}
