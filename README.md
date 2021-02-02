# Project : problemShooter.jar
project **Problemshooter** is a program that generates a test exam and its answer sheet.

Idea credits to Corpral Cho.

## 1. Prerequisites
#### 1) java jre
This program is a jar file, so it needs java jre installed in your local computer.

#### 2) config.txt
This text file stores the configuration attributes that can change the exported result files.

You can change the variables in your taste. The changes will be updated in the next run.

**WARNING**

* This file is crutial to this program, so you **SHOULD NEVER ERASE** it.

* YOU **SHOULD NEVER ERASE** the '#' before the comments. 


#### 3) question bank
This directory is where you decided to put your question banks in. 

This is how you can change your question banks whenever needed.

The path of the directory is stated in the **config.txt** file.


## 2. Needs to be filled beforehand : update question bank
As described, this directory (hereafter referred to as root bank) is where you put your information of your qustion pool.

This program is designed for two-level-indexed problems.

In the root bank, there are subdirectories representing each big indexes. 

**WARNING**

* **Only ascending natural numbers are permitted** as the directory names.  

Inside each big index subdirectories, there are .csv files for each small indexes. The files should be only .csv files (or .txt file split with commas[,]). 

**WARNING**

* the files should only be **.scv files**.
* the file name should be of following syntax; 
* **[bigindex]-[smallindex].csv**    ex) 1-3.csv

In each .csv files, the information of each problem is stored. There are 7 columns; problem number, problem question passage, the answer, and 4 different wrong choices.

These files should be manually put.

## 3. Let's generate exam sheet
By now, you'ill have 3 things in your root directory; question bank, config file, and the generateExams.jar file.

All you need to do is, double-click file generateExams.jar. 
If the bank is classified properly and if the config is plausible, two(or three) files should be made. One is the exam sheet, and the other is its answer sheet(One optional is chapters_DO_NOT_ERASE.txt file. This is a supportive file that shortens program running time.) 



