import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.text.*;

public class test {

    public static void main(String[] args)
    {
        test p = new test() ;
        Node tf = p.creaTesto();
        p.stampa(tf);
    }

    public Node creaTesto( )
    {
        String s1 = "Dear Mom," + "\n"
                +   " I am going out dancing tonight with :" + "\n\n\n"  ;

        String f1 = " (girl) friend 1" + "\n" +
                "        friend 2" + "\n" +
                " (girl) friend 3" + "\n\n\n\n"  ;

        String closing = "don't wait for me" + "\n\n\n\n"
                + "bye" + "\n\n" ;


        Text t1 = new Text (s1);
        Text t2 = new Text (f1);
        Text t3 = new Text (closing) ;

        t1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        t2.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        t3.setFont(Font.font("Tahoma", FontPosture.ITALIC, 20));

        TextFlow textFlow = new TextFlow() ; ;
        try {

            //Setting the width
            textFlow.setPrefSize(2480, 3508); // 2480 X 3508 = A4(300)

            //Setting the line spacing
            textFlow.setLineSpacing(5.0);

            //Retrieving the observable list of the TextFlow Pane
            textFlow.getChildren().addAll(t1, t2, t3);



            ////////////////////
                        StringBuilder sb = new StringBuilder();
                        for (Node node : textFlow.getChildren())
                        {
                         if (node instanceof Text)
                         {
                           sb.append(((Text) node).getText());
                         }            }
            String fullText = sb.toString();
                        System.out.println("fulltext => " + fullText);
               } catch (Exception e) {
System.out.println(e);
       }
        return textFlow;
    }

    public void stampa (Node n2p)
    {
        Printer printer = Printer.getDefaultPrinter();

        javafx.print.PageLayout pageLayout = printer.createPageLayout
                (
                        Paper.A4,
                        PageOrientation.PORTRAIT,
                        Printer.MarginType.DEFAULT
                );

        PrinterJob job = PrinterJob.createPrinterJob();
        boolean result = job.printPage(pageLayout, n2p);
        System.out.println(" print result => " + result);// this gives true

        job.endJob();
    }
}