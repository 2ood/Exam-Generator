# Project : problemShooter.jar
project **Problemshooter** is a program that generates a test exam and its answer sheet.

Idea credits to Corpral Cho.

## 1. Prerequisites
#### 1) java jre
This program is a jar file, so it needs **java jre** installed in your local computer.

following is the anchor to latest jre8.

[java jre download (https://java.com/ko/download/ie_manual.jsp?locale=ko)](https://java.com/ko/download/ie_manual.jsp?locale=ko)

#### 2) config.txt
This text file stores the configuration attributes that can change the exported result files.

You can change the variables in your taste. The changes will be updated in the next run.

**WARNING**

* This file is crutial to this program, so you **SHOULD NEVER ERASE** it.

* YOU **SHOULD NEVER ERASE** the '#' before the annotations. 


#### 3) question bank
This directory is where you decided to put your question banks in. The path of the directory is stated in the **config.txt** file.

## 2. Needs to be filled beforehand : update question bank
As described, this directory (hereafter referred to as root bank) is where you put your information of your qustion pool.

Initially, the directory contains several sample directories and files. You should erase and replace all of them.


This program is designed for two-level-indexed problems. In the root bank, there are subdirectories representing each big indexes. Inside each big index subdirectories, there are .csv files for each small indexes. The files should be only .csv files (or .txt file split with commas[,]). You can find the method of saving Excel file into .csv file at 5.Appendix of this file.

**WARNING**

* the files should only be **.csv files**.
* the files content **SHOULD NEVER INCLUDE COMMA[,].**

In each .csv files, the information of each problem is stored. 

There are **6(or more) columns**; 
- problem number(assigned under each small index), 
- problem question passage, 
- the answer, 
- and different wrong choices(the left columns).

Unfortunately, these files should be manually put.

## 3. Let's generate exam sheet
By now, you'll have 3 things in your root directory; question bank, config file, and the generateExams.jar file.

All you need to do is, **double-click file generateExams.jar**. 
If the bank is classified properly and if the config is plausible, two(or four) files should be made. 

One is the **exam sheet**, and the other is **its answer sheet**

Optional two is log.txt file and error.txt file. This is a supportive file that shows how program is running. If the program is not working properly, you can go over these files and find the reason. If there's **unknown error** (in error file), feel free to contact the developer.  

## 4. Frequently Occured Errors
#### 1) Can't find bank
 This error is caused when the bank path is not properly put. This error might also happen when the bank path found is a blank directory. Check the config.txt file and your bank path.
 
#### 2) The program seems properly excecuted, but the exported content is somewhat cut.
 This error is caused when the content is too small that the program had overlooked them. try putting more problems for each file.
 
 This error might also happen when the content has the delimiter( for .csv files, it is COMMA[,]). The program reads the file and splits into cells by the delimiter COMMA[,]. Try not to use COMMA in your content.

## 5. Appendix
#### 1) How to convert Excel files to .csv files
(1) In your Excel spreadsheet, click **File**.

(2) Click **Save As**.

(3) Click Browse to choose where you want to save your file.

(4) Select **"CSV"** from the "Save as type" drop-down menu.

(5) Click **Save.**


