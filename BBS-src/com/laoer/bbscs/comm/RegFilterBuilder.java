package com.laoer.bbscs.comm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Title: TianyiBBS</p>
 *
 * <p>Description: BBSCS</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: Laoer.com</p>
 *
 * @author Laoer
 * @version 7.0
 */
public class RegFilterBuilder
    implements FilterBuilder {

  private String regex = null;
  private String rpStr = null;
  private String source = null;
  private String result = null;

  public RegFilterBuilder(String regex, String rpStr, String source) {
    super();
    this.regex = regex;
    this.rpStr = rpStr;
    this.source = source;
  }

  public void buildFilter() {
    if (this.regex == null) {
      return;
    }
    Pattern p = Pattern.compile(regex, 2);
    Matcher matcher = p.matcher(this.source);
    StringBuffer sb = new StringBuffer();
    String tempString = rpStr;
    int rpL = rpStr.split("\\$[0-9]+").length;
    while (matcher.find()) {
      for (int i = 0; (i < rpL) && (i < matcher.groupCount()); i++) {
        tempString = tempString.replaceAll("\\$" + i, matcher.group(i));
      }
      matcher.appendReplacement(sb, tempString);
    }
    matcher.appendTail(sb);
    this.result = sb.toString();
  }

  public Filter getFilter() {
    return (new RegexFilter() {
      public String getFilteredStr() {
        return result;
      }
    });
  }

}
