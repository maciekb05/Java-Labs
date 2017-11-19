import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subtitles {
    public static void delay(String fileIn, String fileOut, Integer delay, Integer fps) throws Exception {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut));
                String line;
                Integer lineNumber = 0;
                String expression = "^\\{(\\d+)}\\{(\\d+)}(.*)";
                Pattern pattern = Pattern.compile(expression);
                try{
                    while ((line = bufferedReader.readLine()) != null) {
                        Matcher matcher = pattern.matcher(line);
                        Integer startTime;
                        Integer endTime;
                        lineNumber += 1;
                        if (matcher.find()) {
                            startTime = Integer.valueOf(matcher.group(1));
                            endTime = Integer.valueOf(matcher.group(2));
                        } else {
                            throw new CouldNotFoundFrames(line, lineNumber);
                        }

                        if (startTime >= endTime) {
                            throw new WrongOrderOfTimes(line, lineNumber);
                        }

                        startTime += delay * fps;
                        endTime += delay * fps;

                        bufferedWriter.write("{" + startTime + "}{" + endTime + "}" + matcher.group(3));
                        bufferedWriter.newLine();
                    }
                } finally {
                    bufferedReader.close();
                    bufferedWriter.close();
                }

            }catch(IOException ex) {
                System.out.println(ex.getMessage());
                throw ex;
            }
    }
}
