package com.oliver1002pohl;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Main.clearDirectory("C:\\Users\\olive\\Documents\\tmp");
		Main.clearDirectory("C:\\Users\\olive\\Pictures\\tmp");
		Main.clearDirectory("C:\\Users\\olive\\Downloads\\tmp");
		ArrayList<Path> target = new ArrayList<Path>();
		FileSystems.getDefault().getRootDirectories().forEach(target::add);
		Main.spaceControl(target.get(0).toString());
	}

	static void clearDirectory(String dir) {
		File f = new File(dir);
		for (String s : f.list()) {
			File clearFile = new File(String.valueOf(dir) + "/" + s);
			if (clearFile.isDirectory()) {
				Main.clearDirectory(clearFile.getAbsolutePath());
			}
			clearFile.delete();
		}
	}

	static void spaceControl(String dir) {
		File f = new File(dir);
		if ((double) f.getUsableSpace() <= 5.0 * Math.pow(10.0, 9.0)) {
			JOptionPane.showMessageDialog(null, "Achtung der Speicher l\u00e4uft voll!", "Speicherplatz-Warnung", 2);
		}
	}
}
