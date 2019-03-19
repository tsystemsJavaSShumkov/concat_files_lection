package com.tsystems.concat;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Application
{
  public static void main(String[] args)
  {
    final Scanner scanner=new Scanner(System.in);

    System.out.println("Enter directory path: ");
    final String path=scanner.nextLine();
    final FolderScanner fs=new FolderScanner(path);
    final List<File> files=fs.scanFolderWithSubfolders();
    FileConcatenator.concatFiles(files);
  }
}
