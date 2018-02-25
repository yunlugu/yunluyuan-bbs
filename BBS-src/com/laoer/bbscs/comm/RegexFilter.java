package com.laoer.bbscs.comm;

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
public class RegexFilter
    implements Filter {

  protected String regex = "";
  protected String rpStr = "";
  protected String source = "";
  protected String tempSource = "";
  protected Filter filter = null;

  public RegexFilter() {
  }

  public RegexFilter(String regex, String rpStr, String source) {
    this.regex = regex;
    this.rpStr = rpStr;
    this.source = source;
    this.tempSource = source;
    this.applyFilter();
  }

  protected RegexFilter(String source) {
    this.source = source;
    this.tempSource = source;
  }

  protected void applyFilter() {
    FilterBuilder builder = new RegFilterBuilder(regex, rpStr, tempSource);
    FilterDirector direct = new FilterDirector(builder);
    direct.construct();

    this.filter = builder.getFilter();
  }

  public String getFilteredStr() {
    return filter.getFilteredStr();
  }

  protected void doFiltration() {
    this.applyFilter();
    this.tempSource = filter.getFilteredStr();
  }

}
