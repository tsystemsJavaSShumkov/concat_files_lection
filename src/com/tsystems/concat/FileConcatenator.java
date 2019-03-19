package com.tsystems.concat;

import java.io.*;
import java.util.List;

public final class FileConcatenator
{
  private FileConcatenator()
  {
    throw new AssertionError();
  }

  public static void concatFiles(final List<File> files)
  {
    try (BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Result.txt"))))
    {
      for (File file : files)
      {
        try(BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(file))))
        {
          String line;
          while ((line = in.readLine()) != null)
          {
            out.write(line + "\r\n");
          }
        }
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
