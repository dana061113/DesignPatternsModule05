package builder;

public class TextReportBuilder implements IReportBuilder {
    private Report report = new Report();
    public void setHeader(String header) { report.setHeader(header); }
    public void setContent(String content) { report.setContent(content); }
    public void setFooter(String footer) { report.setFooter(footer); }
    public Report getReport() { return report; }
}
