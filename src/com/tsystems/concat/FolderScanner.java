package com.tsystems.concat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderScanner
{
  private File enterFile;

  public FolderScanner(final String path)
  {
    this.enterFile = new File(path);
  }

  List<File> scanFolderWithSubfolders()
  {
    final List<File> files=new ArrayList<>();

    final File[] listFiles=enterFile.listFiles();
    for (File f : listFiles)
    {
      if (f.isDirectory())
      {
        final FolderScanner fs=new FolderScanner(f.getPath());
        files.addAll(fs.scanFolderWithSubfolders());
      }
      else
      {
        files.add(f);
      }
    }
    return files;
  }

}
