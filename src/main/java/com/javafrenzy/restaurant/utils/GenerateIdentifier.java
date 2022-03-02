package com.javafrenzy.restaurant.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateIdentifier {


    public String getIdentifier() {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            StringBuilder sb = new StringBuilder();

            Random random = new Random();


            int length = 7;

            for (int i = 0; i < length; i++) {

                int index = random.nextInt(alphabet.length());

                char randomChar = alphabet.charAt(index);

                sb.append(randomChar);
            }

            String identifier = sb.toString();
            return identifier;
        }

}

