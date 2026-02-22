package builder;

public class ReportDirector {
    public void constructReport(IReportBuilder builder) {
        builder.setHeader("Отчет за февраль");
        builder.setContent("Содержимое отчета...");
        builder.setFooter("Конец отчета");
    }
}
