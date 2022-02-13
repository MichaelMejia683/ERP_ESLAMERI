/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import java.awt.Desktop;
import java.io.*; 
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 /*
 * @author MAICOL MEJA
 */

public class VolantePago {
    public static String archivo = System.getProperty("user.dir")+"/volante.pdf";


    public int crearVolante(Nomina_Empleado Empleado) throws DocumentException{
    EmpleadoDAO emple = new EmpleadoDAO();
    ObservableList<Empleado> listEmple;
    ContratoDAO contrato = new ContratoDAO();
    ObservableList<Contrato> listContra;
    EmpresaDAO empre = new EmpresaDAO();
    ObservableList<Empresa> listEmpresa;
        //Declaramos un documento como un objecto Document. 
        Document documento = new Document(PageSize.LETTER,80, 80, 75, 75);
        //writer es declarado como el método utilizado para escribir en el archivo.
        PdfWriter writer = null;

       try{
            //Obtenemos la instancia del archivo a utilizar.
            writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo));
        }catch(FileNotFoundException | DocumentException ex){
            ex.getMessage();
        }
       
       //Creamos la tabla para insertar datos
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(80);
        PdfPTable table2 = new PdfPTable(2);
        table2.setWidthPercentage(80);

        //Agregamos un título al documento.
        documento.addTitle("Volante Pago");

        //Abrimos el documento a editar.
        documento.open();       

        //Declaramos un texto como Paragraph. Le podemos dar formato alineado, tamaño, color, etc.
        Paragraph titulo = new Paragraph();
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        titulo.setFont(FontFactory.getFont("Times New Roman", 14, Font.BOLD, BaseColor.BLACK));
        titulo.add("***VOLANTE DE PAGO***");

        try{
            //Agregamos el texto al documento.
            documento.add(titulo);
        }catch(DocumentException ex){
            ex.getMessage();
        }

        //Creamos un párrafo nuevo llamado "saltolinea" simulando un salto de linea para espaciar
        //los elementos del PDF.
        Paragraph saltolinea = new Paragraph();
        saltolinea.add("\n\n");
        documento.add(saltolinea);

        listEmple = FXCollections.observableArrayList();
        emple.listadoEmpleado("0", listEmple);

        String name = null;
        String idContra = null;
        String cargo = null;
        for(int i = 0;i < listEmple.size(); i++){
        if(Empleado.getIdEmpleado().equals(listEmple.get(i).getIdEmpleado())){
        name = listEmple.get(i).getNombre();
        idContra = listEmple.get(i).getIdContrato();
        cargo = listEmple.get(i).getCargo();
        }
        }

        listContra = FXCollections.observableArrayList();
        contrato.listadoContrato("0", listContra);

        String idEmpre = null;
        for(int i = 0;i < listContra.size(); i++){
        if(idContra.equals(listContra.get(i).getIdContrato())){
        idEmpre = listContra.get(i).getIdEmpresa();
        }
        }

        listEmpresa = FXCollections.observableArrayList();
        empre.listadoEmpresa("0", listEmpresa);

        String empreName = null;
        for(int i = 0;i < listEmpresa.size() ; i++){
        if(idEmpre.equals(listEmpresa.get(i).getIdEmpresa())){
        empreName = listEmpresa.get(i).getNombre();
        }
        }

        //Creamos un párrafo llamado "parrafo" donde irá el contenido del PDF.
        Paragraph columna2 = new Paragraph("FECHA");
        columna2.getFont().setStyle(Font.BOLD);
        columna2.getFont().setSize(9);
        table2.addCell(columna2);
        table2.addCell(LocalDate.now().toString());
        Paragraph columna3 = new Paragraph("EMPLEADO");
        columna3.getFont().setStyle(Font.BOLD);
        columna3.getFont().setSize(9);
        table2.addCell(columna3);
        table2.addCell(name);
        Paragraph columna1 = new Paragraph("CEDULA");
        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(9);
        table2.addCell(columna1);
        table2.addCell(Empleado.getIdEmpleado());
        Paragraph columna6 = new Paragraph("CARGO");
        columna6.getFont().setStyle(Font.BOLD);
        columna6.getFont().setSize(9);
        table2.addCell(columna6);
        table2.addCell(cargo);
        Paragraph columna11 = new Paragraph("EMPRESA");
        columna11.getFont().setStyle(Font.BOLD);
        columna11.getFont().setSize(9);
        table2.addCell(columna11);
        table2.addCell(empreName);


        documento.add(table2);
        documento.add(saltolinea);

        Paragraph columna4 = new Paragraph("SALARIO");
        columna4.getFont().setStyle(Font.BOLD);
        columna4.getFont().setSize(9);
        table.addCell(columna4);
        table.addCell(Empleado.getSalarioBase());
        if(Empleado.getHorasExtraDiurna().equals("0")){
        }else{
        Paragraph columna7 = new Paragraph("HORA EXTRA DIURNA");
        columna7.getFont().setStyle(Font.BOLD);
        columna7.getFont().setSize(9);
        table.addCell(columna7);
        table.addCell(Empleado.getHorasExtraDiurna()+" HORAS");
        }
        if(Empleado.getHoraExtraNocturno().equals("0")){
        }else{
        Paragraph columna8 = new Paragraph("HORA EXTRA NOCTURNA");
        columna8.getFont().setStyle(Font.BOLD);
        columna8.getFont().setSize(9);
        table.addCell(columna8);
        table.addCell(Empleado.getHoraExtraNocturno()+" HORAS");
        }
        if(Empleado.getHoraDominical().equals("0")){
        }else{
        Paragraph columna9 = new Paragraph("HORA DOMINICAL");
        columna9.getFont().setStyle(Font.BOLD);
        columna9.getFont().setSize(9);
        table.addCell(columna9);
        table.addCell(Empleado.getHoraDominical()+" HORAS");
        }
        if(Empleado.getDescuentos().equals("0")){
        }else{
        Paragraph columna10 = new Paragraph("DESCUENTOS");
        columna10.getFont().setStyle(Font.BOLD);
        columna10.getFont().setSize(9);
        table.addCell(columna10);
        table.addCell(Empleado.getDescuentos()+" HORAS");
        }        
            //Añadimos ese tabla "table" al documento "documento".
        documento.add(table);
        documento.add(saltolinea);

        Paragraph salarioTotal = new Paragraph();
        salarioTotal.add("            SALARIO TOTAL ---------> "+Empleado.getSalarioTotal());
        documento.add(salarioTotal);

        //Cerramos el documento.
        documento.close();
        //Cerramos el writer.
        writer.close();
        
    return 1;
    }
    
    public void abrirarchivo(String archivo){

     try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);
}
    }

}
    
