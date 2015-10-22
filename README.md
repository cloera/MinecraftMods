# MinecraftMods
This is the mod repo for the Chicago City Server

##Getting started 
Download the source for forge mod loader. We are still running 1.7.10 since that is what computer craft uses
![alt tag](https://github.com/Digital-Youth-Network/MinecraftMods/blob/master/forgeimg.PNG)
http://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.7.10.html

###Make sure you have eclipse installed and the most recent JDK
####Eclipse: 
Get the one that is for java developers
![alt tag](https://github.com/Digital-Youth-Network/MinecraftMods/blob/master/eclipseimg.PNG)
http://www.eclipse.org/downloads/



####JDK:
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

After extracting the files navigate to the folder location with either the terminal or command window based on your OS for windows type this into the command window 

    gradlew setupDecompWorkspace eclipse
	
for terminal windows

    ./gradlew setupDecompWorkspace eclipse
  
Once it completes the build open eclipse and set your workspace to the eclipse folder that was created when you unzipped the source from forge. You will see that a minecraft folder exists, open the folder and you will see a bunch of folders and files. You probably don't need to change any of them but your environment should be ready for you
