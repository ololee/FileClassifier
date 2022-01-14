package cn.ololee.fileclassifier;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
  @Test
  public void addition_isCorrect() {
    assertEquals(4, 2 + 2);
  }

  @Test
  public void map_test(){

    Map<Integer, List<String>> triesMap = new HashMap<>();
    Set<Integer> integers = triesMap.keySet();
    Iterator<Integer> iterator = integers.iterator();
    while (iterator.hasNext()){
      Integer next = iterator.next();
      next.intValue();
      List<String> strings = triesMap.get(next);
      int size = strings.size();
      for (int i = 0; i < size; i++) {
        //do insert
        String s = strings.get(i);
        throw new NullPointerException("");
      }
    }
  }


  @Test
  public void textDeal(){
    String text ="#define TYPE_UNKNOWN 0x00\n"
        + "#define TYPE_FOLDER 0x0100\n"
        + "#define TYPE_IMAGE 0x0200\n"
        + "#define TYPE_VIDEO_OR_AUDIO 0x0300\n"
        + "#define TYPE_VIDEO 0x0301\n"
        + "#define TYPE_AUDIO  0x0302\n"
        + "#define TYPE_DOC  0x0400\n"
        + "#define TYPE_DOC_PDF  0x0401\n"
        + "#define TYPE_DOC_PPT  0x0402\n"
        + "#define TYPE_DOC_EXCEL  0x0403\n"
        + "#define TYPE_DOC_WORD  0x0404\n"
        + "#define TYPE_DOC_TXT  0x0405\n"
        + "#define TYPE_DOC_WEB  0x0406\n"
        + "#define TYPE_COMPRESS 0x0500\n"
        + "#define TYPE_EXECUTE 0x0600\n"
        + "#define TYPE_HIDDEN 0x0700";
    String[] lines = text.replaceAll("#define","").split("\n");
    for (String line : lines) {
      String[] s = line.split("\\s+");
      System.out.println(String.format("int %s = %s;", s[1],s[2]));
    }
  }
}