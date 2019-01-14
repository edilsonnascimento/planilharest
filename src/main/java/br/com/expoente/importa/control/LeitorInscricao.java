package br.com.expoente.importa.control;

import br.com.expoente.importa.entity.Inscricao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeitorInscricao {

    public static void main(String[] args) throws FileNotFoundException, IOException{


            File caminhoArquivo = new File("/home/ednascimento/Downloads/modelo-inscricao-alunos-aprova-mais viarias.xlsx");
            //File caminhoArquivo = new File("/home/ednascimento/Downloads/modelo-inscricao-alunos-aprova-mais.xlsx");
            FileInputStream arquivo = new FileInputStream(caminhoArquivo);

            XSSFWorkbook planilha = new XSSFWorkbook(arquivo);

            for (int p = 0; p < planilha.getNumberOfSheets(); p++) {
                XSSFSheet aba = planilha.getSheetAt(p);


                try {
                    if (! aba.getRow(7).getCell(0).getStringCellValue().isEmpty()) {
                        System.out.println("IMPORTANDO DADOS DA ABA: " + aba.getSheetName() + "\n");
                    }
                    
                } catch (Exception e) {
                        System.out.println("\n ABA: " + aba.getSheetName() + " ESTA ZERADA\n");                        
                        break;
                }

                for (int i = 7; i <= aba.getLastRowNum(); i++) {
                    if (! aba.getRow(i).getCell(0).getStringCellValue().isEmpty()){
                        Row registro = aba.getRow(i);
                        Inscricao inscricao = new Inscricao();
                        inscricao.setCod_cliente_sga(180504);
                        System.out.print(" | " + inscricao.getCod_cliente_sga());
                        for (int j = 0; j < 4; j++) {

                                Cell celula = registro.getCell(j);

                                switch (celula.getColumnIndex()) {
                                    case 0:
                                        inscricao.setNm_inscrito(celula.getStringCellValue());
                                        System.out.print(" | " + inscricao.getNm_inscrito());
                                        break;
                                    case 1:
                                        inscricao.setNm_serie(celula.getStringCellValue());
                                        System.out.print(" | " + inscricao.getNm_serie());
                                        break;
                                    case 2:
                                        Double d;
                                        if (Cell.CELL_TYPE_STRING != celula.getCellType()) {
                                            d = celula.getNumericCellValue();
                                            inscricao.setNm_turma(d.toString());
                                        } else {
                                            inscricao.setNm_turma(celula.getStringCellValue());
                                        }
                                        System.out.print(" | " + inscricao.getNm_turma());
                                        break;
                                    case 3:
                                        inscricao.setNm_turno(celula.getStringCellValue());
                                        System.out.print(" | " + inscricao.getNm_turno());
                                        break;
                                }//case                       
                        }//for
                        System.out.println();
                    }//if
                }
                System.out.println();
            }
            arquivo.close();


    }//main

}//class
