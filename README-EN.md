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


## 2. question bank
As described, this directory (hereafter referred to as root bank) is where you put your information of your qustion pool.

This program is designed for two-level-indexed problems.

In the root bank, there are subdirectories representing each big indexes. 

**WARNING**

* **Only ascending natural numbers are permitted** as the directory names.  

Inside each big index subdirectories, there are .csv files for each small indexes. The files should be only .csv files (or .txt file split with commas[,]). 





