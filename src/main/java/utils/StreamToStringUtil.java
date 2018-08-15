package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class StreamToStringUtil {

    public static String toString(InputStream sqlStream) {
        return new BufferedReader(new InputStreamReader(sqlStream))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
