package com.firstProject;

import org.junit.Test;

import java.nio.file.Files;

import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day08_FileExistTest {

    @Test
    public void isExist(){
//        Class: FileExistTest
//        Method: isExist
//        Pick a file on your desktop
//        And verify if that file exists on your computer or not

        //1. Step: Type the path of the file
        //String pathOfFile = "C:/Users/TechProEd/Desktop/image.jpeg"; ==> C:/Users/TechProEd is hard codding
        String pathOfFile = System.getProperty("user.home")+"/Desktop/image.jpeg";//Dynamic Path

        //2. Step: Use Files.exists() method to check if the file exists
        boolean isImageExist = Files.exists(Paths.get(pathOfFile));
        System.out.println("isImageExist = " + isImageExist);

        //3. Step: Do assertion
        assertTrue(isImageExist);

    }
}