package com.archivators;

import java.io.IOException;

public interface IArchive {
    void archive(String archive_name, String file_name) throws IOException;
    void unarchive(String archive_name) throws IOException;
    String getExtension();
}
